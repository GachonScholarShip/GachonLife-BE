package com.gachonproject.buildingservice.global.common.util;

public class FloorFormatter {

    public static String format(int floor) {
        return floor < 0
                ? "B" + Math.abs(floor)
                : Integer.toString(floor);
    }
}
