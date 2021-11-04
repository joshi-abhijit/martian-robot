package com.abhi.martianrobot;


import java.util.Objects;

public class Robot{
    private int robotId;
    private RobotState state;
    private boolean isLost;
    public Robot(int robotId, RobotState state, boolean isLost){
        this.robotId = robotId;
        this.state = state;
        this.isLost = isLost;
    }

    public int getRobotId() {
        return robotId;
    }

    public RobotState getState() {
        return state;
    }

    public boolean isLost() {
        return isLost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return getRobotId() == robot.getRobotId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRobotId());
    }
}
