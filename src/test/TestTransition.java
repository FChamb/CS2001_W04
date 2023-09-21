package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import impl.Factory;
import interfaces.IFactory;
import interfaces.ITransition;

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


    /* ... and more tests of your own below here to test the ADT ... */

}
