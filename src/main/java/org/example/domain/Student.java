package org.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student {

  /**
   * Идентификатор
   */
  @Id
  @SequenceGenerator(name = "gen_seq_student", sequenceName = "seq_student", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq_student")
  @Column(name = "id")
  private Long Id;

  /**
   * Имя
   */
  @Length(min = 1, max = 255)
  @NotNull
  @Column(name = "firstname")
  private String firstName;

  /**
   * Отчество
   */
  @Length(min = 1, max = 255)
  @Column(name = "middlename")
  private String middleName;

  /**
   * Фамилия
   */
  @Length(min = 1, max = 255)
  @NotNull
  @Column(name = "lastname")
  private String lastName;

  /**
   * Курс на котором учится студент
   */
  @Range(min = 1, max = 15)
  @NotNull
  @Column(name = "course")
  private Integer course;

  public Student(
      String firstName, String middleName, String lastName, Integer course) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.course = course;
  }
}
