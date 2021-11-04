package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.Orientation;
import com.abhi.martianrobot.RobotState;

public class RightInstruction implements Instruction{
    @Override
    public RobotState execute(RobotState robotState) {
        Orientation orientation = rotateRight(robotState.getOrientation());
        return new RobotState(robotState.getPosition(),orientation);
    }

    public Orientation rotateRight(Orientation o) {
        return switch(o) {
            case N -> Orientation.E;
            case E ->  Orientation.S;
            case S ->  Orientation.W;
            case W ->  Orientation.N;
        };
    }
}
