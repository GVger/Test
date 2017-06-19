<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>

<jsp:include page="class.jsp"></jsp:include>
<%
	request.setCharacterEncoding("utf-8");
	String classNo = request.getParameter("classNo");
	String className = request.getParameter("className");
	if (classNo == null || classNo.equals("")) {
%>
<script type="text/javascript">
	alert("请输入班级编号");
</script>

<%
	} else if (className == null || className.equals("")) {
%>
<script type="text/javascript">
	alert("请输入班级名字");
</script>
<%
	} else {
		Service service = new Service();
		List<cn.vger.schedule.model.Class> classTemp = service.serachByClassNo(classNo);
		if (classTemp.size() == 0) {//表示没有这个数据，查看是否有相同的班级名字
			classTemp = service.serachByClassName(className);
			if (classTemp.size() == 0) {
				service.insertClass(classNo, className);
%>
<script type="text/javascript">
	alert("新建成功");
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("请认真核对信息，班级编号和班级名字不匹配");
</script>
<%
	}
		}
	}
%>
<script language="JavaScript">
	window.location.href = "class.jsp";
</script>