package com.abhi.martianrobot.instructions;

import com.abhi.martianrobot.RobotState;

public interface Instruction {
    public RobotState execute(RobotState robotState);
}
