package strategy;

import child.Child;
import interfaces.Strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class specific of the nice score strategy
 */
public class AverageScoreStrategy implements Strategy {
    /**
     * The method tha applies an average score strategy
     * @param childrenList the children list
     */
    @Override
    public void applyStrategy(final List<Child> childrenList) {
        /* sort the list of children by average score and by id */
        Collections.sort(childrenList, Comparator.comparing(Child::getAverageScore).reversed()
                .thenComparing(Child::getId));
    }
}
