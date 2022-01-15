package child;


import input.ChildInputData;
import interfaces.ChildInterface;

import static common.Constants.AVERAGE_SCORE_BABY;

/**
 * The class specific to a child of baby type
 */
public class Baby extends Child implements ChildInterface {
    /* the constructor used for the application of the factory with the input data */
    public Baby(final ChildInputData childInput) {
        super(childInput.getId(), childInput.getLastName(), childInput.getFirstName(),
              childInput.getAge(), childInput.getCity(), childInput.getNiceScore(),
              childInput.getGiftsPreferences(), childInput.getNiceScoreBonus(),
              childInput.getElf());
    }

    /* the constructor used for the application of the factory with the data from database */
    public Baby(final Child child) {
        super(child.getId(), child.getLastName(), child.getFirstName(), child.getAge(),
              child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
              child.getNiceScoreBonus(), child.getElf());
    }

    /**
     * The method that calculates the average score
     */
    @Override
    public void calculateAverageScore() {
        this.setAverageScore(AVERAGE_SCORE_BABY);
    }
}
