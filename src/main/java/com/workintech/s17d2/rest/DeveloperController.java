package com.workintech.s17d2.rest;

import com.workintech.model.*;
import com.workintech.s17d2.rest.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/developers")
public class DeveloperController {

    static Map<Integer, Developer> developers;

  private  final Taxable taxable;

    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public  Object devs (){
        developers = new HashMap<>();
        return null;
    }

    // [GET] /workintech/developers
    @GetMapping
    public ArrayList<Developer> getAllDevelopers() {
        return new ArrayList<>(developers.values());
    }

    // [GET] /workintech/developers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Integer id) {
        Developer developer = developers.get(id);
        if (developer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(developer);
    }

    // [POST] /workintech/developers
    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer request) {

        double salary = request.getSalary();
        Experience exp = request.getExperience();

        Developer newDeveloper;

        switch (exp) {
            case JUNIOR -> {
                salary -= salary * taxable.getSimpleRateTax();
                newDeveloper = new JuniorDeveloper(
                        request.getId(),
                        request.getName(),request.getExperience(),
                        salary
                );
            }
            case MID -> {
                salary -= salary * taxable.getMiddleRateTax();
                newDeveloper = new MidDeveloper(
                        request.getId(),
                        request.getName(), request.getExperience(),
                        salary
                );
            }
            case SENIOR -> {
                salary -= salary * taxable.getUpperRateTax();
                newDeveloper = new SeniorDeveloper(
                        request.getId(),
                        request.getName(), request.getExperience(),
                        salary
                );
            }
            default -> throw new IllegalArgumentException("Invalid experience level");
        }

        developers.put(Integer.valueOf(request.getId()), newDeveloper);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDeveloper);

    }

    // [PUT] /workintech/developers/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(
            @PathVariable Integer id,
            @RequestBody Developer updatedDeveloper) {

        if (!developers.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        developers.put(id, updatedDeveloper);
        return ResponseEntity.ok(updatedDeveloper);
    }

    // [DELETE] /workintech/developers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Integer id) {

        if (!developers.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        developers.remove(id);
        return ResponseEntity.ok("Developer deleted successfully.");
    }

}
