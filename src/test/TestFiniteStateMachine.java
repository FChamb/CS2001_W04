package test;

import exceptions.BadInputException;
import exceptions.BadTableException;
import exceptions.NDTransitionException;
import impl.Factory;
import interfaces.IFactory;
import interfaces.IFiniteStateMachine;
import interfaces.ITransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a JUnit test class for the FSM ADT.
 */
public class TestFiniteStateMachine {


    private static final int STATE1 = 1;

    private static final char INPUT1 = 'a';

    private static final char OUTPUT1 = 'e';

    private IFactory factory;
    private IFiniteStateMachine fsm;


    /**
     * JUnit setup method to run before every other test.
     */
    @BeforeEach
    public void setup() {
        factory = Factory.getInstance();
        fsm = factory.makeFiniteStateMachine();
    }

    /**
     * This checks that the factory was able to call a sensible constructor to get a non-null instance of IFiniteStateMachine.
     */
    @Test
    public void fsmCreationNonNull() {
        assertNotNull(fsm);
    }


    /**
     * Checks whether a simple FSM with a single state and input works as expected when supplied with that input.
     * @throws BadTableException should not be thrown during this test
     * @throws BadInputException should not be thrown during this test
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void singleStateFSMWorks() throws BadTableException, BadInputException, NDTransitionException {
        ITransition t1 = factory.makeTransition(STATE1, INPUT1, OUTPUT1, STATE1);
        fsm.addTransition(t1);
        assertEquals("eee", fsm.interpret("aaa"));
    }


    /**
     * Checks whether a simple FSM with two states and two inputs works as expected when supplied with valid inputs.
     * @throws BadTableException should not be thrown during this test
     * @throws BadInputException should not be thrown during this test
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void simplTwoStateFSMWorks() throws BadTableException, BadInputException, NDTransitionException {
        fsm.addTransition(factory.makeTransition(1, 'a', 'e', 1));
        fsm.addTransition(factory.makeTransition(1, 'b', 'o', 2));
        fsm.addTransition(factory.makeTransition(2, 'a', 'o', 2));
        fsm.addTransition(factory.makeTransition(2, 'b', 'e', 1));
        assertEquals("eoo", fsm.interpret("aba"));
    }

    /**
     * Checks whether a slightly bigger FSM with three states and two inputs works as expected when supplied with valid inputs.
     * @throws BadTableException should not be thrown during this test
     * @throws BadInputException should not be thrown during this test
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void simplThreeStateFSMWorks() throws BadTableException, BadInputException, NDTransitionException {
        fsm.addTransition(factory.makeTransition(7, '1', '1', 5));
        fsm.addTransition(factory.makeTransition(7, '2', '0', 7));
        fsm.addTransition(factory.makeTransition(5, '1', '2', 6));
        fsm.addTransition(factory.makeTransition(5, '2', '0', 6));
        fsm.addTransition(factory.makeTransition(6, '1', '3', 7));
        fsm.addTransition(factory.makeTransition(6, '2', '0', 6));
        assertEquals("12300", fsm.interpret("11122"));
    }

    /**
     * Checks whether a duplicate transition can be added to fsm.
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void addDuplicateTransition() throws NDTransitionException {
        ITransition t1 = factory.makeTransition(STATE1, INPUT1, OUTPUT1, STATE1);
        ITransition t2 = factory.makeTransition(STATE1, INPUT1, OUTPUT1, STATE1);
        fsm.addTransition(t1);
        assertThrows(NDTransitionException.class, () -> fsm.addTransition(t2));
    }

    /**
     * Checks whether a null transition can be added to fsm.
     */
    @Test
    public void addNullTransition() {
        assertThrows(NDTransitionException.class, () -> fsm.addTransition(null));
    }

    /**
     * Checks whether the finite state machine can recognize a transition table with next states that
     * do not exist as current states.
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void invalidStateWithInvalidInput() throws NDTransitionException {
        ITransition t1 = factory.makeTransition(STATE1, INPUT1, OUTPUT1, 2);
        ITransition t2 = factory.makeTransition(1, 'e', 'a', 1);
        fsm.addTransition(t1);
        fsm.addTransition(t2);
        assertThrows(BadTableException.class, () -> fsm.interpret("aea"));
    }

    /**
     * Checks whether the finite state machine can recognize a transition table with illegal states.
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void addIllegalStateTransitionsToFSM() throws NDTransitionException {
        ITransition t1 = factory.makeTransition(STATE1, INPUT1, OUTPUT1, 3);
        ITransition t2 = factory.makeTransition(2, 'e', 'a', 1);
        fsm.addTransition(t1);
        fsm.addTransition(t2);
        assertThrows(BadTableException.class, () -> fsm.interpret("ae"));
    }

    /**
     * Checks whether the finite state machine can recognize an input sequence with invalid inputs.
     * @throws NDTransitionException should not be thrown during this test
     */
    @Test
    public void badInputException() throws NDTransitionException {
        fsm.addTransition(factory.makeTransition(1, 'a', 'e', 1));
        fsm.addTransition(factory.makeTransition(1, 'b', 'o', 1));
        assertThrows(BadInputException.class, () -> fsm.interpret("abc"));
    }


}
