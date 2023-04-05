package com.example.assignment2.service;

import com.example.assignment2.model.Laboratory;
import com.example.assignment2.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;
    public LaboratoryService(LaboratoryRepository laboratoryRepository){
        this.laboratoryRepository=laboratoryRepository;
    }

    public List<Laboratory> getAllLaboratories(){
        List <Laboratory> laboratories= new ArrayList<>();
        laboratoryRepository.findAll().forEach(laboratories::add);
    return laboratories;
    }

    public void saveLaboratory(Laboratory laboratory){
        laboratoryRepository.save(laboratory);
    }
    public Laboratory getLaboratoryById(long id){
        Optional<Laboratory> optional=laboratoryRepository.findById(id);
        Laboratory laboratory=null;
        if(optional.isPresent()){
            laboratory = optional.get();
        }else{
            throw new RuntimeException("Laboratory is not found for id::" + id);
        }
        return laboratory;
    }
    public void deleteLaboratoryById(long id){
        laboratoryRepository.deleteById(id);
    }

}
