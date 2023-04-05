package com.example.assignment2.service;

import com.example.assignment2.config.authentication.JwtTokenUtil;
import com.example.assignment2.model.AssignmentSubmission;
import com.example.assignment2.model.User;
import com.example.assignment2.repository.AssignmentSubmissionRepository;
import com.example.assignment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentSubmissionService {

    @Autowired
    AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public void addSubmission(AssignmentSubmission assignmentSubmission, String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token.substring(7));
        Optional<User> foundUser = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
        if (foundUser.isPresent()) {
            assignmentSubmission.setUser(foundUser.get());
            assignmentSubmissionRepository.save(assignmentSubmission);
        }
    }

    public void addGradeToSubmission(Long submissionId, int grade) {
        Optional<AssignmentSubmission> assignmentSubmission
                = assignmentSubmissionRepository.findAll()
                                                .stream().filter(assignmentSubmission1 -> assignmentSubmission1.getId_assignment_submission().equals(submissionId)).findFirst();
        if(assignmentSubmission.isPresent()) {
            assignmentSubmission.get().setGrade(grade);
            assignmentSubmissionRepository.save(assignmentSubmission.get());
        }
    }
}
