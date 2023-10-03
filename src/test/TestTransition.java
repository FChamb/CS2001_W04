package test;

import impl.Factory;
import interfaces.IFactory;
import interfaces.ITransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a JUnit test class for the Transition ADT.
 */
public class TestTransition {


    private static final int CURRENT_STATE = 1;
    private static final char INPUT = 'a';
    private static final char OUTPUT = '.';
    private static final int NEXT_STATE = 2;

    private IFactory factory;


    /**
     * JUnit setup method to run before every other test.
     */
    @BeforeEach
    public void setup() {
        factory = Factory.getInstance();
    }


    /**
     * This checks that the factory was able to call a sensible constructor to get a non-null instance of ITransition.
     */
    @Test
    public void transitionCreationNonNull() {
        ITransition transition = factory.makeTransition(CURRENT_STATE, INPUT, OUTPUT, NEXT_STATE);
        assertNotNull(transition);
    }

    /**
     * This checks that the Transition is able to grab the current state.
     */
    @Test
    public void transitionCurrentState() {
        ITransition transition = factory.makeTransition(CURRENT_STATE, INPUT, OUTPUT, NEXT_STATE);
        assertEquals(1, transition.getCurrentState());
    }

    /**
     * This checks that the Transition is able to grab the input.
     */
    @Test
    public void transitionInput() {
        ITransition transition = factory.makeTransition(CURRENT_STATE, INPUT, OUTPUT, NEXT_STATE);
        assertEquals('a', transition.getInput());
    }

    /**
     * This checks that the Transition is able to grab the output.
     */
    @Test
    public void transitionOutput() {
        ITransition transition = factory.makeTransition(CURRENT_STATE, INPUT, OUTPUT, NEXT_STATE);
        assertEquals('.', transition.getOutput());
    }

    /**
     * This checks that the Transition is able to grab the next state.
     */
    @Test
    public void transitionNextState() {
        ITransition transition = factory.makeTransition(CURRENT_STATE, INPUT, OUTPUT, NEXT_STATE);
        assertEquals(2, transition.getNextState());
    }

}
