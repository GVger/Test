package cn.vger.schedule.model;

public class TeachCourse {
	private String teachCourseId;
	private String courseName;
	private String teacherName;
	private String className;
	private String term;
	
	public TeachCourse(){}

	public String getTeachCourseId() {
		return teachCourseId;
	}

	public void setTeachCourseId(String teachCourseId) {
		this.teachCourseId = teachCourseId;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}
