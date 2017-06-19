<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>


<jsp:include page="teach_course.jsp"></jsp:include>
<%
	request.setCharacterEncoding("utf-8");

	String teachCourseId = request.getParameter("teach_course_id");
	String courseName = request.getParameter("courseName");
	String teacherName = request.getParameter("teacherName");
	String className = request.getParameter("className");
	String term = request.getParameter("term");
	
	teachCourseId = teachCourseId.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
	teachCourseId = URLDecoder.decode(teachCourseId, "utf-8"); 
	courseName = courseName.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
	courseName = URLDecoder.decode(courseName, "utf-8"); 
	teacherName = teacherName.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
	teacherName = URLDecoder.decode(teacherName, "utf-8"); 
	className = className.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
	className = URLDecoder.decode(className, "utf-8"); 
	term = term.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
	term = URLDecoder.decode(term, "utf-8"); 
	if (teachCourseId == null || teachCourseId.equals("")) {
%>
<script type="text/javascript">
	alert("请输入任课编号");
</script>

<%
	} else if (courseName == null || courseName.equals("") || courseName.equals("null")) {
%>
<script type="text/javascript">
	alert("没有课程数据");
</script>
<%
	} else if (teacherName == null || teacherName.equals("") || teacherName.equals("null")) {
%>
<script type="text/javascript">
	alert("没有老师数据");
</script>
<%
	} else if (className == null || className.equals("") || className.equals("null")) {
%>
<script type="text/javascript">
	alert("没有班级数据");
</script>
<%
	} else {
		Service service = new Service();
		List<cn.vger.schedule.model.TeachCourse> teachCourseTemp = service.serachByTeachCourseId(teachCourseId);
		if (teachCourseTemp.size() == 0) {//表示没有这个数据，查看是否有相同的班级名字
			service.insertTeacheCourse(teachCourseId, courseName, teacherName, className, term);
%>
<script type="text/javascript">
	alert("新建成功");
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("已经有该数据了");
</script>
<%
	}
	}
%>
<script language="JavaScript">
	window.location.href = "teach_course.jsp";
</script>