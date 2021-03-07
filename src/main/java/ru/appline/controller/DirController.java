package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.Dir;
import ru.appline.logic.DirModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DirController {

    private static final DirModel dirModel = DirModel.getInstance();
    private static final Map<String, String> response = new HashMap<>();

    @PostMapping(value = "/createDir", consumes = "application/json", produces = "application/json")
    public void createDir(@RequestBody Dir dir) {
        dirModel.addDir(dir);
    }

    @GetMapping(value = "/getAllDirs", produces = "application/json")
    public Map<String, List<Integer>> getAllDirs() {
        return dirModel.getAll();
    }

    @GetMapping(value = "/getDir", produces = "application/json")
    public Map<String, String> getDirByDegree(@RequestBody Map<String, Integer> request) {
        response.put("Side: ", dirModel.getDirByDegree(request.get("degree")));
        return response;
    }
}
