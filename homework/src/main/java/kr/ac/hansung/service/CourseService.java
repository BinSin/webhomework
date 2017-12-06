package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Credit;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDao;

	public List<Credit> getCredits() {
		return courseDao.getCredits();
	}
	
	public List<Course> getCourses(int year, int semester) {
		return courseDao.getCourses(year, semester);
	}
}
