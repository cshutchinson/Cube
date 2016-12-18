package com.hutchinson;

import java.util.ArrayList;

public class Cube {
    private String top;
    private String left;
    private String right;
    private String front;
    private String bottom;
    private String back;


    public Cube(ArrayList<String> faces) {
        this.top = faces.get(0);
        this.left = faces.get(1);
        this.right = faces.get(2);
        this.front = faces.get(3);
        this.bottom = faces.get(4);
        this.back = faces.get(5);
    }
    public Cube() {
        this.top = "000000000";
        this.left = "111111111";
        this.right = "222222222";
        this.front = "333333333";
        this.bottom = "444444444";
        this.back = "555555555";
    }

    public String getTop() {
        return top;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public String getBottom() {
        return bottom;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public void setBack(String back) {
        this.back = back;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (top != null ? !top.equals(cube.top) : cube.top != null) return false;
        if (left != null ? !left.equals(cube.left) : cube.left != null) return false;
        if (right != null ? !right.equals(cube.right) : cube.right != null) return false;
        if (front != null ? !front.equals(cube.front) : cube.front != null) return false;
        if (bottom != null ? !bottom.equals(cube.bottom) : cube.bottom != null) return false;
        return back != null ? back.equals(cube.back) : cube.back == null;
    }

    @Override
    public int hashCode() {
        int result = top != null ? top.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (front != null ? front.hashCode() : 0);
        result = 31 * result + (bottom != null ? bottom.hashCode() : 0);
        result = 31 * result + (back != null ? back.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "top='" + top + '\'' +
                ", left='" + left + '\'' +
                ", right='" + right + '\'' +
                ", front='" + front + '\'' +
                ", bottom='" + bottom + '\'' +
                ", back='" + back + '\'' +
                '}';
    }
}
