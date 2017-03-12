package com.hutchinson;

import org.springframework.stereotype.Service;

@Service
public class DefaultCubeService implements CubeService{

    @Override
    public Cube rotate(Cube cube, String face, String direction) {
        Cube result;

        if (face.equals("0")) {
            result = rotateTop(cube, direction);
        } else if (face.equals("1")) {
            result = rotateLeft(cube, direction);
        } else if (face.equals("2")) {
            result = rotateRight(cube, direction);
        } else if (face.equals("3")) {
            result = rotateFront(cube, direction);
        } else if (face.equals("4")) {
            result = rotateBottom(cube, direction);
        } else {
            result = rotateBack(cube, direction);
        }

        return result;
    }

    public String rotateFace(String face, String direction) {
        if (direction.equals("0")){
            return face.substring(6,7) + face.substring(3,4) +
                    face.substring(0,1) + face.substring(7,8) +
                    face.substring(4,5) + face.substring(1,2) +
                    face.substring(8,9) + face.substring(5,6) +
                    face.substring(2,3);
        } else {
            return face.substring(2,3) + face.substring(5,6) +
                    face.substring(8,9) + face.substring(1,2) +
                    face.substring(4,5) + face.substring(7,8) +
                    face.substring(0,1) + face.substring(3,4) +
                    face.substring(6,7);
        }
    }

