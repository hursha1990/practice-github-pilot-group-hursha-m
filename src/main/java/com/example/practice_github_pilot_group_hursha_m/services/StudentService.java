package com.example.practice_github_pilot_group_hursha_m.services;

import com.example.practice_github_pilot_group_hursha_m.models.Student;
import com.example.practice_github_pilot_group_hursha_m.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Get all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Get a student by ID
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Create a new student
     */
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Update an existing student
     */
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student existingStudent = student.get();
            if (studentDetails.getName() != null) {
                existingStudent.setName(studentDetails.getName());
            }
            if (studentDetails.getGrade() != null) {
                existingStudent.setGrade(studentDetails.getGrade());
            }
            if (studentDetails.getEmail() != null) {
                existingStudent.setEmail(studentDetails.getEmail());
            }
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    /**
     * Delete a student by ID
     */
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Count total students
     */
    public long countStudents() {
        return studentRepository.count();
    }
}

