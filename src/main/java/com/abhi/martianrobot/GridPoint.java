package com.abhi.martianrobot;
import java.util.Objects;

public class GridPoint {
    private int x=0;
    private int y=0;
    private int hash = 0;
    public GridPoint(int x, int y){
        this.x=x;
        this.y=y;
        hash = Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPoint gridPoint = (GridPoint) o;
        return x == gridPoint.x && y == gridPoint.y;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "GridPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
