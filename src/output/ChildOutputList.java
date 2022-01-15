package output;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the children list used to output
 */
public class ChildOutputList {
    private List<ChildOutputData> children;

    /* the constructor */
    public ChildOutputList() {
        this.children = new ArrayList<>();
    }

    /* getters and setters */
    public final List<ChildOutputData> getChild() {
        return children;
    }

    public final void setChild(final List<ChildOutputData> childrenOutputList) {
        this.children = childrenOutputList;
    }

}
