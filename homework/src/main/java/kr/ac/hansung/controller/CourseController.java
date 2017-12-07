package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Credit;
import kr.ac.hansung.model.Credit2;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/gradecheck")
	public String gradeCheck(Model model) {
		List<Credit> credits = courseService.getCredits();
		
		model.addAttribute("credits", credits);
		
		return "gradecheck";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int year,
			@RequestParam int semester,
			Model model) {
		// 받은  year, semester로 db조회
		List<Course> courses = courseService.getCourses(year, semester);
		
		model.addAttribute("courses", courses);
		
		return "detail";
	}
	
	@RequestMapping("/gradecheck2")
	public String gradeCheck2(Model model) {
		List<Credit2> credit = courseService.getCredits2();
		int totalCredit = courseService.getTotalCredit();
		
		model.addAttribute("credit", credit)
		.addAttribute("totalCredit", totalCredit);
		
		return "gradecheck2";
	}
	
}
