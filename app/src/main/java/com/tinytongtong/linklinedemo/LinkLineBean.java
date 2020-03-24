package com.tinytongtong.linklinedemo;


import java.util.Objects;

/**
 * @Description: 表示LinkLine对象
 * @Author wangdandandefather
 * @Date 2019-11-26 17:39
 * @Version
 */
public class LinkLineBean {
    public static final String COLOR_BLACK = "#ff000000";
    public static final String COLOR_BLUE = "#1391EB";
    public static final String COLOR_RIGHT = "#ff00deab";
    public static final String COLOR_WRONG = "#ffff7c64";

    /**
     * 直线的横纵坐标
     */
    private float startX;
    private float startY;
    private float endX;
    private float endY;

    private String colorString = COLOR_BLUE;

    private boolean isRight;

    private int leftIndex = -1;
    private int rightIndex = -1;

    public LinkLineBean(float startX, float startY, float endX, float endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getEndX() {
        return endX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(float endY) {
        this.endY = endY;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    @Override
    public String toString() {
        return "LinkLineBean{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", colorString='" + colorString + '\'' +
                ", isRight=" + isRight +
                ", leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkLineBean)) {
            return false;
        }
        LinkLineBean that = (LinkLineBean) o;
        return (Float.compare(that.startX, startX) == 0 &&
                Float.compare(that.startY, startY) == 0 &&
                Float.compare(that.endX, endX) == 0 &&
                Float.compare(that.endY, endY) == 0)
                || (Float.compare(that.startX, endX) == 0 &&
                Float.compare(that.startY, endY) == 0 &&
                Float.compare(that.endX, startX) == 0 &&
                Float.compare(that.endY, startY) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startX, startY, endX, endY);
    }
}
