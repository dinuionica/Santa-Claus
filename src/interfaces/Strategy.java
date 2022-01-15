package interfaces;

import child.Child;
import java.util.List;

/**
 * The strategy interface used for the strategy pattern
 */
public interface Strategy {
    /**
     * The method that applies strategies
     * @param childrenList the children list
     */
    void applyStrategy(List<Child> childrenList);
}
