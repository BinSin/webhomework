package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Credit;
import kr.ac.hansung.model.Credit2;

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
	
	public List<Credit2> getCredits2() {
		return courseDao.getCredits2();
	}
	
	public int getTotalCredit() {
		return courseDao.getTotalCredit();
	}
	
	public void insert(Course course) {
		courseDao.insert(course);
	}
}
