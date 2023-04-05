package com.example.assignment2.controller;


import com.example.assignment2.model.Laboratory;
import com.example.assignment2.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/laboratory")
@RestController
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;
    @GetMapping
    public List<Laboratory> getAllLaboratories(){
        List<Laboratory> laboratories=laboratoryService.getAllLaboratories();
        return laboratories;
    }

    @PostMapping
    public void addNewLaboratory(@RequestBody Laboratory laboratory){
        laboratoryService.saveLaboratory(laboratory);
    }

    @DeleteMapping("/{id}")
    public void deleteLaboratory(@PathVariable(value = "id") long id) {
        laboratoryService.deleteLaboratoryById(id);
    }

}
