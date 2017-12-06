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
import kr.ac.hansung.model.Credit;

// 이것을 Bean으로 등록하겠다는 의미
@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	// query course return multiple objects
	public List<Course> getCourses(int year, int semester) {
		String sqlStatement = "select * from courses where year, semester";
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setCourse_code(rs.getString("course_code"));
				course.setCourse_name(rs.getString("course_name"));
				course.setClassification(rs.getString("classification"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}
		});
	}
	
	// query course return multiple objects
	public List<Credit> getCredits() {
		String sqlStatement = "select distinct year, semester, sum(credit) from courses group by year, semester;";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Credit>() {
			public Credit mapRow(ResultSet rs, int rowNum) throws SQLException {

				Credit credit = new Credit();

				credit.setYear(rs.getInt("year"));
				credit.setSemester(rs.getInt("semester"));
				credit.setSumCredit(rs.getInt("sum(credit)"));

				return credit;
			}
		});
	}


	/*
	 * 학기별 이수 학점 조회 이수 구분별 학점 조회 수강 신청하기 수강 신청 조회 이 4가지 메뉴 만들기
	 */

	
	public boolean insert(Offer offer) {
		
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "insert into offers (name, email, text) values (?, ?, ?)";
		
		// 몇개가 업데이트 되었는지 리턴해 준다.
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text}) == 1);
	}
	
	public boolean update(Offer offer) {
		
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
		
		// 몇개가 업데이트 되었는지 리턴해 준다.
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text, id}) == 1);
	}
	
	public boolean delete(int id) {
		
		String sqlStatement = "delete from offers where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}
}