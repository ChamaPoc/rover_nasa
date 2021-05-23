package nasa.rover.element.engine;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private Point currentPosition;
    private Direction currentDirection;
    private List<Action> instructions;

    public Vehicle(Point currentPosition, Direction currentDirection, List<Action> instructions) {
        this.currentPosition = currentPosition;
        this.currentDirection = currentDirection;
        this.instructions = instructions;
    }

    public Vehicle(String[] positionDirection, List<String> actions) {
        this.currentPosition = new Point(positionDirection[0], positionDirection[1]);
        this.currentDirection = Direction.valueOf(positionDirection[2]);
        this.instructions = new ArrayList<Action>();
        for (String action : actions) {
            this.instructions.add(Action.valueOf(action));
        }
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    private void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Action> getInstructions() {
        return instructions;
    }

    private void setInstructions(List<Action> instructions) {
        this.instructions = instructions;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    private void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    private void turnRight() {
        currentDirection = this.currentDirection.atRight();
    }

    private void turnLeft() {
        currentDirection = this.currentDirection.atLeft();
    }

    /**
     * 
     */
    private void moveForward() {
        switch (currentDirection) {
        case N:
            currentPosition.addOneToY();
            break;
        case E:
            currentPosition.addOneToX();
            break;
        case S:
            currentPosition.removeOntToY();
            break;
        case W:
            currentPosition.removeOneToX();
            break;
        default: // do nothing.
            break;
        }

    }

    /**
     * Execute all instructions
     */
    public void run() {
        for (Action a : instructions) {
            switch (a) {
            case M:
                moveForward();
                break;
            case L:
                turnLeft();
                break;
            case R:
                turnRight();
                break;
            default: // do nothing.
                break;
            }
        }
    }

    @Override
    public String toString() {
        return currentPosition.toString() + " " + currentDirection.toString();

    }

    public String toStringDebug() {
        return toString() + " " + instructions.toString();

    }
}
