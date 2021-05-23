package nasa.rover.element.engine;

import java.util.Arrays;

import nasa.rover.element.engine.Action;
import nasa.rover.element.engine.Direction;
import nasa.rover.element.engine.Point;
import nasa.rover.element.engine.Vehicle;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void turnFromNorthToRight() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.N, Arrays.asList(Action.R));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.E);
    }

    @Test
    public void turnFromNorthToLeft() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.N, Arrays.asList(Action.L));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.W);
    }

    @Test
    public void turnFromEastToRight() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.E, Arrays.asList(Action.R));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.S);
    }

    @Test
    public void turnFromEastToLeft() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.E, Arrays.asList(Action.L));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.N);
    }

    @Test
    public void turnFromSouthToRight() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.S, Arrays.asList(Action.R));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.W);
    }

    @Test
    public void turnFromSouthToLeft() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.S, Arrays.asList(Action.L));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.E);
    }

    @Test
    public void turnFromWestToRight() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.W, Arrays.asList(Action.R));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.N);
    }

    @Test
    public void turnFromWestToLeft() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(0, 0), Direction.W, Arrays.asList(Action.L));
        //WHEN
        v1.run();
        //THEN
        Assert.assertEquals(v1.getCurrentDirection(), Direction.S);
    }

    @Test
    public void moveForwardNorth() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(1, 1), Direction.N, Arrays.asList(Action.M));
        //WHEN
        v1.run();
        //THEN
        Point target = new Point(1, 2);
        Assert.assertEquals(v1.getCurrentPosition().getX(), target.getX());
        Assert.assertEquals(v1.getCurrentPosition().getY(), target.getY());
    }

    @Test
    public void moveForwardEast() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(1, 1), Direction.E, Arrays.asList(Action.M));
        //WHEN
        v1.run();
        //THEN
        Point target = new Point(2, 1);
        Assert.assertEquals(v1.getCurrentPosition().getX(), target.getX());
        Assert.assertEquals(v1.getCurrentPosition().getY(), target.getY());
    }

    @Test
    public void moveForwardSouth() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(1, 1), Direction.S, Arrays.asList(Action.M));
        //WHEN
        v1.run();
        //THEN
        Point target = new Point(1, 0);
        Assert.assertEquals(v1.getCurrentPosition().getX(), target.getX());
        Assert.assertEquals(v1.getCurrentPosition().getY(), target.getY());
    }

    @Test
    public void moveForwardWest() {
        //GIVEN
        Vehicle v1 = new Vehicle(new Point(1, 1), Direction.W, Arrays.asList(Action.M));
        //WHEN
        v1.run();
        //THEN
        Point target = new Point(0, 1);
        Assert.assertEquals(v1.getCurrentPosition().getX(), target.getX());
        Assert.assertEquals(v1.getCurrentPosition().getY(), target.getY());
    }
}
