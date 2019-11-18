package org.example.service;

import org.example.domain.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceTest {

  @Autowired private StudentService studentService;

  @Test
  void getAllStudentsTest() {
    Student student = new Student("firstName", "middleName", "lastName", 1);
    Student student1 = new Student("firstName", "middleName", "lastName", 1);
    studentService.saveOrUpdateStudent(student);
    studentService.saveOrUpdateStudent(student1);
    List<Student> students = studentService.getAllStudents();
    Assert.assertFalse(students.isEmpty());
    Assert.assertTrue(students.contains(student));
    Assert.assertTrue(students.contains(student1));
  }

  @Test
  void saveOrUpdateStudentTest() {
    Student student = new Student("firstName", "middleName", "lastName", 1);
    Student savedStudent = studentService.saveOrUpdateStudent(student);
    Assert.assertEquals(student, savedStudent);
    savedStudent.setCourse(2);
    savedStudent.setFirstName(null);
    try {
      Student errorStudent = studentService.saveOrUpdateStudent(savedStudent);
      Assert.assertNull(errorStudent);
    } catch (Exception e) {
      Assert.assertTrue(e instanceof TransactionSystemException);
    }
  }

  @Test
  void deleteStudentTest() {
    Student student = new Student("firstName", "middleName", "lastName", 1);
    Student savedStudent = studentService.saveOrUpdateStudent(student);
    studentService.deleteStudentById(savedStudent.getId());
    Assert.assertNull(studentService.getStudentById(savedStudent.getId()));
  }

  @Test
  void getStudentByIdTest() {
    Student student = new Student("firstName", "middleName", "lastName", 1);
    Student savedStudent = studentService.saveOrUpdateStudent(student);
    Assert.assertEquals(savedStudent, studentService.getStudentById(savedStudent.getId()));
    Assert.assertNull(studentService.getStudentById(savedStudent.getId() + 1));
  }
}
