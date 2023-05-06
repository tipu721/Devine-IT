package com.tipu.crud.repository;

import com.tipu.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepsitory extends JpaRepository<Student, Integer> {
}
