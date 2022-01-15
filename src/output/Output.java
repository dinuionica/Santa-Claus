package output;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the final list of children specific to each year
 */
public class Output {
    private List<ChildOutputList> annualChildren;

    /* the constructor */
    public Output() {
        this.annualChildren = new ArrayList<>();
    }

    /* getters and setters*/
    public final List<ChildOutputList> getAnnualChildren() {
        return annualChildren;
    }

    public final void setAnnualChildren(final List<ChildOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }

}
