package nasa.rover.element.planet;

import java.util.List;

import nasa.rover.element.engine.Point;
import nasa.rover.element.engine.Vehicle;

public class Board {
    private Point size;
    private List<Vehicle> vehicles;

    public Board(Point size, List<Vehicle> vehicles) {
        this.size = size;
        this.vehicles = vehicles;
    }

    public Board(int[] size, List<Vehicle> vehicles) {
        this.size = new Point(size);
        this.vehicles = vehicles;
    }

    public void run() {
        for (Vehicle vehicle : vehicles) {
            vehicle.run();
        }
    }

    public StringBuffer finalResult() {
        StringBuffer stgBuffer = new StringBuffer();

        //vehicle
        for (Vehicle v : vehicles) {
            stgBuffer.append(v.toString()).append("\n");
        }
        return stgBuffer;
    }
}
