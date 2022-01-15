package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IdStrategy implements Strategy {
    /**
     *
     * @param childrenList
     */
    @Override
    public void applyStrategy(final List<Child> childrenList) {
        Collections.sort(childrenList, Comparator.comparing(Child::getId));
    }
}
