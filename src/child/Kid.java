package child;

import input.ChildInputData;
import interfaces.ChildInterface;

/**
 * The class specific to a child of kid type
 */
public class Kid extends Child implements ChildInterface {
    /* the constructor used for the application of the factory with the input data */
    public Kid(final ChildInputData childInput) {
        super(childInput.getId(), childInput.getLastName(), childInput.getFirstName(),
              childInput.getAge(), childInput.getCity(), childInput.getNiceScore(),
              childInput.getGiftsPreferences(), childInput.getNiceScoreBonus(),
              childInput.getElf());
    }

    /* the constructor used for the application of the factory with the data from database */
    public Kid(final Child child) {
        super(child.getId(), child.getLastName(), child.getFirstName(), child.getAge(),
              child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
              child.getNiceScoreBonus(), child.getElf());
    }

    /**
     * The method that calculates the average score
     */
    @Override
    public void calculateAverageScore() {
        int count = 0;
        Double sumScore = 0.0;

        /* calculate the sum of the good scores and count the number */
        for (Double score : this.getNiceScoreHistory()) {
            sumScore += score;
            count++;
        }

        /* calculate the arithmetic average */
        if (count != 0) {
            this.setAverageScore(sumScore / count);
        }
    }
}
