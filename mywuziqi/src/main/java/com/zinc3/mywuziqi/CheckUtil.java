package com.zinc3.mywuziqi;

import android.graphics.Point;

import java.util.List;

/**
 * Created by zinc3 on 2017/1/5.
 * 检查是否有一方选手胜利
 */

public final class CheckUtil {

    public static boolean checkFiveInLine(List<Point> points,int MAX_COUNT_IN_LINE){
        for (Point p : points) {
            int x = p.x;
            int y = p.y;
            boolean win = CheckUtil.checkHorizontal(x, y, points, MAX_COUNT_IN_LINE);
            if (win) return true;
            win = CheckUtil.checkVetical(x, y, points, MAX_COUNT_IN_LINE);
            if (win) return true;
            win = CheckUtil.checkLeftDiagonal(x, y, points, MAX_COUNT_IN_LINE);
            if (win) return true;
            win = CheckUtil.checkRightDigonal(x, y, points, MAX_COUNT_IN_LINE);
            if (win) return true;
        }
        return false;
    }

    /**
     * 判断横向相连
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    private static boolean checkHorizontal(int x, int y, List<Point> points, int MAX_COUNT_IN_LINE) {
        int count = 1;
        // 左
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        // 右
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断纵向相连
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    private static boolean checkVetical(int x, int y, List<Point> points, int MAX_COUNT_IN_LINE) {
        int count = 1;
        // 上
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x, y - i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        // 下
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x, y + i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断左斜相连
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    private static boolean checkLeftDiagonal(int x, int y, List<Point> points, int MAX_COUNT_IN_LINE) {
        int count = 1;
        // 上
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y - i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        // 下
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y + i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断右斜相连
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    private static boolean checkRightDigonal(int x, int y, List<Point> points, int MAX_COUNT_IN_LINE) {
        int count = 1;
        // 上
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x + i, y - i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        // 下
        for (int i = 1; i < MAX_COUNT_IN_LINE; i++) {
            if (points.contains(new Point(x - i, y + i))) {
                count++;
            } else {
                break;
            }
        }
        if (count == MAX_COUNT_IN_LINE) return true;
        return false;
    }
}
