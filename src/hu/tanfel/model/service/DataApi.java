package hu.tanfel.model.service;

import hu.tanfel.model.domain.Course;

import java.util.List;
import java.util.logging.XMLFormatter;

public class DataApi {

    private final FileReader fileReader;
    private final DataParser dataParser;

    public DataApi(FileReader fileReader, DataParser dataParser) {
        this.fileReader = fileReader;
        this.dataParser = dataParser;
    }

    public List<Course> getData(String input) {
        return dataParser.parse(fileReader.read(input));

    }
}
