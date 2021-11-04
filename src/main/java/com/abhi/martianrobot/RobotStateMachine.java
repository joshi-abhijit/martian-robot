package com.abhi.martianrobot;

import com.abhi.martianrobot.instructions.Instruction;

import java.util.*;

public class RobotStateMachine {
    private final Map<Integer,Robot> robotMap = new HashMap<>();
    private final GridPoint gridBound;
    Set<GridPoint> lostGridPointSet = new HashSet<>();
    public RobotStateMachine(GridPoint gridBound){
        this.gridBound = gridBound;
    }

    public RobotState execute(int robotId, RobotState robotState, List<Instruction> instructions){
        RobotState currentState=robotState;
        boolean isLost = false;
        for(Instruction instruction : instructions){
            GridPoint lastGridPosition = currentState.getPosition();
            RobotState newState = instruction.execute(currentState);
            if(isLost(newState.getPosition()) && !lastGridPosition.equals(newState.getPosition())){
                boolean isLostGridPointAlreadyRegistered = !lostGridPointSet.add(lastGridPosition);
                // ignore instruction and continue to next
                if(isLostGridPointAlreadyRegistered) {
                    //System.out.println("Ignored instruction:" + instruction + " currentState:" + currentState + " newState:" + newState);
                    continue;
                }else{
                    isLost = true;
                    //System.out.println("Registered new lostGridPoint:"+lastGridPosition);
                }
            }
            //System.out.println("Moved to new state:"+newState);
            currentState = newState;
        }
        robotMap.put(robotId,new Robot(robotId,currentState,isLost));
        return currentState;
    }

    public boolean isLost(GridPoint gridPoint){
        return gridBound.getX() < gridPoint.getX() || gridBound.getY() < gridPoint.getY();
    }

    public void printState(){
        robotMap.forEach((id,robot) -> {
            RobotState state = robot.getState();
            if (robot.isLost()) {
                System.out.printf("%d %d %s LOST%n", state.getPosition().getX(), state.getPosition().getY(), state.getOrientation().toString());
            } else {
                System.out.printf("%d %d %s%n", state.getPosition().getX(), state.getPosition().getY(), state.getOrientation().toString());
            }
        });
    }

    public Robot getRobot(int i) {
        return robotMap.get(i);
    }
}
