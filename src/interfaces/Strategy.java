package interfaces;

import child.Child;
import java.util.List;

/**
 * The strategy interface
 */
public interface Strategy {
    /**
     *
     * @param childrenList
     */
    void applyStrategy(List<Child> childrenList);
}
