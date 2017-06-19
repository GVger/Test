package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class CourseAndTeacherOperation {
	private List<cn.vger.schedule.model.CourseAndTeacher> data = new ArrayList<cn.vger.schedule.model.CourseAndTeacher>();

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public CourseAndTeacherOperation(String className, String term){
		init(className, term);
	}
	
	public List<cn.vger.schedule.model.CourseAndTeacher> getBaseData() {
		return data;
	}
	
	private void init(String className, String term) {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select res_schedule.teach_course_id,courseName,teacherName from res_schedule, teach_course where res_schedule.teach_course_id = teach_course.teach_course_id and className=? and term=?");
			ps.setString(1, className);
			ps.setString(2, term);
			rs = ps.executeQuery();
			data.removeAll(data);
			while(rs.next()) {
				cn.vger.schedule.model.CourseAndTeacher temp = new cn.vger.schedule.model.CourseAndTeacher();
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setCourseName(rs.getString("courseName"));
				temp.setId(rs.getString("res_schedule.teach_course_id"));
				data.add(temp);
			}
			System.out.println(data);	
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
