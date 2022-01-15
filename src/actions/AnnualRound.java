package actions;

import child.Child;
import common.Gift;
import input.Input;
import output.Output;

import java.util.List;


public final class AnnualRound {

    private AnnualRound() {

    }
    /**
     * The method used to simulate an annual round
     * @param numberRound the number of round
     * @param input input data
     * @param output output data
     * @param childrenList children list
     * @param giftsList gifts list
     */
    public static void simulateAnnualRound(final int numberRound, final Input input,
                                           final Output output, final List<Child> childrenList,
                                           final List<Gift> giftsList) {
        /* applying specific commands to an annual update round */
        Command command = Command.getInstance();

        command.increaseAge(childrenList);

        command.addNewChildren(input, childrenList, numberRound);

        command.annualUpdate(input, childrenList, numberRound);

        command.addNewGift(input, giftsList, numberRound);

        command.updateSantaBudget(input, numberRound);

        command.removeYoungAdults(childrenList);

        command.calculateBudgetUnit(input, childrenList);

        command.applyChangesBlackPinkElves(childrenList);

        command.applyStrategies(input, childrenList, numberRound);

        command.awardingGifts(childrenList, giftsList);

        command.applyChangesYellowElf(childrenList, giftsList);

        CreateOutput.createNewOutput(childrenList, output);
    }
}
