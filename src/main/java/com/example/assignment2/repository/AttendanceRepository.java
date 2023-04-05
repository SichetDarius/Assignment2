package com.example.assignment2.repository;

import com.example.assignment2.model.Attendance;
import com.example.assignment2.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
