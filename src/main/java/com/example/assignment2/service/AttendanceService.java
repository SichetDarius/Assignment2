package com.example.assignment2.service;

import com.example.assignment2.model.Assignment;
import com.example.assignment2.model.Attendance;
import com.example.assignment2.model.Laboratory;
import com.example.assignment2.model.User;
import com.example.assignment2.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    public void saveAttendance(Attendance attendance){
        attendanceRepository.save(attendance);
    }
    public void deleteAttendanceById(long id){
        attendanceRepository.deleteById(id);
    }
    public List<Attendance> getAllAttendances() {
        List<Attendance> attendance  = new ArrayList<>();

        attendanceRepository.findAll()
                .forEach(attendance::add);

        return attendance;
    }


    public Attendance getAttendanceById(long id) {
        Optional<Attendance> optional = attendanceRepository.findById(id);
        Attendance attendance = null;
        if(optional.isPresent()){
            attendance = optional.get();
        }else{
            throw new RuntimeException("Assignment is not found for id::" + id);
        }
        return attendance;
    }
}



