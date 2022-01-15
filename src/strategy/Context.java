package strategy;

import child.Child;
import interfaces.Strategy;
import java.util.List;

public class Context {
    private final Strategy strategy;
    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * dsaf
     * @param childrenList
     */
    public void executeStrategy(final List<Child> childrenList) {
         strategy.applyStrategy(childrenList);
    }
}
