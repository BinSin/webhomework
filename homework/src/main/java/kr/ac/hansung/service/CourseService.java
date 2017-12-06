package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseDAO courseDao;
	
	
	public List<Course> getCourses() {
		return courseDao.getCourses();
	}
	
	public List<Integer> getCredits() {
		return courseDao.getCredits(new Course());
	}

}
