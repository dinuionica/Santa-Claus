package simulation;

import child.Baby;
import child.Kid;
import child.Teen;
import child.YoungAdult;
import child.Child;
import input.ChildInputData;
import interfaces.ChildInterface;
import static common.Constants.MAXIMUM_AGE_BABY;
import static common.Constants.MAXIMUM_AGE_KID;
import static common.Constants.MAXIMUM_AGE_TEEN;

/**
 * The class used to create children based on age, using singleton factory pattern
 */
public final class ChildFactory {
    private static ChildFactory instanceFactory = null;

    private ChildFactory() {

    }

    /**
     * The method that return the instance
     * @return the instance of the object with ChildFactory type
     */
    public static ChildFactory getInstance() {
        if (instanceFactory == null) {
            instanceFactory = new ChildFactory();
        }
        return instanceFactory;
    }

    /**
     * The method that creates each type of child based on age for input
     * @param ageValue the age
     * @param child the input child
     * @return the desired child
     */
    public ChildInterface createChildInput(final int ageValue, final Object child) {
        if (ageValue < MAXIMUM_AGE_BABY) {
            return new Baby((ChildInputData) child);
        } else if (ageValue < MAXIMUM_AGE_KID && ageValue >= MAXIMUM_AGE_BABY) {
            return new Kid((ChildInputData) child);
        } else if (ageValue <= MAXIMUM_AGE_TEEN && ageValue >= MAXIMUM_AGE_KID) {
            return new Teen((ChildInputData) child);
        } else if (ageValue > MAXIMUM_AGE_TEEN) {
            return new YoungAdult((ChildInputData) child);
        }
        throw new IllegalArgumentException("The age " + ageValue + " is not recognized!");
    }

    /**
     * The method that creates each type of child based on age for an annual round
     * @param ageValue the age
     * @param child the current child
     * @return the desired child
     */
    public ChildInterface createChild(final int ageValue, final Object child) {
        if (ageValue < MAXIMUM_AGE_BABY) {
            return new Baby((Child) child);
        } else if (ageValue < MAXIMUM_AGE_KID && ageValue >= MAXIMUM_AGE_BABY) {
            return new Kid((Child) child);
        } else if (ageValue <= MAXIMUM_AGE_TEEN && ageValue >= MAXIMUM_AGE_KID) {
            return new Teen((Child) child);
        } else if (ageValue > MAXIMUM_AGE_TEEN) {
            return new YoungAdult((Child) child);
        }
        throw new IllegalArgumentException("The age " + ageValue + " is not recognized.");
    }
}
