package ru.appline.logic;

import java.util.ArrayList;
import java.util.List;

public class Dir {
    private String name;
    private int low;
    private int high;

    public Dir() {
    }

    public Dir(String name, int low, int high) {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public List<Integer> createRange(int low, int high) {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = low; i < high; i++) {
            range.add(i);
        }
        return range;
    }
}
