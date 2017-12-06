package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

// 이것을 Bean으로 등록하겠다는 의미
@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Integer> getCredits(Course course) {

		String sqlStatement = "select sum(credit) from courses where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {

				return rs.getInt("sum(credit)");
			}
		});
	}

	// query course return multiple objects
	public List<Course> getCourses() {
		String sqlStatement = "select * from courses where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCourse_code(rs.getString("course_code"));
				course.setCourse_name(rs.getString("course_name"));
				course.setClassification(rs.getString("classification"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}
		});
	}

	/*
	 * 학기별 이수 학점 조회 이수 구분별 학점 조회 수강 신청하기 수강 신청 조회 이 4가지 메뉴 만들기
	 */

}