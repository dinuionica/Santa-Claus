package main;

import input.Input;
import simulation.Simulation;
import input.InputLoader;
import checker.Checker;
import common.Constants;
import output.Output;
import output.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Class used to run the code
 */
public final class Main {
    private Main() {
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        /* create the directory and the path needed to run the tests*/
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        /* create each input and output test */
        for (int i = 1; i <= Constants.TESTS_NUMBER; ++i) {
            String inputFile = Constants.NAME_TEST + i + Constants.FILE_EXTENSION;
            String outputFile = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            /* call action */
            action(inputFile, outputFile);
        }

        /* check style */
        Checker.calculateScore();
    }

    /**
     * The method that runs a test
     * @param firstFilePath the input file
     * @param secondFilePath the output file
     * @throws IOException exception
     */
    public static void action(final String firstFilePath,
                              final String secondFilePath) throws IOException {
        /* read the data from the input file */
        InputLoader inputLoader = new InputLoader(firstFilePath);
        Input input = inputLoader.readData();

        /* apply the simulations and create the output */
        Simulation simulation = Simulation.getInstance();
        Output output = simulation.simulation(input);

        /* write the final result to the output file */
        Writer writer = new Writer(secondFilePath);
        writer.writeData(output);
    }
}
