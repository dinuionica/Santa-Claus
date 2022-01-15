package child;

import input.ChildInputData;
import interfaces.ChildInterface;

/**
 * The class specific to a child of teen type
 */
public class Teen extends Child implements ChildInterface {
    /* the constructor used for the application of the factory with the input data */
    public Teen(final ChildInputData childInput) {
        super(childInput.getId(), childInput.getLastName(), childInput.getFirstName(),
              childInput.getAge(), childInput.getCity(), childInput.getNiceScore(),
              childInput.getGiftsPreferences(), childInput.getNiceScoreBonus(),
              childInput.getElf());
    }

    /* the constructor used for the application of the factory with the data from database */
    public Teen(final Child child) {
        super(child.getId(), child.getLastName(), child.getFirstName(), child.getAge(),
              child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
              child.getNiceScoreBonus(), child.getElf());
    }

    /**
     * The method that calculates the average score
     */
    @Override
    public void calculateAverageScore() {
        Double firstSum = 0.0;
        Double secondSum = 0.0;
        int index = 0;

        /* calculate both sums for good scores */
        for (Double score : this.getNiceScoreHistory()) {
            firstSum += score * (index + 1);
            secondSum += (index + 1);
            index++;
        }

        /* calculates the weighted average */
        if (secondSum != 0) {
            this.setAverageScore(firstSum / secondSum);
        }

    }
}
