package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.GridPoint;
import com.abhi.martianrobot.Orientation;
import com.abhi.martianrobot.RobotState;

import static org.junit.jupiter.api.Assertions.*;

class ForwardInstructionTest {
    ForwardInstruction forwardInstruction = new ForwardInstruction();
    @org.junit.jupiter.api.Test
    void testForwardExecuteWhenPointingNorth() {
        assertEquals(forwardInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.N)),
                new RobotState(new GridPoint(3,3), Orientation.N));
    }

    @org.junit.jupiter.api.Test
    void testForwardExecuteWhenPointingEast() {
        assertEquals(forwardInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.E)),
                new RobotState(new GridPoint(4,2), Orientation.E));
    }

    @org.junit.jupiter.api.Test
    void testForwardExecuteWhenPointingSouth() {
        assertEquals(forwardInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.S)),
                new RobotState(new GridPoint(3,1), Orientation.S));
    }

    @org.junit.jupiter.api.Test
    void testForwardExecuteWhenPointingWest() {
        assertEquals(forwardInstruction.execute(new RobotState(new GridPoint(3,2), Orientation.W)),
                new RobotState(new GridPoint(2,2), Orientation.W));
    }
}