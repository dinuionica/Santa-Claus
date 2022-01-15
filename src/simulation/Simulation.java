package simulation;

import child.Child;
import common.Gift;
import input.Input;
import output.Output;
import java.util.ArrayList;
import java.util.List;

import static actions.AnnualRound.simulateAnnualRound;
import static actions.InitialRound.simulateInitialRound;

/**
 * The class used to apply a simulation
 */
public class Simulation {
    private static Simulation instanceSimulation = null;

    /*  the default constructor */
    public Simulation() {

    }

    /**
     * The method that returns the instance
     * @return the instance of the object with Simulation type
     */
    public static Simulation getInstance() {
        if (instanceSimulation == null) {
            instanceSimulation = new Simulation();
        }
        return instanceSimulation;
    }

    /**
     * The method that applies simulations and creates the final output
     * @param input the input data
     * @return the final output result
     */
    public Output simulation(final Input input) {
        /* the data from the input is taken over and specific lists are created */
        DataBase dataBase = DataBase.getInstance();
        List<Child> childrenList = dataBase.createChildList(input);
        List<Gift> giftsList = dataBase.createGiftsList(input);

        /* create the final output */
        Output output = new Output();

        /* apply the simulation for the first round */
        simulateInitialRound(input, output, childrenList, giftsList);

        /* create a list with annual changes */
        List<List<Child>> annualChanges = new ArrayList<>();

        /* create a copy for the current list and add to the annual changes list */
        List<Child> copyList = dataBase.createCopyList(childrenList);
        annualChanges.add(copyList);

        /* apply simulations for the desired number of years */
        int numberRound = 0;
        while (numberRound < input.getNumberOfYears()) {

            /* apply the simulation */
            simulateAnnualRound(numberRound, input, output, annualChanges.get(numberRound),
                                giftsList);

            /* create a copy for the current list and add to
             * the annual changes list used for next round
             */
            List<Child> newCopyList = dataBase.createCopyList(annualChanges.get(numberRound));
            annualChanges.add(newCopyList);

            ++numberRound;
        }
        return output;
    }
}
