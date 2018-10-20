package com.cuatro.cursoboot.service.impl;

import com.cuatro.cursoboot.model.CourseEntity;
import com.cuatro.cursoboot.repository.CourseJpaRepository;
import com.cuatro.cursoboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CourseServiceImpl implements CourseService {
  @Autowired
  @Qualifier("courseJpaRepository")
  private CourseJpaRepository courseJpaRepository;

  @Override
  public List<CourseEntity> listAll() {
    return courseJpaRepository.findAll();
  }

  @Override
  public CourseEntity add(CourseEntity courseEntity) {
    return courseJpaRepository.save( courseEntity );
  }

  @Override
  public int remove(int id) {
    courseJpaRepository.deleteById(id);
    return 0;
  }

  @Override
  public CourseEntity update(CourseEntity courseEntity) {
    return courseJpaRepository.save(courseEntity);
  }
}
