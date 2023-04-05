package com.example.assignment2.controller;

import com.example.assignment2.model.Assignment;
import com.example.assignment2.model.Attendance;
import com.example.assignment2.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/assignments")
@RestController
public class AssignmentController {
@Autowired
    private AssignmentService assignmentService;
    @GetMapping
public List<Assignment> getAllAssignments(){
    List <Assignment> assignment=assignmentService.getAllAssignments();
    return assignment;
}

    @PostMapping
    public void addAssigment(@RequestBody Assignment assignment) {
        assignmentService.saveAssignment(assignment);
    }
    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable(value = "id") long id) {
        assignmentService.deleteAssignmentById(id);
    }

}
