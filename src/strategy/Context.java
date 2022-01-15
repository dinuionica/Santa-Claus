package strategy;

import child.Child;
import interfaces.Strategy;
import java.util.List;

/**
 * The Context class used for the strategy pattern
 */
public class Context {
    private final Strategy strategy;

    /* the constructor */
    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * That method that executes a strategy
     * @param childrenList the children list
     */
    public void executeStrategy(final List<Child> childrenList) {
         strategy.applyStrategy(childrenList);
    }
}
