package com.example.assignment2.controller;

import com.example.assignment2.config.authentication.JwtTokenUtil;
import com.example.assignment2.dto.LoginDto;
import com.example.assignment2.dto.RegisterDto;
import com.example.assignment2.exception.ForbiddenException;
import com.example.assignment2.model.User;
import com.example.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/students")
    public List<User> showStudents() {
        return userService.getAllUsers().stream().filter(user -> user.getRole().equals("STUDENT")).collect(Collectors.toList());
    }

    @PostMapping
    public String addStudent(@RequestBody User user, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        verifyUserRole(token, "TEACHER");
        if(user.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        return userService.saveUser(user);
    }

    @PostMapping("/student/register")
    public void register(@RequestBody RegisterDto registerDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        verifyUserRole(token, "STUDENT");
        userService.registerUser(registerDto.getPassword(), token);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto login) {
        return userService.login(login.getUsername(), login.getPassword());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUserById(id);
    }


    private void verifyUserRole(String token, String roleNeeded) {
        Optional<String> role = userService.getJwtTokenUtil().getRoleFromToken(token.substring(7));
        if(!role.isPresent() || !Objects.equals(role.get(), roleNeeded)) {
            throw new ForbiddenException("The user does not have teacher role!");
        }
    }

}
