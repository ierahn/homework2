package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.CourseDB;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/semester")
	public String showSemester(Model model) {
		List<CourseDB> semester = courseService.sortBySemester();
		model.addAttribute("semester", semester);
		
		return "semester";
	}
	
	@RequestMapping(value = "/mycourse", method = RequestMethod.GET)
	public String showSubjectList(HttpServletRequest httpServletRequest, Model model) {
		String year = httpServletRequest.getParameter("year");
		int yearInteger = Integer.parseInt(year);
		String semester = httpServletRequest.getParameter("semester");
		int semesterInteger = Integer.parseInt(semester);
		
		System.out.println(yearInteger);
		System.out.println(semesterInteger);
		
		List<CourseDB> mycourse = courseService.mycourse(yearInteger, semesterInteger);
		model.addAttribute("mycourse", mycourse);
		
		return "mycourse";
	}
	
	@RequestMapping("/category")
	public String showCategory(Model model) {
		List<CourseDB> category = courseService.sortByCategory();
		model.addAttribute("category", category);
		
		return "category";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		
		model.addAttribute("course",new CourseDB()); 
		return "registration";
	}
	
	
	@RequestMapping("/register")
	public String register(Model model, @Valid CourseDB course, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "registration";
		}
		
		courseService.insert(course);
		return "registered";
	}
	
	@RequestMapping("/newsemester")
	public String registered(Model model) {
		
		List<CourseDB> newRegistration = courseService.getNewRegistration();
		model.addAttribute("newsemester", newRegistration);
		
		return "newsemester";
	}

}
