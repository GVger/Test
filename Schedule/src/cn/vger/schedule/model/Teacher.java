package cn.vger.schedule.model;

public class Teacher {
	private String teacherNo;
	private String teacherName;
	private String teachCourseName;
	
	public Teacher(){}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeachCourseName() {
		return teachCourseName;
	}

	public void setTeachCourseName(String teachCourseName) {
		this.teachCourseName = teachCourseName;
	}
}
