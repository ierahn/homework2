package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.CourseDB;

@Service
public class CourseService {
	
	@Autowired
	private CourseDAO courseDao;
	
	public List<CourseDB> sortBySemester() {
		
		return courseDao.sortBySemester();
	}
	
	public List<CourseDB> mycourse(int year, int semester) {
		
		return courseDao.mycourse(year, semester);
	}

	public List<CourseDB> sortByCategory() {

		return courseDao.sortByCategory();
	}

	public void insert(CourseDB subject) {
		
		courseDao.insert(subject);
		
	}

	public List<CourseDB> getNewRegistration() {

		return courseDao.getNewRegistration();
	}

}
