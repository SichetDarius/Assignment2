package com.example.assignment2.repository;

import com.example.assignment2.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
}
