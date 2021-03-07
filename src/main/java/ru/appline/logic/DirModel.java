package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirModel implements Serializable {
    private static final DirModel instance = new DirModel();
    public static DirModel getInstance() {
        return instance;
    }

    private final Map<String, List<Integer>> model;

    public DirModel() {
        model = new HashMap<>();
    }

    public void addDir(Dir dir) {
        model.put(dir.getName(), dir.createRange(dir.getLow(), dir.getHigh()));
    }

    public Map<String, List<Integer>> getAll() {
        return model;
    }

    public String getDirByDegree(int degree) {
        if (degree >= 0 && degree < 360) {
            return model.entrySet().stream()
                    .filter(entry -> entry.getValue().contains(degree))
                    .map(Map.Entry::getKey)
                    .findAny()
                    .get();
        } else return "Your degree is out of range";
    }
}
