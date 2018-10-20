package com.cuatro.cursoboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import com.cuatro.cursoboot.model.CourseEntity;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<CourseEntity, Serializable> {
}
