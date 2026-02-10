package com.example.practice_github_pilot_group_hursha_m.services;

import com.example.practice_github_pilot_group_hursha_m.models.Teacher;
import com.example.practice_github_pilot_group_hursha_m.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Get all teachers
     */
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    /**
     * Get a teacher by ID
     */
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    /**
     * Create a new teacher
     */
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    /**
     * Update an existing teacher
     */
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            Teacher existingTeacher = teacher.get();
            if (teacherDetails.getName() != null) {
                existingTeacher.setName(teacherDetails.getName());
            }
            if (teacherDetails.getDepartment() != null) {
                existingTeacher.setDepartment(teacherDetails.getDepartment());
            }
            if (teacherDetails.getSubject() != null) {
                existingTeacher.setSubject(teacherDetails.getSubject());
            }
            if (teacherDetails.getEmail() != null) {
                existingTeacher.setEmail(teacherDetails.getEmail());
            }
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }

    /**
     * Delete a teacher by ID
     */
    public boolean deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Count total teachers
     */
    public long countTeachers() {
        return teacherRepository.count();
    }
}

