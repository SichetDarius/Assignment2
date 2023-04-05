package com.example.assignment2.controller;

import com.example.assignment2.model.Attendance;
import com.example.assignment2.model.User;
import com.example.assignment2.service.AttendanceService;
import com.example.assignment2.service.LaboratoryService;
import com.example.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/attendance")
@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
 public List<Attendance> getAllAttendances(){
     List<Attendance> attendances = attendanceService.getAllAttendances();
     return attendances;
 }
    @PostMapping
    public void addAttendance(@RequestBody Attendance attendance) {
        attendanceService.saveAttendance(attendance);
    }
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable(value = "id") long id) {
        attendanceService.deleteAttendanceById(id);
    }
    @GetMapping("/laboratory/{idLaboratory}")
    public List<Attendance> getAllAttendancesForLaboratoryId(@PathVariable(value = "idLaboratory") long idLaboratory) {
        return attendanceService.getAllAttendances().stream().filter(attendance -> attendance.getLaboratory().getId_laboratory() == idLaboratory).collect(Collectors.toList());
    }


}
