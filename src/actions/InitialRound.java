package actions;

import child.Child;
import common.Gift;
import input.Input;
import output.Output;
import java.util.List;

public final class InitialRound {

    private InitialRound() {

    }

    /**
     * The method used to simulate the initial round
     * @param input input data
     * @param output output data
     * @param childrenList children list
     * @param giftsList gifts list
     */
    public static void simulateInitialRound(final Input input, final Output output,
                                            final List<Child> childrenList,
                                            final List<Gift> giftsList) {
        /* applying specific commands to the initial round */
        Command command = Command.getInstance();

        command.addInitialScore(childrenList);

        command.calculateBudgetUnit(input, childrenList);

        command.applyBlankPink(childrenList);

        command.awardingGifts(childrenList, giftsList);

        command.applyYellow(childrenList, giftsList);

        CreateOutput.createNewOutput(childrenList, output);
    }
}
