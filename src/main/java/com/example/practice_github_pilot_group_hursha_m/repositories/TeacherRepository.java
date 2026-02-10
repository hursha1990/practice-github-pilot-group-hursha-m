package com.example.practice_github_pilot_group_hursha_m.repositories;

import com.example.practice_github_pilot_group_hursha_m.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Add query methods here if needed
}

