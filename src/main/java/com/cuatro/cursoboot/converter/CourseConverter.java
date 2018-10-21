package com.cuatro.cursoboot.converter;

import com.cuatro.cursoboot.entity.CourseEntity;
import com.cuatro.cursoboot.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

  public Course entity2model (CourseEntity entity){
    Course course = new Course();

    course.setId(entity.getId());
    course.setDescription(entity.getDescription());
    course.setHours(entity.getHours());
    course.setName(entity.getName());
    course.setPrice(entity.getPrice());

    return course;
  }

  public CourseEntity model2entity (Course model) {
    CourseEntity entity = new CourseEntity();

    entity.setId( model.getId());
    entity.setDescription( model.getDescription());
    entity.setHours(model.getHours());
    entity.setName(model.getName());
    entity.setPrice(model.getPrice());

    return entity;
  }
}
