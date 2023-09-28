package impl;

import interfaces.ITransition;

/**
 * Class representing a single transition for an FSM, equivalent to a row in a transition table.
 */
public class Transition implements ITransition {

    private final int currentState; /** Object representing the current state of the transition. */
    private final char input; /** Object representing the input of the transition. */
    private final char output; /** Object representing the output of the transition. */
    private final int nextState; /** Object representing the next state of the transition. */

    /**
     * Simple getter object which grabs the current state of the transition.
     * @return integer for the current state
     */
    @Override
    public int getCurrentState() {
        return this.currentState;
    }

    /**
     * Simple getter object which grabs the input of the transition.
     * @return char for the input
     */
    @Override
    public char getInput() {
        return this.input;
    }

    /**
     * Simple getter object which grabs the output of the transition.
     * @return char for the output
     */
    @Override
    public char getOutput() {
        return this.output;
    }

    /**
     * Simple getter object which grabs the next state of the transition.
     * @return integer for the next state
     */
    @Override
    public int getNextState() {
        return this.nextState;
    }

    /**
     * This constructor takes the given input for a transition and set the local private
     * variables.
     * @param currentState an integer with the current state
     * @param input a char with the input value
     * @param output a char with the output value
     * @param nextState an integer with the next state
     */
    public Transition(int currentState, char input, char output, int nextState) {
        this.currentState = currentState;
        this.input = input;
        this.output = output;
        this.nextState = nextState;
    }

}
