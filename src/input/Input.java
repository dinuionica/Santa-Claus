package input;

import java.util.List;

/**
 * The class that contains the all input information
 */

public class Input {
    private int numberOfYears;
    private int santaBudget;
    private InitialData initialData;
    private List<AnnualChanges> annualChanges;

    /* getters and setters */
    public final int getNumberOfYears() {
        return numberOfYears;
    }

    public final void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public final int getSantaBudget() {
        return santaBudget;
    }

    public final void setSantaBudget(final int santaBudget) {
        this.santaBudget = santaBudget;
    }

    public final InitialData getInitialData() {
        return initialData;
    }

    public final void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public final List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    public final void setAnnualChanges(final List<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
