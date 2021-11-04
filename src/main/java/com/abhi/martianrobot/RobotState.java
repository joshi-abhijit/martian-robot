package com.abhi.martianrobot;

import java.util.Objects;

public class RobotState {
    private GridPoint position;
    private Orientation orientation;

     public RobotState(GridPoint point, Orientation orientation){
         this.position = point;
         this.orientation = orientation;
     }

    public GridPoint getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "RobotState{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RobotState)) return false;
        RobotState that = (RobotState) o;
        return getPosition().equals(that.getPosition()) && getOrientation() == that.getOrientation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getOrientation());
    }
}
