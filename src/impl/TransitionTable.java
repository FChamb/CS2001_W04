package impl;

import exceptions.BadInputException;
import exceptions.NDTransitionException;
import interfaces.ITransition;
import interfaces.ITransitionTable;

/**
 * Class representing a transition table for an FSM.
 * 
 */
public class TransitionTable implements ITransitionTable {

    @Override
    public void addTransition(ITransition transition) throws NDTransitionException {
        // TODO Auto-generated method stub
    }

    @Override
    public ITransition getTransition(int current_state, char input) throws BadInputException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasTransitionsToIllegalStates() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasMissingInputs() {
        // TODO Auto-generated method stub
        return false;
    }

}
