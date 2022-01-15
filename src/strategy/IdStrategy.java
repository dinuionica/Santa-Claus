package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class specific of an id strategy
 */
public class IdStrategy implements Strategy {
    /**
     * The method tha applies an id strategy
     * @param childrenList the children list
     */
    @Override
    public void applyStrategy(final List<Child> childrenList) {
        /* sort the list of children by id */
        Collections.sort(childrenList, Comparator.comparing(Child::getId));
    }
}
