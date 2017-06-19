<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="cn.vger.schedule.service.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>课程管理系统</title>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/menu.js" type="text/javascript" charset="utf-8"></script>
<script src="js/global.js" type="text/javascript" charset="utf-8"></script>
<script src="js/modal.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" charset="utf-8" />
<!--[if IE 6]>
			<link rel="stylesheet" href="css/ie6.css" type="text/css" media="screen" charset="utf-8" />
		<![endif]-->
</head>
<body>
	<div id="header">
		<div class="col w5 bottomlast">
			<a href="" class="logo"> <img src="images/logo.jpg" alt="Logo" />
			</a>
		</div>
		<div class="col w5 last right bottomlast">
			<p class="last">
				<span class="strong"></span> <a href=""></a>
			</p>
		</div>
		<div class="clear"></div>
	</div>
	<div id="wrapper">
		<div id="minwidth">
			<div id="holder">
				<div id="menu">
					<div id="left"></div>
					<div id="right"></div>
					<ul>
						<li><a href="index.jsp"><span>主页</span></a></li>
						<li><a href="course.jsp"><span>课程信息</span></a></li>
						<li><a href="class.jsp"><span>班级信息</span></a></li>
						<li><a href="teacher.jsp"><span>老师信息</span></a></li>
						<li><a href="teach_course.jsp" class="selected"><span>任课信息</span></a>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div id="submenu">
					<div class="title">任课信息</div>
					<div class="modules_right">
						<div class="module search">
							<form action="">
								<p>
									<input type="text" value="Search..." name="user_search" />
								</p>
							</form>
						</div>
					</div>
				</div>
				<div id="table" class="help">
					<h1></h1>
					<div class="col w10 last">
						<div class="content">
							<table id="teach_course_table">
								<tr>
									<th></th>
									<th>任课编号</th>
									<th>课程名</th>
									<th>老师名</th>
									<th>班级名</th>
									<th>上课学期</th>
									<th>按钮</th>
								</tr>
								<%
									Service service = new Service();
									int size = service.getTeachCourseData().size();
									if (size == 0) {
								%>
								<tr id="id_1">
									<td class="checkbox"><input type="checkbox"
										name="checkbox" /></td>
									<td>空</td>
									<td>空</td>
									<td>空</td>
									<td>空</td>
									<td>空</td>
									<td></td>
								</tr>
								<%
									} else {
										List<cn.vger.schedule.model.TeachCourse> teachCourseData = service.getTeachCourseData();
										for (int i = 0; i < size; i++) {
								%>

								<tr id="id_<%=i%>">
									<td class="checkbox"><input type="checkbox"
										name="checkbox" /></td>
									<td><%=teachCourseData.get(i).getTeachCourseId()%></td>
									<td><%=teachCourseData.get(i).getCourseName()%></td>
									<td><%=teachCourseData.get(i).getTeacherName()%></td>
									<td><%=teachCourseData.get(i).getClassName()%></td>
									<td><%=teachCourseData.get(i).getTerm()%></td>
									<td><input type="button" value="删除" /></td>
								</tr>
								<%
									}
									}
								%>
								<!--  
								<tr id="id_1">
									<td class="checkbox"><input type="checkbox"
										name="checkbox" /></td>
									<td>Lorem</td>
									<td>Ipsum</td>
									<td><input type="button" value="删除" /></td>
								</tr>
								-->
							</table>
							<a href="#" class="button green right" onclick="addTr()"><small
								class="icon check"></small><span>新建</span></a>
							<script type="text/javascript">
								function addTr(){
									<%
										request.setCharacterEncoding("utf-8");
										String trStart = "<tr><td class='checkbox'><input type='checkbox' name='checkbox' /></td>";
										String td1 = "<td><input type='text' name='teach_course_id'/></td>";
										String td2 = "";
										String td3 = "";
										String td4 = "";
										String td5 = "";
										String td6 = "<td><input type='button' value='确定' onclick='insertTeachCourse()'/></td>";
										String trEnd = "</tr>";
										String str = "";
										
										//获取所有的课程名
										List<String> courseNames = service.getCourseName();
										if(courseNames.size() == 0) {
											td2 = "<td><select name='courseName'><option value='null'>空</option></select></td>";
										} else {
											td2 = "<td><select name='courseName'>";
											for(int i = 0; i < courseNames.size(); i++) {
												td2 += "<option value='"+ courseNames.get(i)+"'>"+ courseNames.get(i)+"</option>";
											}
											td2 += "</select></td>";
										}
										//根据课程名获取任课老师
										List<String> teacherNames = service.getTeachers();
										if(teacherNames.size() == 0) {
											td3 = "<td><select name='teacherName'><option value='null'>空</option></select></td>";
										} else {
											td3 = "<td><select name='teacherName'>";
											for(int i = 0; i < courseNames.size(); i++) {
												td3 += "<option value='"+ teacherNames.get(i)+"'>"+ teacherNames.get(i)+"</option>";
											}
											td3 += "</select></td>";
										}
										
										//获取班级名
										List<String> classNames = service.getClassNames();
										if(classNames.size() == 0) {
											td4 = "<td><select name='className'><option value='null'>空</option></select></td>";
										} else {
											td4 = "<td><select name='className'>";
											for(int i = 0; i < classNames.size(); i++) {
												td4 += "<option value='"+ classNames.get(i)+"'>"+ classNames.get(i)+"</option>";
											}
											td4 += "</select></td>";
										}
										
										//获取上课学期
										td5 = "<td><select name='term'><option value='第一学期'>第一学期</option>"
										+"<option value='第二学期'>第二学期</option>"
										+"<option value='第三学期'>第三学期</option>"
										+"<option value='第四学期'>第四学期</option>"
										+"<option value='第五学期'>第五学期</option>"
										+"<option value='第六学期'>第六学期</option>"
										+"<option value='第七学期'>第七学期</option>"
										+"<option value='第八学期'>第八学期</option></select></td>";
										str = trStart+td1+td2+td3+td4+td5+td6+trEnd;
									%>
									var str = "<%=str%>";
									$("#teach_course_table").append(str);
								};
								function insertTeachCourse() {
									var p1 = $("input[name='teach_course_id']").val();
									var p2 = $("select[name='courseName']").val();
									var p3 = $("select[name='teacherName']").val();
									var p4 = $("select[name='className']").val();
									var p5 = $("select[name='term']").val();
									var str = "insertTeachCourse.jsp?teach_course_id="+p1+"&courseName="+p2+"&teacherName="+p3+"&className="+p4+"&term="+p5;
								    str = encodeURI(str);
								    str = encodeURI(str);
									window.location=str;
								};
							</script>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<p class="last">
			Copyright 2009 - Gray Admin 模版 - Created by <a href="">Passatgt</a>
		</p>
		<p class="last">Copyright 2016 - 排课管理系统 - Created by Vger</p>
	</div>
</body>
</html>