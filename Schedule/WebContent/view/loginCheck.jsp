<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>


<%
	Service service = new Service();
	List<cn.vger.schedule.model.UserInfo> userInfos = service.getUserInfo();
	String inUerName = request.getParameter("username");
	String inPsw = request.getParameter("password");

	if (userInfos.size() == 0) {
	} else {
		for (int i = 0; i < userInfos.size(); i++) {
			if (userInfos.get(i).getUser().equals(inUerName)) {
				if (userInfos.get(i).getPsw().equals(inPsw)) {
					//登录成功
%>
<script type="text/javascript">
	alert("登录成功");
	window.location.href = "index.jsp";
</script>

<%
	} else {
					//密码错误
%>
<script type="text/javascript">
	alert("密码错误");
	window.location.href = "login.jsp";
</script>

<%
	}
			} else {
				//没有用户名
%>
<script type="text/javascript">
	alert("不存在此用户名");
	window.location.href = "login.jsp";
</script>

<%
	}
		}
	}
%>