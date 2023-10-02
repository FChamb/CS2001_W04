package test;

import exceptions.BadInputException;
import exceptions.NDTransitionException;
import impl.Transition;
import interfaces.ITransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import impl.Factory;
import interfaces.IFactory;
import interfaces.ITransitionTable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a JUnit test class for the FSM ADT.
 */
public class TestTransitionTable {


    private IFactory factory;
    private ITransitionTable transitionTable;


    /**
     * JUnit setup method to run before every other test.
     */
    @BeforeEach
    public void setup() {
        factory = Factory.getInstance();
        transitionTable = factory.makeTransitionTable();
    }


    /**
     * This checks that the factory was able to call a sensible constructor to get a non-null instance of ITransitionTable.
     */
    @Test
    public void transitionTableCreationNonNull() {
        assertNotNull(transitionTable);
    }

    /**
     * This checks that the factory was able to add a Transition to the transition table.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableAddTransition() throws NDTransitionException, BadInputException {
        ITransition transition = new Transition(1, 'a', '.', 2);
        transitionTable.addTransition(transition);
        assertEquals(transition, transitionTable.getTransition(transition.getCurrentState(), transition.getInput()));
    }

    /**
     * This checks that the factory can detect adding a transition that already exists in the table.
     * @throws NDTransitionException if the transition already exists, in this test it should be thrown
     */
    @Test
    public void transitionTableAddTransitionThatExists() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', '.', 2);
        ITransition transition2 = new Transition(1, 'a', '.', 2);
        transitionTable.addTransition(transition);
        assertThrows(NDTransitionException.class, () -> transitionTable.addTransition(transition2));
    }

    /**
     * This checks that the proper error is thrown when grabbing a transition with a wrong input value.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     * @throws BadInputException if the given current_state is not in the table or the given input character is not an element of the input alphabet this test should be thrown
     */
    @Test
    public void transitionTableGetTransitionWithWrongCurrentState() throws NDTransitionException, BadInputException {
        ITransition transition = new Transition(1, 'a', '.', 2);
        transitionTable.addTransition(transition);
        assertThrows(BadInputException.class, () -> transitionTable.getTransition(2, transition.getInput()));
    }

    /**
     * This checks that the proper error is thrown when grabbing a transition with a wrong input value.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     * @throws BadInputException if the given current_state is not in the table or the given input character is not an element of the input alphabet this test should be thrown
     */
    @Test
    public void transitionTableGetTransitionWithWrongInput() throws NDTransitionException, BadInputException {
        ITransition transition = new Transition(1, 'a', '.', 2);
        transitionTable.addTransition(transition);
        assertThrows(BadInputException.class, () -> transitionTable.getTransition(transition.getCurrentState(), 'b'));
    }

    /**
     * This checks that the transition table has no illegal states given valid transitions.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableNoIllegalStates() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', 'e', 2);
        ITransition transition2 = new Transition(2, 'b', 'e', 1);
        transitionTable.addTransition(transition);
        transitionTable.addTransition(transition2);
        assertFalse(transitionTable.hasTransitionsToIllegalStates());
    }

    /**
     * This checks that the transition table has no illegal states given valid transitions.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableHasIllegalStates() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', '.', 3);
        ITransition transition2 = new Transition(2, 'b', '_', 1);
        transitionTable.addTransition(transition);
        transitionTable.addTransition(transition2);
        assertTrue(transitionTable.hasTransitionsToIllegalStates());
    }

    /**
     * This checks that the transition table has no missing inputs given valid transitions.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableNoMissingInputs() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', 'e', 2);
        ITransition transition2 = new Transition(2, 'b', 'e', 1);
        transitionTable.addTransition(transition);
        transitionTable.addTransition(transition2);
        assertTrue(transitionTable.hasMissingInputs());
    }

    /**
     * This checks that the transition table has no missing inputs given valid transitions.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableHasMissingInputs() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', 'e', 2);
        ITransition transition2 = new Transition(1, 'b', 'e', 1);
        transitionTable.addTransition(transition);
        transitionTable.addTransition(transition2);
        assertFalse(transitionTable.hasMissingInputs());
    }

    /**
     * This checks that the transition table has no missing inputs given valid transitions this time
     * with one valid transition.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableMissingInputsWithOneTransition() throws NDTransitionException {
        ITransition transition = new Transition(1, 'a', 'e', 2);
        transitionTable.addTransition(transition);
        assertFalse(transitionTable.hasMissingInputs());
    }

    /**
     * This checks that the transition table has no missing inputs given valid transitions this time with
     * no valid transitions.
     * @throws NDTransitionException if the transition already exists, in this test we ignore
     */
    @Test
    public void transitionTableMissingInputsWithNoTransition() throws NDTransitionException {
        assertFalse(transitionTable.hasMissingInputs());
    }



}
