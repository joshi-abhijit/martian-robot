package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.Orientation;
import com.abhi.martianrobot.RobotState;

public class LeftInstruction implements  Instruction {
    @Override
    public RobotState execute(RobotState robotState) {
        Orientation orientation = rotateLeft(robotState.getOrientation());
        return new RobotState(robotState.getPosition(),orientation);
    }

    private Orientation rotateLeft(Orientation o) {
        return switch(o) {
            case N -> Orientation.W;
            case E ->  Orientation.N;
            case S ->  Orientation.E;
            case W ->  Orientation.S;
        };
    }
}
