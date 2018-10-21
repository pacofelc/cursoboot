package com.cuatro.cursoboot.service;

import com.cuatro.cursoboot.entity.CourseEntity;
import com.cuatro.cursoboot.model.Course;

import java.util.List;

public interface CourseService {

  List<CourseEntity> listAll();
  CourseEntity add(Course course);
  int remove (int id);
  CourseEntity update (Course course);

}
