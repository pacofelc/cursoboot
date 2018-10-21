package com.cuatro.cursoboot.repository;

import com.cuatro.cursoboot.entity.CourseEntity;
import com.cuatro.cursoboot.entity.QCourseEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CourseQueryDSL {
  private QCourseEntity qCourse = QCourseEntity.courseEntity;

  @PersistenceContext
  private EntityManager em;


  // Ejemplo de consulta. No utilizado en la aplicación.
  public CourseEntity find ( Boolean exists) {
    JPAQuery<CourseEntity> query = new JPAQuery<CourseEntity>(em);

    BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("op"));

    if (exists){
      predicateBuilder.and(qCourse.id.eq(23));
    } else {
      predicateBuilder.or(qCourse.id.eq(1));
    }

    CourseEntity course = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
    return course;
  }

}
