package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class ClassOperation {
	private List<cn.vger.schedule.model.Class> classData = new ArrayList<cn.vger.schedule.model.Class>();

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public ClassOperation(){
		init();
	}
	
	private void init() {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from class");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Class temp = new cn.vger.schedule.model.Class();
				temp.setClassNo(rs.getString("classNo"));
				temp.setClassName(rs.getString("className"));
				classData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.Class> getClassData() {
		return classData;
	}
	
	public List<cn.vger.schedule.model.Class> serachByClassNo(String classNo) {
		List<cn.vger.schedule.model.Class> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from class where classNo=?");
			ps.setString(1, classNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Class temp = new cn.vger.schedule.model.Class();
				temp.setClassNo(rs.getString("classNo"));
				temp.setClassName(rs.getString("className"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<cn.vger.schedule.model.Class> serachByClassName(String className) {
		List<cn.vger.schedule.model.Class> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from class where className=?");
			ps.setString(1, className);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.Class temp = new cn.vger.schedule.model.Class();
				temp.setClassNo(rs.getString("classNo"));
				temp.setClassName(rs.getString("className"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<String> getClassNames() {
		List<String> classNames = new ArrayList<String>();
		String temp = "";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select className from class");
			rs = ps.executeQuery();
			while(rs.next()) {
				temp = rs.getString("className");
				classNames.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classNames;
	}
	
	public void insert(String classNo, String className) {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into class values(?,?)");
			ps.setString(1, classNo);
			ps.setString(2, className);
			ps.executeUpdate();
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void main(String[] args) {
		ClassOperation classOperation = new ClassOperation();
		System.out.println("成功了？");
	}*/
}
