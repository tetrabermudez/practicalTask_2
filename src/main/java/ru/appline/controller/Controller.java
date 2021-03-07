package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public Map<String, String> createPet(@RequestBody Pet pet) {
        int id = newId.getAndIncrement();
        petModel.add(pet, id);
        pet.setId(id);
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

    @DeleteMapping(value = "/deletePet", consumes = "application/json")
    public void deletePetById(@RequestBody Map<String, Integer> id) {
        petModel.delete(id.get("id"));
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public void updatePet(@RequestBody Pet pet) {
        Pet newPet = petModel.getFromList(pet.getId());
        newPet.setName(pet.getName());
        newPet.setType(pet.getType());
        newPet.setAge(pet.getAge());
    }
}
