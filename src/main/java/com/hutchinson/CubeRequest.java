package com.hutchinson;

import java.io.Serializable;

public class CubeRequest implements Serializable {
    private Cube cube;
    private String face;
    private String direction;

    public CubeRequest(Cube cube, String face, String direction) {
        this.cube = cube;
        this.face = face;
        this.direction = direction;
    }

    public CubeRequest() {
    };

    public Cube getCube() {
        return cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeRequest that = (CubeRequest) o;

        if (cube != null ? !cube.equals(that.cube) : that.cube != null) return false;
        if (face != null ? !face.equals(that.face) : that.face != null) return false;
        return direction != null ? direction.equals(that.direction) : that.direction == null;
    }

    @Override
    public int hashCode() {
        int result = cube != null ? cube.hashCode() : 0;
        result = 31 * result + (face != null ? face.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CubeRequest{" +
                "cube=" + cube +
                ", face='" + face + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
