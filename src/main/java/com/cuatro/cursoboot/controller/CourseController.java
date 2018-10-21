package com.cuatro.cursoboot.controller;

import com.cuatro.cursoboot.entity.CourseEntity;
import com.cuatro.cursoboot.model.Course;
import com.cuatro.cursoboot.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

  private static final String COURSES_VIEW="courses";

  private static final Log LOG= LogFactory.getLog(CourseController.class);

  @Autowired
  @Qualifier("courseServiceImpl")
  private CourseService courseService;

  // List
  @GetMapping("/list-courses")
  public ModelAndView listAllCourses(){
    LOG.info("Call: listAllCourses()");
    ModelAndView mav = new ModelAndView(COURSES_VIEW);

    mav.addObject("courses",courseService.listAll());
    mav.addObject( "newCourse", new Course());
    return mav;
  }

  // Insert usando model
  @PostMapping("/add-course")
  public String addCourse(@ModelAttribute("course") Course course){
    LOG.info("Call:: addCourse() --Param"+course.toString());
    ModelAndView mav = new ModelAndView(COURSES_VIEW);

    courseService.add( course );
    return "redirect:/courses/list-courses";
  }

  // Update usando model
  @PostMapping("/update-course")
  public String updateCourse(@ModelAttribute("course") Course course){
    LOG.info("Call:: updateCourse() --Param"+course.toString());
    ModelAndView mav = new ModelAndView(COURSES_VIEW);

    courseService.update( course );
    return "redirect:/courses/list-courses";
  }

}
