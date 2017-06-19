package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class CourseOperation {
	private List<cn.vger.schedule.model.Course> courseData = new ArrayList<cn.vger.schedule.model.Course>();

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public CourseOperation(){
		init();
	}
	
	public List<cn.vger.schedule.model.Course> getCourseData() {
		return courseData;
	}
	
	private void init() {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from course");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Course temp = new cn.vger.schedule.model.Course();
				temp.setCourseNo(rs.getString("courseNo"));
				temp.setCourseName(rs.getString("courseName"));
				courseData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.Course> serachByCourseNo(String courseNo) {
		List<cn.vger.schedule.model.Course> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from course where courseNo=?");
			ps.setString(1, courseNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Course temp = new cn.vger.schedule.model.Course();
				temp.setCourseNo(rs.getString("courseNo"));
				temp.setCourseName(rs.getString("courseName"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<cn.vger.schedule.model.Course> serachByCourseName(String courseName) {
		List<cn.vger.schedule.model.Course> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from course where courseName=?");
			ps.setString(1, courseName);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Course temp = new cn.vger.schedule.model.Course();
				temp.setCourseNo(rs.getString("courseNo"));
				temp.setCourseName(rs.getString("courseName"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<String> getCourseName() {
		List<String> courseNameData = new ArrayList<String>();
		String temp = "";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select courseName from course");
			rs = ps.executeQuery();
			while(rs.next()) {
				temp = rs.getString("courseName");
				courseNameData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseNameData;
	}
	
	public void insert(String courseNo, String courseName) {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into course values(?,?)");
			ps.setString(1, courseNo);
			ps.setString(2, courseName);
			ps.executeUpdate();
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
