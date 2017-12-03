package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	private int year;
	private int semester;
	private String course_code;
	private String course_name;
	private String classification;
	private int credit;
	
}
