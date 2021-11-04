package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.GridPoint;
import com.abhi.martianrobot.Orientation;
import com.abhi.martianrobot.RobotState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftInstructionTest {
    LeftInstruction leftInstruction = new LeftInstruction();
    @Test
    void testLeftExecuteWhenPointingEast() {
        assertEquals(leftInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.E)),
                new RobotState(new GridPoint(3,2), Orientation.N));
    }

    @Test
    void testLeftExecuteWhenPointingWest() {
        assertEquals(leftInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.W)),
                new RobotState(new GridPoint(3,2), Orientation.S));
    }

    @Test
    void testLeftExecuteWhenPointingNorth() {
        assertEquals(leftInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.N)),
                new RobotState(new GridPoint(3,2), Orientation.W));
    }

    @Test
    void testLeftExecuteWhenPointingSouth() {
        assertEquals(leftInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.S)),
                new RobotState(new GridPoint(3,2), Orientation.E));
    }
}