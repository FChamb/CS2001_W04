package impl;

import exceptions.BadTableException;
import exceptions.BadInputException;
import exceptions.NDTransitionException;
import interfaces.IFiniteStateMachine;
import interfaces.ITransition;
import interfaces.ITransitionTable;

/**
 * Class representing a finite state machine.
 *
 */
public class FiniteStateMachine implements IFiniteStateMachine {

    private final ITransitionTable transitionTable;
    private int START_STATE;
    private char START_INPUT;

    /**
     * Adds the given transition to the FSM. The current_state of the first transition added to the FSM is treated as the initial state for the FSM.
     * @param transition the transition to add
     * @throws NDTransitionException when the finite state machine's transition table already contains another transition with the same current_state and input pair.
     */
    @Override
    public void addTransition(ITransition transition) throws NDTransitionException {
        // TODO Auto-generated method stub
    }

    @Override
    public String interpret(String input) throws BadTableException, BadInputException {
        // TODO Auto-generated method stub
        return null;
    }

    public FiniteStateMachine() {
        this.transitionTable = new TransitionTable();
    }

}
