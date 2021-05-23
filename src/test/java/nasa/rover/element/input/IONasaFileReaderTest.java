package nasa.rover.element.input;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class IONasaFileReaderTest {
    IONasaFileReader ioFile;

    @Before
    public void init() throws IOException {
        ioFile = new IONasaFileReader("src/test/test_input.txt");
        ioFile.readInstructions();
    }

    @Test
    public void testGridSize() {
        Assert.assertEquals(5, ioFile.getGridSize()[0]);
        Assert.assertEquals(5, ioFile.getGridSize()[1]);
    }

    @Test
    public void testInstructions() {
        Assert.assertEquals("1 2 N", ioFile.getIntructionsVehicles().get(0));
        Assert.assertEquals("LMLMLMLMM", ioFile.getIntructionsVehicles().get(1));
        Assert.assertEquals("3 3 E", ioFile.getIntructionsVehicles().get(2));
        Assert.assertEquals("MMRMMRMRRM", ioFile.getIntructionsVehicles().get(3));

    }

    @Test
    public void lol() {
        Stream<String> language = Stream.of("java", "python", "node");

        //Convert a Stream to List
        List<String> result = language.collect(Collectors.toList());
    }
}
