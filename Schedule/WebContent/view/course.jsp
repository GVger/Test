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
						<li><a href="course.jsp" class="selected"><span>课程信息</span></a>
						</li>
						<li><a href="class.jsp"><span>班级信息</span></a></li>
						<li><a href="teacher.jsp"><span>老师信息</span></a></li>
						<li><a href="teach_course.jsp"><span>任课信息</span></a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<div id="submenu">
					<div class="modules_left">
						<div class="module buttons">
							<a href="" class="dropdown_button"><small class="icon plus"></small><span>新建</span></a>
							<div class="dropdown">
								<div class="arrow"></div>
								<div class="content">
									<form id="courseForm" action="insertCourse.jsp" method="post">
										<p>
											<label for="courseNo">课程编号：</label> <input type="text"
												class="text w_22" name="courseNo" id="courseNo" value="" />
										</p>
										<p>
											<label for="courseName">课程名：</label> <input type="text"
												class="text w_22" name="courseName" id="courseName" value="" />
										</p>
									</form>
									<a href="#" class="button green right"
										onclick="document.getElementById('courseForm').submit();return false"><small
										class="icon check"></small><span>新建</span></a> <a
										class="button red mr right close"><small
										class="icon cross"></small><span>关闭</span></a>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="title">课程信息</div>
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
							<table>
								<tr>
									<th></th>
									<th>课程编号</th>
									<th>课程名字</th>
									<th>删除</th>
								</tr>
								<%
									Service service = new Service();
									int size = service.getCourseData().size();
									if (size == 0) {
								%>
								<tr id="id_1">
									<td class="checkbox"><input type="checkbox"
										name="checkbox" /></td>
									<td>空</td>
									<td>空</td>
									<td></td>
								</tr>
								<%
									} else {
										List<cn.vger.schedule.model.Course> courseData = service.getCourseData();
										for (int i = 0; i < size; i++) {
								%>

								<tr id="id_<%=i%>">
									<td class="checkbox"><input type="checkbox"
										name="checkbox" /></td>
									<td><%=courseData.get(i).getCourseNo()%></td>
									<td><%=courseData.get(i).getCourseName()%></td>
									<td><input type="button" value="删除" /></td>
								</tr>
								<%
									}
									}
								%><!--  
										<tr id="id_1">
											<td class="checkbox"><input type="checkbox" name="checkbox" /></td>
											<td>Lorem</td>
											<td>Ipsum</td>
											<td><input type="button" value="删除"/></td>
										</tr>
										-->
							</table>
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