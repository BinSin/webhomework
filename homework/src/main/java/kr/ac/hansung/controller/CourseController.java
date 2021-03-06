package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public String detail(@RequestParam int year, @RequestParam int semester, Model model) {
		// 받은 year, semester로 db조회
		List<Course> courses = courseService.getCourses(year, semester);

		model.addAttribute("courses", courses);

		return "detail";
	}

	@RequestMapping("/gradecheck2")
	public String gradeCheck2(Model model) {
		List<Credit2> credit = courseService.getCredits2();
		int totalCredit = courseService.getTotalCredit();

		model.addAttribute("credit", credit).addAttribute("totalCredit", totalCredit);

		return "gradecheck2";
	}

	@RequestMapping("/requestcourse")
	public String requestCourses(Model model) {

		model.addAttribute("course", new Course());

		return "requestcourse";
	}

	@RequestMapping("/dorequest")
	public String doRequest(Model model, @Valid Course course, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("===Form Data does not validated");
			// 모든 에러 저장
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "requestcourse";
		}

		courseService.insert(course);

		return "courserequested";
	}

	@RequestMapping("/checknewcourse")
	public String checkNewCourse(@RequestParam int year, @RequestParam int semester, Model model) {

		List<Course> courses = courseService.getCourses(year, semester);

		model.addAttribute("courses", courses);

		return "checknewcourse";
	}
}
