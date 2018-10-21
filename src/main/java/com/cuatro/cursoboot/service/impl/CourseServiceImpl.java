package com.cuatro.cursoboot.service.impl;

import com.cuatro.cursoboot.converter.CourseConverter;
import com.cuatro.cursoboot.entity.CourseEntity;
import com.cuatro.cursoboot.model.Course;
import com.cuatro.cursoboot.repository.CourseJpaRepository;
import com.cuatro.cursoboot.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

  private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
  @Autowired
  @Qualifier("courseJpaRepository")
  private CourseJpaRepository courseJpaRepository;

  @Autowired
  private CourseConverter courseConverter;

  @Override
  public List<CourseEntity> listAll() {
    LOG.info("Call: listAll()");

    return courseJpaRepository.findAll();
  }

  @Override
  public CourseEntity add(Course course) {
    LOG.info("Call: add()");

    CourseEntity courseEntity = courseConverter.model2entity(course);

    return courseJpaRepository.save(courseEntity);
  }

  @Override
  public CourseEntity update(Course course) {
    LOG.info("Call: update()");
    CourseEntity courseEntity = courseConverter.model2entity(course);

    return courseJpaRepository.save(courseEntity);
  }

  @Override
  public int remove(int id) {
    courseJpaRepository.deleteById(id);
    return 0;
  }

}
