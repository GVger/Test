package cn.vger.schedule.service;

import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.dao.ClassOperation;
import cn.vger.schedule.dao.CourseAndTeacherOperation;
import cn.vger.schedule.dao.CourseOperation;
import cn.vger.schedule.dao.LoginCheck;
import cn.vger.schedule.dao.ShowScheduleOperation;
import cn.vger.schedule.dao.TeachCourseOperation;
import cn.vger.schedule.dao.TeacherOperation;

public class Service {
	private List<cn.vger.schedule.model.Class> classData = new ArrayList<cn.vger.schedule.model.Class>();
	private List<cn.vger.schedule.model.Course> courseData = new ArrayList<cn.vger.schedule.model.Course>();
	private List<cn.vger.schedule.model.Teacher> teacherData = new ArrayList<cn.vger.schedule.model.Teacher>();
	private List<cn.vger.schedule.model.TeachCourse> teachCourseData = new ArrayList<cn.vger.schedule.model.TeachCourse>();
	private List<cn.vger.schedule.model.ShowSchedule> showScheduleData = new ArrayList<cn.vger.schedule.model.ShowSchedule>();
	
	private LoginCheck loginCheck = new LoginCheck();
	private ClassOperation classOperation = new ClassOperation();
	private TeacherOperation teacherOperation = new TeacherOperation();
	private CourseOperation courseOperation = new CourseOperation();
	private TeachCourseOperation teachCourseOperation = new TeachCourseOperation();
	private CourseAndTeacherOperation catOperation = null;
	private ShowScheduleOperation scOperation = new ShowScheduleOperation();
	
	public Service() {
		init();
	}
	
	public List<cn.vger.schedule.model.Class> getClassData() {
		return classData;
	}
	
	public List<cn.vger.schedule.model.Course> getCourseData() {
		return courseData;
	}
	
	public List<cn.vger.schedule.model.Teacher> getTeacherData() {
		return teacherData;
	}
	
	public List<cn.vger.schedule.model.TeachCourse> getTeachCourseData() {
		return teachCourseData;
	}
	
	private void init() {
		classData = classOperation.getClassData();
		courseData = courseOperation.getCourseData();
		teacherData = teacherOperation.getTeacherData();
		teachCourseData = teachCourseOperation.getTeachCourseData();
		showScheduleData = scOperation.getShowScheduleData();
	}
	
	//#############Class表操作#############################
	public List<cn.vger.schedule.model.Class> serachByClassNo(String classNo) {
		return classOperation.serachByClassNo(classNo);
	}
	
	public List<cn.vger.schedule.model.Class> serachByClassName(String className) {
		return classOperation.serachByClassName(className);
	}
	
	public List<String> getClassNames() {
		return classOperation.getClassNames();
	}
	
	public void insertClass(String classNo, String className) {
		classOperation.insert(classNo, className);
	}
	
	//#############Course表操作############################
	public List<cn.vger.schedule.model.Course> serachByCourseNo(String courseNo) {
		return courseOperation.serachByCourseNo(courseNo);
	}
	
	public List<cn.vger.schedule.model.Course> serachByCourseName(String courseName) {
		return courseOperation.serachByCourseName(courseName);
	}
	
	public void insertCourse(String courseNo, String courseName) {
		courseOperation.insert(courseNo, courseName);
	}
	
	public List<String> getCourseName() {
		return courseOperation.getCourseName();
	}
 	
	//#############Teacher表操作###########################
	public List<cn.vger.schedule.model.Teacher> serachByTeacherNo(String teacherNo) {
		return teacherOperation.serachByTeacherNo(teacherNo);
	}

	public List<cn.vger.schedule.model.Teacher> serachByTeacherName(String teacherName) {
		return teacherOperation.serachByTeacherName(teacherName);
	}
	
	public List<String> getTeacherByCourse(String courseName) {
		return teacherOperation.getTeacherByCourse(courseName);
	}
	
	public List<String> getTeachers() {
		return teacherOperation.getTeachers();
	}
	
	public void insertTeacher(String teacherNo, String teacherName, String teachCourseName) {
		teacherOperation.insert(teacherNo, teacherName, teachCourseName);
	}
	
	//#############TeachCourse表操作########################
	public List<cn.vger.schedule.model.TeachCourse> serachByTeachCourseId(String teachCourseId) {
		return teachCourseOperation.serachByTeachCourseId(teachCourseId);
	}
	
	public void insertTeacheCourse(String teachCourseId, String courseName, String teacherName, String className, String term) {
		teachCourseOperation.insert(teachCourseId, courseName, teacherName, className, term);
	}
	
	public List<cn.vger.schedule.model.CourseAndTeacher> getBaseSchedule(String className, String term) {
		catOperation = new CourseAndTeacherOperation(className, term);
		return catOperation.getBaseData();
	}
	
	//#############综合表操作########################
	public List<cn.vger.schedule.model.ShowSchedule> getScheduleByClassAndTerm(String className, String term) {
		return scOperation.getScheduleByClassAndTerm(className, term);
	}
	
	
	public int getX(cn.vger.schedule.model.ShowSchedule showSchedule) {
		String time = showSchedule.getScheduleTime();
		return Integer.parseInt(time.substring(0, 1));
	}
	
	public int getY(cn.vger.schedule.model.ShowSchedule showSchedule) {
		String time = showSchedule.getScheduleTime();
		return Integer.parseInt(time.substring(2, 3));
	}
	
	public void insertSchedule(String scheduleId, String Id, String time){
		scOperation.insert(scheduleId, Id, time);
	}
	
	public List<cn.vger.schedule.model.UserInfo> getUserInfo() {
		return loginCheck.getUserInfo();
	}
}
