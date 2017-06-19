package cn.vger.schedule.model;

public class ShowSchedule {
	private String courseName;
	private String teacherName;
	private String showSchedule;
	private String scheduleTime;
	
	public ShowSchedule(){}

	public String getShowSchedule() {
		return showSchedule;
	}

	public void setShowSchedule(String showSchedule) {
		this.showSchedule = showSchedule;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
