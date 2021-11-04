package com.abhi.martianrobot.instructions;
import com.abhi.martianrobot.*;
public class ForwardInstruction implements Instruction {
    @Override
    public RobotState execute(RobotState robotState) {
        GridPoint gridPoint = moveForward(robotState);
        return new RobotState(gridPoint,robotState.getOrientation());
    }

    private GridPoint moveForward(RobotState robotState) {
        GridPoint gridPoint = robotState.getPosition();
        return switch (robotState.getOrientation()) {
            case N -> new GridPoint(gridPoint.getX(), gridPoint.getY() + 1);
            case S -> new GridPoint(gridPoint.getX(), gridPoint.getY() - 1);
            case E -> new GridPoint(gridPoint.getX() + 1, gridPoint.getY());
            case W -> new GridPoint(gridPoint.getX() - 1, gridPoint.getY());
        };
    }


}
