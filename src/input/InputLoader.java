package input;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


/**
 * The class used to load the input
 */
public final class InputLoader {

    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * The method tha reads input data from json file
     * @return the desired object
     */
    public Input readData() throws IOException {
        /* create a new object and read data from file */
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(inputPath), Input.class);
    }
}
