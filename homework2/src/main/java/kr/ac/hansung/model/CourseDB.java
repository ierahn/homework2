package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class CourseDB {
	
	private int year;
	private int semester;
	@Size(min=2,max=20, message="글자 길이는 2~20자 입니다.")
	@NotEmpty(message="빈 칸을 채우세요")
	private String code;
	@Size(min=2,max=20, message="글자 길이는 2~20자 입니다.")
	private String name;
	@NotEmpty(message="빈 칸을 채우세요")
	private String category;
	private int credits;

}
