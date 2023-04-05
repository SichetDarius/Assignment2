package com.example.assignment2.service;

import com.example.assignment2.model.Assignment;
import com.example.assignment2.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository){
        this.assignmentRepository=assignmentRepository;
    }

    public List<Assignment> getAllAssignments() {
        List<Assignment> assignments  = new ArrayList<>();

        assignmentRepository.findAll()
                .forEach(assignments::add);

        return assignments;
    }
    public Assignment getAssignmentById(long id) {
        Optional<Assignment> optional = assignmentRepository.findById(id);
        Assignment assignment = null;
        if(optional.isPresent()){
            assignment = optional.get();
        }else{
            throw new RuntimeException("Assignment is not found for id::" + id);
        }
        return assignment;
    }

    public void saveAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
    }
    public void deleteAssignmentById(long id){
        assignmentRepository.deleteById(id);
    }

}
