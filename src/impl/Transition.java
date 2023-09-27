package impl;

import interfaces.ITransition;

/**
 * Class representing a single transition for an FSM, equivalent to a row in a transition table.
 */
public class Transition implements ITransition {

    private final int CURRENT_STATE; /** Object representing the current state of the transition. */
    private final char INPUT; /** Object representing the input of the transition. */
    private final char OUTPUT; /** Object representing the output of the transition. */
    private final int NEXT_STATE; /** Object representing the next state of the transition. */

    /**
     * Simple getter object which grabs the current state of the transition.
     * @return integer for the current state
     */
    @Override
    public int getCurrentState() {
        return this.CURRENT_STATE;
    }

    /**
     * Simple getter object which grabs the input of the transition.
     * @return char for the input
     */
    @Override
    public char getInput() {
        return this.INPUT;
    }

    /**
     * Simple getter object which grabs the output of the transition.
     * @return char for the output
     */
    @Override
    public char getOutput() {
        return this.OUTPUT;
    }

    /**
     * Simple getter object which grabs the next state of the transition.
     * @return integer for the next state
     */
    @Override
    public int getNextState() {
        return this.NEXT_STATE;
    }

    /**
     * This constructor takes the given input for a transition and set the local private
     * variables.
     * @param CURRENT_STATE an integer with the current state
     * @param INPUT a char with the input value
     * @param OUTPUT a char with the output value
     * @param NEXT_STATE an integer with the next state
     */
    public Transition(int CURRENT_STATE, char INPUT, char OUTPUT, int NEXT_STATE) {
        this.CURRENT_STATE = CURRENT_STATE;
        this.INPUT = INPUT;
        this.OUTPUT = OUTPUT;
        this.NEXT_STATE = NEXT_STATE;
    }

}
