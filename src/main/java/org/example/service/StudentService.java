package org.example.service;

import org.example.domain.Student;
import org.example.repos.StudentRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Сервис для работы со студентами
 */
@Transactional
@Service
public class StudentService {

  /**
   * Репозиторий для работы со студентами
   */
  StudentRepo studentRepo;

  public StudentService(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  public Student saveOrUpdateStudent(Student student) {
    return studentRepo.save(student);
  }

  public void deleteStudentById(Long id) {
    studentRepo.deleteById(id);
  }

  public List<Student> getAllStudents() {
    return (List<Student>) studentRepo.findAll();
  }

  public Student getStudentById(Long id) {
    return studentRepo.findById(id).orElse(null);
  }
}
