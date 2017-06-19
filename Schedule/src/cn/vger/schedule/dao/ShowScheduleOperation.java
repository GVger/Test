package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class ShowScheduleOperation {
	private List<cn.vger.schedule.model.ShowSchedule> showScheduleData = new ArrayList<cn.vger.schedule.model.ShowSchedule>();
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public ShowScheduleOperation(){
		init();
	}
	
	private void init() {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select courseName,teacherName,schedule_time from res_schedule,teach_course where res_schedule.teach_course_id = teach_course.teach_course_id order by schedule_time");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.ShowSchedule temp = new cn.vger.schedule.model.ShowSchedule();
				temp.setCourseName(rs.getString("courseName"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setShowSchedule(rs.getString("courseName")+rs.getString("teacherName")+"");
				temp.setScheduleTime(rs.getString("schedule_time"));
				showScheduleData.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.ShowSchedule> getShowScheduleData() {
		return showScheduleData;
	}
	
	public List<cn.vger.schedule.model.ShowSchedule> getScheduleByClassAndTerm(String className, String term) {
		List<cn.vger.schedule.model.ShowSchedule> result = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select courseName,teacherName,schedule_time from res_schedule,teach_course where res_schedule.teach_course_id = teach_course.teach_course_id and className=? and term=?");
			ps.setString(1, className);
			ps.setString(2, term);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.ShowSchedule temp = new cn.vger.schedule.model.ShowSchedule();
				temp.setCourseName(rs.getString("courseName"));
				temp.setTeacherName(rs.getString("teacherName"));
				temp.setShowSchedule(rs.getString("courseName")+rs.getString("teacherName"));
				temp.setScheduleTime(rs.getString("schedule_time"));
				result.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void insert(String scheduleId, String Id, String time){
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into res_schedule values(?,?,?)");
			ps.setString(1, scheduleId);
			ps.setString(2, Id);
			ps.setString(3, time);
			ps.executeUpdate();
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
