package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

  /**
   * Сервис для работы с студентами
   */
  StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PutMapping
  public ResponseEntity<Student> saveOrUpdateStudent(@RequestBody @Valid Student student) {
    return ResponseEntity.ok(studentService.saveOrUpdateStudent(student));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteStudentById(@PathVariable Long id) {
    studentService.deleteStudentById(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/all")
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.getStudentById(id));
  }

  @ExceptionHandler
  public ResponseEntity exceptionHandler(Exception e) {
    log.error("Student Controller error", e);
    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
