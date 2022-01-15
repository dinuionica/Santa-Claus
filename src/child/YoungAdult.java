package child;

import input.ChildInputData;
import interfaces.ChildInterface;

/**
 * The class specific to a child of young adult type
 */
public class YoungAdult extends Child implements ChildInterface {
    /* the constructor used for the application of the factory with the input data */
    public YoungAdult(final ChildInputData childInput) {
        super(childInput.getId(), childInput.getLastName(), childInput.getFirstName(),
              childInput.getAge(), childInput.getCity(), childInput.getNiceScore(),
              childInput.getGiftsPreferences(), childInput.getNiceScoreBonus(),
              childInput.getElf());
    }

    /* the constructor used for the application of the factory with the data from database */
    public YoungAdult(final Child child) {
        super(child.getId(), child.getLastName(), child.getFirstName(), child.getAge(),
              child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
              child.getNiceScoreBonus(), child.getElf());
    }

    /**
     * The method that calculates the average score
     */
    @Override
    public void calculateAverageScore() {
        /* because he is too old he is no longer considered */
    }
}
