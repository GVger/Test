<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>

<jsp:include page="class.jsp"></jsp:include>
<%
	request.setCharacterEncoding("utf-8");
	Service service = new Service();
	for(int i = 1; i <= 8; i++) {
		for(int j = 0; j < 8; j++) {
			String id = request.getParameter((j+1)+""+"_"+i);
			String time = (j+1)+""+"_"+i;
			long no = new Date().getTime();
			String scheduleId = String.valueOf(no);
			
			if(id == null || id.equals("null") || id.equals("")) {
			} else {
				service.insertSchedule(scheduleId, id, time);
			}
		}
	}
%>

<script language="JavaScript">
	window.location.href = "index.jsp";
</script>