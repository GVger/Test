<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>

<jsp:include page="teacher.jsp"></jsp:include>
<%
	request.setCharacterEncoding("utf-8");
	String teacherNo = request.getParameter("teacherNo");
	String teacherName = request.getParameter("teacherName");
	String teachCourseName = request.getParameter("teachCourseName");

	if (teacherNo == null || teacherNo.equals("")) {
%>
<script type="text/javascript">
	alert("请输入老师编号");
</script>
<%
	} else if (teacherName == null || teacherName.equals("")) {
%>
<script type="text/javascript">
	alert("请输入老师名字");
</script>
<%
	} else if (teachCourseName == null || teachCourseName.equals("")) {
%>
<script type="text/javascript">
	alert("请输入任教科目");
</script>
<%
	} else {
		Service service = new Service();
		List<cn.vger.schedule.model.Teacher> teacherTemp = service.serachByTeacherNo(teacherNo);
		if (teacherTemp.size() == 0) {//表示没有这个数据，查看是否有相同的班级名字
			teacherTemp = service.serachByTeacherName(teacherName);
			if (teacherTemp.size() == 0) {
				service.insertTeacher(teacherNo, teacherName, teachCourseName);
%>
<script type="text/javascript">
	alert("新建成功");
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("请认真核对信息，老师编号和老师名字不匹配");
</script>
<%
	}
		}
	}
%>
<script language="JavaScript">
	window.location.href = "teacher.jsp";
</script>