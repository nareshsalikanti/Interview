package com.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.Login;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping(value = { "/student" })
public class FrondEndController {

	private static final Logger logger = LoggerFactory.getLogger(FrondEndController.class);

	@Autowired
	StudentService studentService;

	@GetMapping({ "/", "/home" })
	public ModelAndView hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("home", new Login());
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("search", new Login());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("update");
		mav.addObject("student", new Login());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("student", new Student());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addstudent(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student") Student student) {
		studentService.createStudent(student);
		return new ModelAndView("created", "firstname", student.getName());
	}

	@RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
	public ModelAndView updatestudent(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student") Student student) {
		studentService.update(student, student.getId());
		return new ModelAndView("updated", "firstname", student.getName());
	}

	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
	public ModelAndView searchAll(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student") Student student) {
		List<Student> allStudents = studentService.getStudent();
		return new ModelAndView("showAll", "allStudents", allStudents);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("search") Login login) {
		ModelAndView mav = null;
		if (null != studentService.findByName(login.getstudentname())) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", login.getstudentname());
		} else {
			mav = new ModelAndView("search");
			mav.addObject("message", "student name  is not found!!");
		}
		return mav;
	}

}
