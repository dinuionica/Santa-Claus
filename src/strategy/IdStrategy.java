package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IdStrategy implements Strategy {
    @Override
    public void applyStrategy(List<Child> childrenList) {
        Collections.sort(childrenList, Comparator.comparing(Child::getId));
    }
}
