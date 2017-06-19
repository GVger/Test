<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>

<jsp:include page="course.jsp"></jsp:include>
<%
	request.setCharacterEncoding("utf-8");
	String courseNo = request.getParameter("courseNo");
	String courseName = request.getParameter("courseName");
	if (courseNo == null || courseNo.equals("")) {
%>
<script type="text/javascript">
	alert("请输入课程编号");
</script>

<%
	} else if (courseName == null || courseName.equals("")) {
%>
<script type="text/javascript">
	alert("请输入课程名字");
</script>
<%
	} else {
		Service service = new Service();
		List<cn.vger.schedule.model.Course> courseTemp = service.serachByCourseNo(courseNo);
		if (courseTemp.size() == 0) {//表示没有这个数据，查看是否有相同的班级名字
			courseTemp = service.serachByCourseName(courseName);
			if (courseTemp.size() == 0) {
				service.insertCourse(courseNo, courseName);
%>
<script type="text/javascript">
	alert("新建成功");
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("请认真核对信息，课程编号和课程名字不匹配");
</script>
<%
	}
		}
	}
%>
<script language="JavaScript">
	window.location.href = "course.jsp";
</script>