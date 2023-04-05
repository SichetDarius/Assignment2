package com.example.assignment2.controller;

import com.example.assignment2.config.authentication.JwtTokenUtil;
import com.example.assignment2.dto.GradingRequestDto;
import com.example.assignment2.exception.ForbiddenException;
import com.example.assignment2.model.Assignment;
import com.example.assignment2.model.AssignmentSubmission;
import com.example.assignment2.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/assignment-submission")
@RestController
public class AssignmentSubmissionController {

    @Autowired
    private AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public void addAssigmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        verifyUserRole(token, "STUDENT");
        assignmentSubmissionService.addSubmission(assignmentSubmission, token);
    }

    @PostMapping("/{assignmentSubmissionId}")
    public void addGradeToSubmission(@RequestBody GradingRequestDto gradingRequestDto, @PathVariable(value = "assignmentSubmissionId") long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        verifyUserRole(token, "TEACHER");
        assignmentSubmissionService.addGradeToSubmission(id, gradingRequestDto.getGrade());
    }

    private void verifyUserRole(String token, String roleNeeded) {
        Optional<String> role = jwtTokenUtil.getRoleFromToken(token.substring(7));
        if(!role.isPresent() || !Objects.equals(role.get(), roleNeeded)) {
            throw new ForbiddenException("The user does not have teacher role!");
        }
    }

}
