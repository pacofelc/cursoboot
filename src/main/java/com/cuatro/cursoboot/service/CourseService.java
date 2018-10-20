package com.cuatro.cursoboot.service;

import com.cuatro.cursoboot.model.CourseEntity;

import java.util.List;

public interface CourseService {

  List<CourseEntity> listAll();
  CourseEntity add(CourseEntity courseEntity);
  int remove (int id);
  CourseEntity update (CourseEntity courseEntity);

}
