package com.cuatro.cursoboot.controller;

import com.cuatro.cursoboot.model.Person;
import com.cuatro.cursoboot.service.PersonService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping ("/hello")
public class HelloController {

  public static final Log LOGGER = LogFactory.getLog(HelloController.class);
  public static final String EXAMPLE_VIEW="helloworld";
  public static final String FORM_VIEW="form";
  public static final String RESULT_VIEW="result";

  @Autowired
//  @Qualifier("personService")
  PersonService personService;

  // localhost:8080/hello
  // redirección a hello/world para la url sin spring
//  @GetMapping("")
//  String redirect(){
//    return "redirect:/hello/world";
//  }

  // localhost:8080/hello
  // redirección a hello/world para la url con spring
  @GetMapping("")
  public RedirectView redirect() {
    return new RedirectView("hello/world");
  }

  // Versión con model inyectado
  // localhost:8080/hello/world
  @GetMapping("/world")
  String world (Model model){
    model.addAttribute("person",new Person("Jon",35));
    model.addAttribute("people",personService.getListPeople());
    return EXAMPLE_VIEW;
  }

  // Versión con ModelAndView
  // localhost:8080/hello/mav
  @GetMapping("/mav")
  ModelAndView Mav () {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person",new Person("Miguel",20));
    mav.addObject("people",personService.getListPeople());
    return mav;
  }

  // Versión MaV con parámetros por request
  // localhost:8080/hello/mav_param?nm=pepe
  @GetMapping("/mav_param")
  ModelAndView mavRequestParm (@RequestParam (name="nm", required = false, defaultValue = "paco") String nm) {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person",new Person(nm,20));
    mav.addObject("people",personService.getListPeople());
    return mav;
  }

  // Versión MaV con parámetros por url
  // localhost:8080/hello/mav_param/PEPE
  @GetMapping("/mav_param_url/{nm}")
  ModelAndView mavPathVariable (@PathVariable (name="nm", required = false) String nm) {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person",new Person(nm,20));
    mav.addObject("people",personService.getListPeople());
    return mav;
  }

  @GetMapping("/showform")
  ModelAndView showForm () {
    ModelAndView mav = new ModelAndView(FORM_VIEW );
    mav.addObject("person",new Person());
    return mav;
  }

  @PostMapping("addPerson")
  ModelAndView addPerson ( @ModelAttribute("person") Person person ) {
    ModelAndView mav = new ModelAndView( RESULT_VIEW );
    mav.addObject("person", person);

    LOGGER.info("Template:"+RESULT_VIEW+ " Data" + person);
    return mav;

  }

  @GetMapping("/errorProvoke")
  ModelAndView errorProvoke () {
    ModelAndView mav = new ModelAndView(FORM_VIEW );
    Integer i=1;
    i=i/0;
    return mav;
  }



}
