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
import kr.ac.hansung.model.Credit2;

// 이것을 Bean으로 등록하겠다는 의미
@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	// 상세보기
	public List<Course> getCourses(int year, int semester) {
		String sqlStatement = "select * from courses where year=? and semester=?";
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
	
	// 학년/학기별 이수 총 학점 보기
	public List<Credit> getCredits() {
		String sqlStatement = "select year, semester, sum(credit) from courses group by year, semester;";
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
	
	// 이수 구분별 학점내역 보기
	public List<Credit2> getCredits2() {
		String sqlStatement = "select classification, sum(credit) from courses where year<2018 group by classification ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Credit2>() {
			public Credit2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Credit2 credit2 = new Credit2();
				
				credit2.setClassification(rs.getString("classification"));
				credit2.setCredit(rs.getInt("sum(credit)"));
				
				return credit2;
			}
		});
	}
	
	// 총학점 계산
	public int getTotalCredit() {
		String sqlStatement = "select sum(Credit) from courses";
		
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// 2018년 1학기 수강신청
	public boolean insert(Course course) {
		
		String course_code = course.getCourse_code();
		String course_name = course.getCourse_name();
		String classification = course.getClassification();
		int credit = course.getCredit();
		
		String sqlStatement = "insert into courses values (2018, 1, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {course_code, course_name, classification, credit}) == 1);
	}

}