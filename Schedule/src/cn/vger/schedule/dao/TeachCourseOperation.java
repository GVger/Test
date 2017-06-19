package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class TeachCourseOperation {
	private List<cn.vger.schedule.model.TeachCourse> teachCourseData = new ArrayList<cn.vger.schedule.model.TeachCourse>();
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public TeachCourseOperation(){
		init();
	}
	
	private void init(){
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teach_course");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.TeachCourse temp = new cn.vger.schedule.model.TeachCourse();
				temp.setTeachCourseId(rs.getString("teach_course_id"));
				temp.setCourseName(rs.getString("courseName"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setClassName(rs.getString("className"));
				temp.setTerm(rs.getString("term"));
				teachCourseData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.TeachCourse> getTeachCourseData() {
		return teachCourseData;
	}
	
	public List<cn.vger.schedule.model.TeachCourse> serachByTeachCourseId(String teachCourseId) {
		List<cn.vger.schedule.model.TeachCourse> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teach_course where teach_course_id=?");
			ps.setString(1, teachCourseId);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.TeachCourse temp = new cn.vger.schedule.model.TeachCourse();
				temp.setTeachCourseId(rs.getString("teach_course_id"));
				temp.setCourseName(rs.getString("courseName"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setClassName(rs.getString("className"));
				temp.setTerm(rs.getString("term"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void insert(String teachCourseId, String courseName, String teacherName, String className, String term) {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into teach_course values(?,?,?,?,?)");
			ps.setString(1, teachCourseId);
			ps.setString(2, courseName);
			ps.setString(3, teacherName);
			ps.setString(4, className);
			ps.setString(5, term);
			ps.executeUpdate();
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
