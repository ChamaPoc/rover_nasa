package nasa.rover.element.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IONasaFileReader {
    private String FOLDER_FILE_PATH;
    private String NAME_SOURCE_FILE;
    private static final String NAME_OUTPUT_FILE = "NasaOutput.txt";
    private static final String SEPARATEUR = " ";
    private List<String> instructions;
    private int[] gridSize;
    private List<String> intructionsVehicles;

    public IONasaFileReader(String filePath) {
        this.FOLDER_FILE_PATH = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
        this.NAME_SOURCE_FILE = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
    }

    /**
     * read file, and extract informations (instructions and gridSize)
     * 
     * @throws IOException
     */
    public void readInstructions() throws IOException {
        Stream<String> rows = Files.lines(Paths.get(FOLDER_FILE_PATH + NAME_SOURCE_FILE));
        instructions = rows.collect(Collectors.toList());
        intructionsVehicles = instructions.subList(1, instructions.size());
        getGridSize(instructions.get(0));
    }

    private void getGridSize(String size) {
        String[] splitedRow = instructions.get(0).split(SEPARATEUR);
        int[] tab = { Integer.parseInt(splitedRow[0]), Integer.parseInt(splitedRow[1]) };
        this.gridSize = tab;
    }

    /**
     * return the instruction to create vehicles car[0] = String[] : the position, car[1] = List<String>:the instructions
     * 
     * @return
     */
    public List<Object[]> getInstructionsObject() {
        ArrayList<Object[]> vehiculsInit = new ArrayList<Object[]>();
        //1:tableau[3] String
        //2:List<String>
        for (int i = 0; i < intructionsVehicles.size(); i++) {
            if (i % 2 == 0) { // instruction
                String[] initCar = intructionsVehicles.get(i).split(SEPARATEUR);
                Object[] car = new Object[2];
                car[0] = initCar;
                vehiculsInit.add(car);
            } else { // vehicle
                List<String> actions = new ArrayList<String>();
                for (char c : intructionsVehicles.get(i).toCharArray()) {
                    actions.add(String.valueOf(c));
                }
                vehiculsInit.get(vehiculsInit.size() - 1)[1] = actions;
            }
        }

        return vehiculsInit;
    }

    public int[] getGridSize() {
        return gridSize;
    }

    public List<String> getIntructionsVehicles() {
        return intructionsVehicles;
    }

    /**
     * print the result into a file
     * 
     * @param stgBuffer
     * @throws IOException
     */
    public void printResult(StringBuffer stgBuffer) throws IOException {
        Files.write(Paths.get(FOLDER_FILE_PATH + NAME_OUTPUT_FILE), stgBuffer.toString().getBytes());
    }

    public void printError(Exception e) throws IOException {
        Files.write(Paths.get(FOLDER_FILE_PATH + NAME_OUTPUT_FILE), e.getMessage().getBytes());
    }

}
