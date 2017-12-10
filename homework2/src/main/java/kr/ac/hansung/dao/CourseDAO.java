package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.CourseDB;

@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<CourseDB> sortBySemester() {

		String sqlStatement = "select year, semester, sum(credits) as credits from mydb group by semester, year order by year, semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<CourseDB>() {
			public CourseDB mapRow(ResultSet rs, int rowNum) throws SQLException {

				CourseDB subject = new CourseDB();

				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setCredits(rs.getInt("credits"));

				return subject;

			}

		});
	}

	public List<CourseDB> sortByCategory() {
		String sqlStatement = "select ifnull(category,'총학점') category, sum(credits) as credits from mydb group by category with rollup";

		return jdbcTemplate.query(sqlStatement, new RowMapper<CourseDB>() {
			public CourseDB mapRow(ResultSet rs, int rowNum) throws SQLException {

				CourseDB subject = new CourseDB();

				subject.setCategory(rs.getString("category"));
				subject.setCredits(rs.getInt("credits"));

				return subject;

			}

		});
	}

	
	public boolean insert(CourseDB subject) {
		
		int year = subject.getYear();
		int semester = subject.getSemester();
		String code = subject.getCode();
		String name = subject.getName();
		String category = subject.getCategory();
		int credits = subject.getCredits();
		
		
		String sqlStatement = "insert into mydb (year, semester, code, name, category, credits) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, category, credits}) == 1);
		
	}

	public List<CourseDB> getNewRegistration() {
		
		String sqlStatement = "select * from mydb where year=2018";
		return jdbcTemplate.query(sqlStatement, new RowMapper<CourseDB>() {
			public CourseDB mapRow(ResultSet rs, int rowNum) throws SQLException {

				CourseDB subject = new CourseDB();

				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setCode(rs.getString("code"));
				subject.setName(rs.getString("name"));
				subject.setCategory(rs.getString("category"));
				subject.setCredits(rs.getInt("credits"));

				return subject;

			}

		});
	}

	public List<CourseDB> mycourse(int year, int semester) {
		
		String sqlStatement = "select * from mydb where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<CourseDB>() {
			public CourseDB mapRow(ResultSet rs, int rowNum) throws SQLException {

				CourseDB subject = new CourseDB();

				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setCode(rs.getString("code"));
				subject.setName(rs.getString("name"));
				subject.setCategory(rs.getString("category"));
				subject.setCredits(rs.getInt("credits"));

				return subject;

			}

		});
	}
	
}
