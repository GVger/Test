package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class TeacherOperation {
	private List<cn.vger.schedule.model.Teacher> teacherData = new ArrayList<cn.vger.schedule.model.Teacher>();

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public TeacherOperation(){
		init();
	}
	
	public List<cn.vger.schedule.model.Teacher> getTeacherData() {
		return teacherData;
	}
	
	private void init() {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teacher");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Teacher temp = new cn.vger.schedule.model.Teacher();
				temp.setTeacherNo(rs.getString("teacherNo"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setTeachCourseName(rs.getString("teachCourseName"));
				teacherData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.Teacher> serachByTeacherNo(String teacherNo) {
		List<cn.vger.schedule.model.Teacher> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teacher where teacherNo=?");
			ps.setString(1, teacherNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Teacher temp = new cn.vger.schedule.model.Teacher();
				temp.setTeacherNo(rs.getString("teacherNo"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setTeachCourseName(rs.getString("teachCourseName"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<cn.vger.schedule.model.Teacher> serachByTeacherName(String teacherName) {
		List<cn.vger.schedule.model.Teacher> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from teacher where teacherName=?");
			ps.setString(1, teacherName);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Teacher temp = new cn.vger.schedule.model.Teacher();
				temp.setTeacherNo(rs.getString("teacherNo"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setTeachCourseName(rs.getString("teachCourseName"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<String> getTeacherByCourse(String courseName) {
		List<String> teacherNames = new ArrayList<String>();
		String temp = "";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select teacherName from teacher where courseName=?");
			ps.setString(1, courseName);
			rs = ps.executeQuery();
			while(rs.next()) {
				temp = rs.getString("teacherName");
				teacherNames.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherNames;
	}
	
	public List<String> getTeachers(){
		List<String> teacherNames = new ArrayList<String>();
		String temp = "";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select teacherName from teacher");
			rs = ps.executeQuery();
			while(rs.next()) {
				temp = rs.getString("teacherName");
				teacherNames.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherNames;
	}
	
	public void insert(String teacherNo, String teacherName, String teachCourseName) {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into teacher values(?,?,?)");
			ps.setString(1, teacherNo);
			ps.setString(2, teacherName);
			ps.setString(3, teachCourseName);
			ps.executeUpdate();
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
