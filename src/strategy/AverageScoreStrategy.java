package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AverageScoreStrategy implements Strategy {
    /**
     *
     * @param childrenList
     */
    @Override
    public void applyStrategy(final List<Child> childrenList) {
        Collections.sort(childrenList, Comparator.comparing(Child::getAverageScore).reversed()
                .thenComparing(Child::getId));

    }
}
