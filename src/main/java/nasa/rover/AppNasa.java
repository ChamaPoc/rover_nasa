package nasa.rover;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nasa.rover.element.engine.Vehicle;
import nasa.rover.element.input.IONasaFileReader;
import nasa.rover.element.planet.Board;

/**
 * Hello world!
 *
 */
public class AppNasa
{
    public static void main(String[] args) throws IOException {
        IONasaFileReader nasa = new IONasaFileReader(args[0]);

        try {
            nasa.readInstructions();
            Board board = new Board(nasa.getGridSize(), createVehicles(nasa));
            board.run();
            nasa.printResult(board.finalResult());
        } catch (IOException e) {
            nasa.printError(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Vehicle> createVehicles(IONasaFileReader nasa) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (Object[] o : nasa.getInstructionsObject()) {
            vehicles.add(new Vehicle((String[]) o[0], (List<String>) o[1]));
        }
        return vehicles;
    }

}
