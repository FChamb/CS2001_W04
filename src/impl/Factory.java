package impl;

import interfaces.IFactory;
import interfaces.IFiniteStateMachine;
import interfaces.ITransition;
import interfaces.ITransitionTable;


/**
 * This class implements a singleton factory.
 *
 */
public final class Factory implements IFactory {

    private static IFactory factoryInstance = null;

    private Factory() {

    }

    /**
     * Method which returns an instance of the singleton Factory class.
     * @return the instance of the Factory
     */
    public static IFactory getInstance() {
        if (factoryInstance == null) {
            factoryInstance = new Factory();
        }
        return factoryInstance;
    }

    /**
     * Creates an instance of ITransition for use in an FSM.
     * @param current_state the current state for this FSM transition
     * @param input the input for this FSM transition
     * @param output the output for this FSM transition
     * @param next_state the next state for this FSM transition
     * @return the Transition
     *
     */
    @Override
    public ITransition makeTransition(int current_state, char input, char output, int next_state) {
        ITransition transition = new Transition(current_state, input, output, next_state);
        return transition;
    }

    /**
     * Creates an instance of ITransitionTable for use in a FSM.
     * @return the new empty TransitionTable
     *
     */
    @Override
    public ITransitionTable makeTransitionTable() {
        ITransitionTable transitionTable = new TransitionTable();
        return transitionTable;
    }

    /**
     * Creates an instance of IFiniteStateMachine.
     * @return the new FiniteStateMachine
     */
    @Override
    public IFiniteStateMachine makeFiniteStateMachine() {
        IFiniteStateMachine finiteStateMachine = new FiniteStateMachine();
        return finiteStateMachine;
    }

}
