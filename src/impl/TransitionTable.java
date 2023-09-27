package impl;

import exceptions.BadInputException;
import exceptions.NDTransitionException;
import interfaces.ITransition;
import interfaces.ITransitionTable;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class representing a transition table for an FSM.
 * 
 */
public class TransitionTable implements ITransitionTable {

    private ArrayList<ITransition> transitionTable; /** An array list containing all the transitions in the table */
    private HashSet<Integer> validStates; /** A hashset containing all the valid states in the transition table */
    private HashSet<Character> validInputs; /** A hashset containing all the valid inputs in the transition table */

    /**
     * This method is a simple add methods which uses a try/catch loop to check if the transition table already
     * has a given transition in it. If it does than an NDTransitionExpception is thrown. Otherwise, the transition
     * is added to the table.
     * @param transition the transition to add
     * @throws NDTransitionException when the transition table already contains another transition with the same current_state and input pair
     */
    @Override
    public void addTransition(ITransition transition) throws NDTransitionException {
        try {
            getTransition(transition.getCurrentState(), transition.getInput());
            throw new NDTransitionException();
        } catch (BadInputException e) {
            this.transitionTable.add(transition);
            this.validStates.add(transition.getCurrentState());
            this.validInputs.add(transition.getInput());
        }
    }

    /**
     * This method is a simple getter method which uses a for loop to cycle through every transition in
     * the table and select the one with the given current state and input. A BadInputException is thrown
     * if the value is not in the table.
     * @param current_state the current state to use
     * @param input the input to use
     * @return the ITransition object for the given state and input
     * @throws BadInputException if the given current_state is not in the table or the given input character is not an element of the input alphabet
     */
    @Override
    public ITransition getTransition(int current_state, char input) throws BadInputException {
        for (int i = 0; i < this.transitionTable.size(); i++) {
            int thisState = this.transitionTable.get(i).getCurrentState();
            char thisInput = this.transitionTable.get(i).getInput();
            if (thisState == current_state && thisInput == input) {
                return this.transitionTable.get(i);
            }
        }
        throw new BadInputException();
    }

    /**
     * This method uses a nested for loop to check if each valid state has a pointer to an appropriate next state
     * integer in each transition. A boolean true is returned if next state ever
     * @return
     */
    @Override
    public boolean hasTransitionsToIllegalStates() {
        for (ITransition transition : this.transitionTable) {
            for (Integer state : this.validStates) {
                if (transition.getNextState() != state) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasMissingInputs() {
        // TODO Auto-generated method stub
        return false;
    }

    public TransitionTable() {
        this.transitionTable = new ArrayList<>();
        this.validStates = new HashSet<>();
        this.validInputs = new HashSet<>();
    }

}
