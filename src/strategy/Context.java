package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.List;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(List<Child> childrenList){
         strategy.applyStrategy(childrenList);
    }
}
