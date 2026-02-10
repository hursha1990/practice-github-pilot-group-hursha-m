package com.example.practice_github_pilot_group_hursha_m.repositories;

import com.example.practice_github_pilot_group_hursha_m.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add query methods here if needed
}

