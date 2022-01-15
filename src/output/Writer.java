package output;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.IOException;


/**
 * The class used to write the final output
 */
public final class Writer {

    private final String outputPath;

    public Writer(final String outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * The method that writes the final output to json file
     * @param output the desired output
     * @throws IOException exception
     */
    public void writeData(final Output output) throws IOException {
        /* create a new object and write it to json file */
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(new File(outputPath), output);
    }
}
