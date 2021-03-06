package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

	@NotEmpty(message="교과코드를 입력해 주세요")
	private String course_code;
	
	@NotEmpty(message="교과목명을 입력해 주세요")
	private String course_name;
	
	@NotEmpty(message="구분을 입력해 주세요")
	private String classification;
	
	// int는 NotNull을 사용해야 한다.
	@NotNull(message="학점을 입력해 주세요")
	private Integer credit;
	
}
