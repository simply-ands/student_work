package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {


    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals(Robot.CENTRE, robot.getWorld().getPosition());
        assertEquals("NORTH", robot.getWorld().getCurrentDirection().name());
    }

    @Test
    void dump() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals("[0,0] CrashTestDummy> Ready", robot.toString());
    }

//    @Test
//    void shutdown() {
//        Robot robot = new Robot("CrashTestDummy");
//        ShutdownCommand command = new ShutdownCommand();
//        assertTrue(robot.handleCommand(command));
//    }

    @Test
    void forward() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = Command.create("forward 10");
//        ForwardCommand command = new ForwardCommand("forward 10");

        assertTrue(robot.handleCommand(command));
        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getWorld().getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void forwardforward() {
        Robot robot = new Robot("CrashTestDummy");
        Command forward10 = Command.create("forward 10");
        Command forward5 = Command.create("forward 5");
        assertTrue(robot.handleCommand(forward10));
        assertTrue(robot.handleCommand(forward5));
        assertEquals("Moved forward by 5 steps.", robot.getStatus());
    }

    @Test
    void tooFarForward() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = Command.create("forward 1000");
        assertTrue(robot.handleCommand(command));
        assertEquals(Robot.CENTRE, robot.getWorld().getPosition());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void help() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = Command.create("help");
        assertTrue(robot.handleCommand(command));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
    }
}