    public Cube rotateTop(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")) {
            result.setTop(rotateFace(cube.getTop(), direction));
            result.setLeft(cube.getFront().substring(0,3) +
                    cube.getLeft().substring(3,9));
            result.setRight(cube.getBack().substring(0,3) +
                    cube.getRight().substring(3,9));
            result.setFront(cube.getRight().substring(0,3) +
                    cube.getFront().substring(3,9));
            result.setBottom(cube.getBottom());
            result.setBack(cube.getLeft().substring(0,3) +
                    cube.getBack().substring(3,9));
        } else {
            result.setTop(rotateFace(cube.getTop(), direction));
            result.setLeft(cube.getBack().substring(0,3) +
                    cube.getLeft().substring(3,9));
            result.setRight(cube.getFront().substring(0,3) +
                    cube.getRight().substring(3,9));
            result.setFront(cube.getLeft().substring(0,3) +
                    cube.getFront().substring(3,9));
            result.setBottom(cube.getBottom());
            result.setBack(cube.getRight().substring(0,3) +
                    cube.getBack().substring(3,9));
        }
        return result;
    }

    public Cube rotateLeft(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")) {
            result.setTop(cube.getBack().substring(8,9) +
                    cube.getTop().substring(1,3) +
                    cube.getBack().substring(5,6) +
                    cube.getTop().substring(4,6) +
                    cube.getBack().substring(2,3) +
                    cube.getTop().substring(7,9));
            result.setLeft(rotateFace(cube.getLeft(), direction));
            result.setRight(cube.getRight());
            result.setFront(cube.getTop().substring(0,1) +
                    cube.getFront().substring(1,3) +
                    cube.getTop().substring(3,4) +
                    cube.getFront().substring(4,6) +
                    cube.getTop().substring(6,7) +
                    cube.getFront().substring(7,9));
            result.setBottom(cube.getFront().substring(0,1) +
                    cube.getBottom().substring(1,3) +
                    cube.getFront().substring(3,4) +
                    cube.getBottom().substring(4,6) +
                    cube.getFront().substring(6,7) +
                    cube.getBottom().substring(7,9));
            result.setBack(cube.getBack().substring(0,2) +
                    cube.getBottom().substring(0,1) +
                    cube.getBack().substring(3,5) +
                    cube.getBottom().substring(3,4) +
                    cube.getBack().substring(6,8) +
                    cube.getBottom().substring(6,7));

        } else if (direction.equals("1")) {
            result.setTop(cube.getFront().substring(0,1) +
                    cube.getTop().substring(1,3) +
                    cube.getFront().substring(3,4) +
                    cube.getTop().substring(4, 6) +
                    cube.getFront().substring(6, 7) +
                    cube.getTop().substring(7, 9));
            result.setLeft(rotateFace(cube.getLeft(), direction));
            result.setRight(cube.getRight());
            result.setFront(cube.getBottom().substring(0,1) +
                    cube.getFront().substring(1,3) +
                    cube.getBottom().substring(3,4) +
                    cube.getFront().substring(4, 6) +
                    cube.getBottom().substring(6, 7) +
                    cube.getFront().substring(7, 9));
            result.setBottom(cube.getBack().substring(8,9) +
                    cube.getBottom().substring(1,3) +
                    cube.getBack().substring(5,6) +
                    cube.getBottom().substring(4, 6) +
                    cube.getBack().substring(2,3) +
                    cube.getBottom().substring(7, 9));
            result.setBack(cube.getBack().substring(0,2) +
                    cube.getTop().substring(6,7) +
                    cube.getBack().substring(3,5) +
                    cube.getTop().substring(3,4) +
                    cube.getBack().substring(6,8) +
                    cube.getTop().substring(0,1));
        }
        return result;
    }

    public Cube rotateRight(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")) {
            result.setTop(cube.getTop().substring(0,2)+
                    cube.getFront().substring(2,3) +
                    cube.getTop().substring(3,5) +
                    cube.getFront().substring(5,6) +
                    cube.getTop().substring(6,8) +
                    cube.getFront().substring(8,9));
            result.setLeft(cube.getLeft());
            result.setRight(rotateFace(cube.getRight(), direction));
            result.setFront(cube.getFront().substring(0,2) +
                    cube.getBottom().substring(2,3) +
                    cube.getFront().substring(3,5) +
                    cube.getBottom().substring(5,6) +
                    cube.getFront().substring(6,8) +
                    cube.getBottom().substring(8,9));
            result.setBottom(cube.getBottom().substring(0,2) +
                    cube.getBack().substring(6,7) +
                    cube.getBottom().substring(3,5) +
                    cube.getBack().substring(3,4) +
                    cube.getBottom().substring(6,8) +
                    cube.getBack().substring(0,1));
            result.setBack(cube.getTop().substring(8,9) +
                    cube.getBack().substring(1,3) +
                    cube.getTop().substring(5,6) +
                    cube.getBack().substring(4,6) +
                    cube.getTop().substring(2,3) +
                    cube.getBack().substring(7,9));
        } else {
            result.setTop(cube.getTop().substring(0,2) +
                    cube.getBack().substring(6,7) +
                    cube.getTop().substring(3,5) +
                    cube.getBack().substring(3,4) +
                    cube.getTop().substring(6,8) +
                    cube.getBack().substring(0,1));
            result.setLeft(cube.getLeft());
            result.setRight(rotateFace(cube.getRight(), direction));
            result.setFront(cube.getFront().substring(0,2) +
                    cube.getTop().substring(2,3) +
                    cube.getFront().substring(3,5) +
                    cube.getTop().substring(5,6) +
                    cube.getFront().substring(6,8) +
                    cube.getTop().substring(8,9));
            result.setBottom(cube.getBottom().substring(0,2) +
                    cube.getFront().substring(2,3) +
                    cube.getBottom().substring(3,5) +
                    cube.getFront().substring(5,6) +
                    cube.getBottom().substring(6,8) +
                    cube.getFront().substring(8,9));
            result.setBack(cube.getBottom().substring(8,9) +
                    cube.getBack().substring(1,3)+
                    cube.getBottom().substring(5,6)+
                    cube.getBack().substring(4,6) +
                    cube.getBottom().substring(2,3) +
                    cube.getBack().substring(7,9));
        }
        return result;
    }

    public Cube rotateFront(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")){
            result.setTop(cube.getTop().substring(0,6) +
                    cube.getLeft().substring(8,9) +
                    cube.getLeft().substring(5,6) +
                    cube.getLeft().substring(2,3));
            result.setLeft(cube.getLeft().substring(0,2) +
                    cube.getBottom().substring(0,1) +
                    cube.getLeft().substring(3,5) +
                    cube.getBottom().substring(1,2) +
                    cube.getLeft().substring(6,8) +
                    cube.getBottom().substring(2,3));
            result.setRight(cube.getTop().substring(6,7) +
                    cube.getRight().substring(1,3) +
                    cube.getTop().substring(7,8) +
                    cube.getRight().substring(4,6) +
                    cube.getTop().substring(8,9) +
                    cube.getRight().substring(7,9));
            result.setFront(rotateFace(cube.getFront(),direction));
            result.setBottom(cube.getRight().substring(6,7) +
                    cube.getRight().substring(3,4) +
                    cube.getRight().substring(0,1) +
                    cube.getBottom().substring(3,9));
            result.setBack(cube.getBack());
        } else {
            result.setTop(cube.getTop().substring(0,6) +
                    cube.getRight().substring(0,1) +
                    cube.getRight().substring(3,4) +
                    cube.getRight().substring(6,7));
            result.setLeft(cube.getLeft().substring(0,2) +
                    cube.getTop().substring(8,9) +
                    cube.getLeft().substring(3,5) +
                    cube.getTop().substring(7,8) +
                    cube.getLeft().substring(6,8) +
                    cube.getTop().substring(6,7));
            result.setRight(cube.getBottom().substring(2,3) +
                    cube.getRight().substring(1,3) +
                    cube.getBottom().substring(1,2) +
                    cube.getRight().substring(4,6) +
                    cube.getBottom().substring(0,1) +
                    cube.getRight().substring(7,9));
            result.setFront(rotateFace(cube.getFront(),direction));
            result.setBottom(cube.getLeft().substring(2,3) +
                    cube.getLeft().substring(5,6) +
                    cube.getLeft().substring(8,9) +
                    cube.getBottom().substring(3,9));
            result.setBack(cube.getBack());
        }
        return result;
    }

    public Cube rotateBottom(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")){
            result.setTop(cube.getTop());
            result.setLeft(cube.getLeft().substring(0,6) +
                    cube.getBack().substring(6,9));
            result.setRight(cube.getRight().substring(0,6) +
                    cube.getFront().substring(6,9));
            result.setFront(cube.getFront().substring(0,6) +
                    cube.getLeft().substring(6,9));
            result.setBottom(rotateFace(cube.getBottom(), direction));
            result.setBack(cube.getBack().substring(0,6) +
                    cube.getRight().substring(6,9));
        } else {
            result.setTop(cube.getTop());
            result.setLeft(cube.getLeft().substring(0,6) +
                    cube.getFront().substring(6,9));
            result.setRight(cube.getRight().substring(0,6) +
                    cube.getBack().substring(6,9));
            result.setFront(cube.getFront().substring(0,6) +
                    cube.getRight().substring(6,9));
            result.setBottom(rotateFace(cube.getBottom(), direction));
            result.setBack(cube.getBack().substring(0,6) +
                    cube.getLeft().substring(6,9));
        }
        return result;
    }

    public Cube rotateBack(Cube cube, String direction) {
        Cube result = new Cube();
        if (direction.equals("0")){
            result.setTop(cube.getRight().substring(2,3) +
                    cube.getRight().substring(5,6) +
                    cube.getRight().substring(8,9) +
                    cube.getTop().substring(3,9));
            result.setLeft(cube.getTop().substring(2,3) +
                    cube.getLeft().substring(1,3) +
                    cube.getTop().substring(1,2) +
                    cube.getLeft().substring(4,6) +
                    cube.getTop().substring(0,1) +
                    cube.getLeft().substring(7,9));
            result.setRight(cube.getRight().substring(0,2) +
                    cube.getBottom().substring(8,9) +
                    cube.getRight().substring(3,5) +
                    cube.getBottom().substring(7,8) +
                    cube.getRight().substring(6,8) +
                    cube.getBottom().substring(6,7));
            result.setFront(cube.getFront());
            result.setBottom(cube.getBottom().substring(0,6) +
                    cube.getLeft().substring(0,1) +
                    cube.getLeft().substring(3,4) +
                    cube.getLeft().substring(6,7));
            result.setBack(rotateFace(cube.getBack(), direction));
        } else {
            result.setTop(cube.getLeft().substring(6,7) +
                    cube.getLeft().substring(3,4) +
                    cube.getLeft().substring(0,1) +
                    cube.getTop().substring(3,9));
            result.setLeft(cube.getBottom().substring(6,7) +
                    cube.getLeft().substring(1,3) +
                    cube.getBottom().substring(7,8) +
                    cube.getLeft().substring(4,6) +
                    cube.getBottom().substring(8,9) +
                    cube.getLeft().substring(7,9));
            result.setRight(cube.getRight().substring(0,2) +
                    cube.getTop().substring(0,1) +
                    cube.getRight().substring(3,5) +
                    cube.getTop().substring(1,2) +
                    cube.getRight().substring(6,8) +
                    cube.getTop().substring(2,3));
            result.setFront(cube.getFront());
            result.setBottom(cube.getBottom().substring(0,6) +
                    cube.getRight().substring(8,9) +
                    cube.getRight().substring(5,6) +
                    cube.getRight().substring(2,3));
            result.setBack(rotateFace(cube.getBack(), direction));
        }
        return result;
    }
}
