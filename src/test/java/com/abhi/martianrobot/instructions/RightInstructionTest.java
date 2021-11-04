package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.GridPoint;
import com.abhi.martianrobot.Orientation;
import com.abhi.martianrobot.RobotState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightInstructionTest {
    RightInstruction rightInstruction = new RightInstruction();
    @Test
    void testRightExecuteWhenPointingEast() {
        assertEquals(rightInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.E)),
                new RobotState(new GridPoint(3,2), Orientation.S));
    }

    @Test
    void testRightExecuteWhenPointingWest() {
        assertEquals(rightInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.W)),
                new RobotState(new GridPoint(3,2), Orientation.N));
    }

    @Test
    void testRightExecuteWhenPointingNorth() {
        assertEquals(rightInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.N)),
                new RobotState(new GridPoint(3,2), Orientation.E));
    }

    @Test
    void testRightExecuteWhenPointingSouth() {
        assertEquals(rightInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.S)),
                new RobotState(new GridPoint(3,2), Orientation.W));
    }
}