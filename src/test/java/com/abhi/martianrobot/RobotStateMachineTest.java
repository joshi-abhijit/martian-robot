package com.abhi.martianrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotStateMachineTest {
    InputReader inputReader = new InputReader();
    @Test
    void testExecuteInstructionsWhereRobotIsNotLost() {
        RobotStateMachine stateMachine = new RobotStateMachine(inputReader.parseGridPoint("5,3"));
        assertEquals(stateMachine.execute(0,inputReader.parseRobotState("1,1,E"), inputReader.parseInstructions("RFRFRFRF"))
                    ,inputReader.parseRobotState("1,1,E"));
    }

    @Test
    void testExecuteInstructionsWhereRobotIsLost() {
        RobotStateMachine stateMachine = new RobotStateMachine(inputReader.parseGridPoint("5,3"));
        assertEquals(stateMachine.execute(0,inputReader.parseRobotState("1,1,E"), inputReader.parseInstructions("RFRFRFRF"))
                ,inputReader.parseRobotState("1,1,E"));
        assertEquals(stateMachine.getRobot(0).isLost(), false);
        assertEquals(stateMachine.execute(1,inputReader.parseRobotState("3,2,N"), inputReader.parseInstructions("FRRFLLFFRRFLL"))
                ,inputReader.parseRobotState("3,3,N"));
        assertEquals(stateMachine.getRobot(1).isLost(), true);
        assertEquals(stateMachine.execute(2, inputReader.parseRobotState("0,3,W"), inputReader.parseInstructions("LLFFFLFLFL"))
                ,inputReader.parseRobotState("2,3,S"));
        assertEquals(stateMachine.getRobot(2).isLost(), false);

    }

    @Test
    void testIsLost() {
        RobotStateMachine stateMachine = new RobotStateMachine(inputReader.parseGridPoint("5,3"));
        assertEquals(stateMachine.execute(1,inputReader.parseRobotState("3,2,N"), inputReader.parseInstructions("FRRFLLFFRRFLL"))
                ,inputReader.parseRobotState("3,3,N"));
        assertEquals(stateMachine.getRobot(1).isLost(), true);
    }

}