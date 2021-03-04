package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController()
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);
    private static final Map<String, String> message = new HashMap<>();

    @PostMapping(value = "/createPet", consumes = "application/json")
    public Map<String, String> createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        message.put("Message: ", pet.toString() + " was successfully created");
        return message;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

}
