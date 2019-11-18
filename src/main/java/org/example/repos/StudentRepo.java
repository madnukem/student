package org.example.repos;

import org.example.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

  /**
   * Удаление студента по Id
   * @param id идентификатор студента
   */
  void deleteById(Long id);
}
