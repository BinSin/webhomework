package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/gradecheck")
	public String gradeCheck(Model model) {
		List<Course> courses = courseService.getCourses();
		List<Integer> credits = courseService.getCredits();
		
		model.addAttribute("courses", courses)
		.addAttribute("credits", credits);
		
		return "gradecheck";
	}
	
}
