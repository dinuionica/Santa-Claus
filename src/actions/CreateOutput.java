package actions;

import child.Child;
import common.Gift;
import output.GiftOutputData;
import output.ChildOutputData;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static common.Constants.MAXIMUM_AGE_TEEN;

/**
 * The class used to create the output result
 */
public final class CreateOutput {
    private CreateOutput() {

    }

    /**
     * The method that creates the output for JSON file
     * @param childrenList the children list
     * @param output the output data
     */
    public static void createNewOutput(final List<Child> childrenList, final Output output) {
        ChildOutputList listOutput = new ChildOutputList();

        /* creating each output child and adding it to the final list */
        for (int i = 0; i < childrenList.size(); ++i) {
            Child child = childrenList.get(i);

            /* create a new child of child output type */
            ChildOutputData childOutput = new ChildOutputData(child);

            if (childOutput.getAge() <= MAXIMUM_AGE_TEEN) {
                /* assigning specific properties to each child */
                childOutput.setNiceScoreHistory(child.getNiceScoreHistory());
                childOutput.setAverageScore(child.getAverageScore());

                childOutput.setAssignedBudget(child.getAssignedBudget());

                /* create gifts output list */
                List<GiftOutputData> giftOutputList = new ArrayList<>();
                for (Gift gift : child.getReceivedGifts()) {
                    GiftOutputData outputGift = new GiftOutputData(gift);
                    giftOutputList.add(outputGift);
                }

                childOutput.setReceivedGifts(giftOutputList);
                listOutput.getChild().add(childOutput);
            }
        }
        /* removing from the list children who have become young adults */
        for (int i = 0; i < childrenList.size(); ++i) {
            if (childrenList.get(i).getAge() > MAXIMUM_AGE_TEEN) {
                childrenList.remove(childrenList.get(i));
            }
        }

        /* sorting the final list of children by id */
        Collections.sort(listOutput.getChild(), Comparator.comparing(ChildOutputData::getId));
        /* adding the list of children from the current round to the final list */
        output.getAnnualChildren().add(listOutput);
    }
}
