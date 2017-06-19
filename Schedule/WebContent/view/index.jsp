<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.vger.schedule.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>排课管理系统</title>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" charset="utf-8" />
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/global.js" type="text/javascript" charset="utf-8"></script>
<script src="js/modal.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div id="header">
		<div class="col w5 bottomlast">
			<a href="" class="logo"> <img src="images/logo.jpg" alt="Logo" />
			</a>
		</div>
		<div class="col w5 last right bottomlast">
			<p class="last">
				<span class="strong"></span>
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
						<li><a href="index.jsp" class="selected"><span>主页</span></a>
						</li>
						<li><a href="course.jsp"><span>课程信息</span></a></li>
						<li><a href="class.jsp"><span>班级信息</span></a></li>
						<li><a href="teacher.jsp"><span>老师信息</span></a></li>
						<li><a href="teach_course.jsp"><span>任课信息</span></a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<div id="submenu">
					<div class="modules_left">
						<div class="module buttons">
							<a href="" class="dropdown_button"><small
								class="icon clipboard"></small><span>导航</span></a>
							<div class="dropdown help_index">
								<div class="arrow"></div>
								<div class="content">
									<div class="col w5">
										<!--菜单栏上的内容-->
										<a href="#schedule"> 排课 <span>跳到排课</span>
										</a>
										<hr />
										<a href="#show"> 显示 <span>显示排课</span>
										</a>
										<hr />
									</div>
									<div class="clear"></div>
									<a class="button red right close"><small class="icon cross"></small><span>关闭</span></a>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="title">主页</div>
					<div class="modules_right"></div>
				</div>
				<!--内容填写在这里-->
				<div id="schedule" class="help">
					<h1 align="center">排课</h1>
					<form action="" method="post">
						<p align="center">
							<lable>班级：</lable>
							<select name="className">
								<%
									request.setCharacterEncoding("utf-8");
									Service service = new Service();
									List<String> classNames = service.getClassNames();
									if (classNames.size() == 0) {
								%>
								<option value='null'>空</option>
								<%
									} else {
										for (int i = 0; i < classNames.size(); i++) {
								%>
								<option value='<%=classNames.get(i)%>'><%=classNames.get(i)%></option>;
								<%
									}
									}
								%>
							</select>
							<lable>学期：</lable>
							<select name="term">
								<option value='第一学期'>第一学期</option>
								<option value='第二学期'>第二学期</option>
								<option value='第三学期'>第三学期</option>
								<option value='第四学期'>第四学期</option>
								<option value='第五学期'>第五学期</option>
								<option value='第六学期'>第六学期</option>
								<option value='第七学期'>第七学期</option>
								<option value='第八学期'>第八学期</option>
							</select> <input type="submit" value="检索" />
						</p>
					</form>
					<%
						String className = request.getParameter("className");
						String term = request.getParameter("term");

						List<cn.vger.schedule.model.CourseAndTeacher> baseDatas = service.getBaseSchedule(className, term);
						//TODO
										
					%>
					<form action="insertSchedule.jsp" method="post">
						<table>
							<tr>
								<th></th>
								<th>星期一</th>
								<th>星期二</th>
								<th>星期三</th>
								<th>星期四</th>
								<th>星期五</th>
								<th>星期六</th>
								<th>星期日</th>
							</tr>
							<tr>
								<th>第一节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_1'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第二节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_2'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第三节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_3'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第四节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_4'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第五节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_5'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第六节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_6'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第七节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_7'>
										<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<th>第八节</th>
								<%
									for (int i = 0; i < 7; i++) {
								%>
								<td><select name='<%=i+1%>_8'>
								<option value='null'>空</option>
										<%
											for (int j = 0; j < baseDatas.size(); j++) {
										%>
										<option
											value='<%=baseDatas.get(j).getId()%>'><%=baseDatas.get(j).getCourseName() + baseDatas.get(j).getTeacherName()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
						</table>
						<p align="center">
							<input type="submit" value="提交" />
						</p>
					</form>
				</div>
				<div id="show" class="help">
					<h1 align="center">显示</h1>
					<form action="#" method="post">
						<p align="center">
							<lable>班级：</lable>
							<select name="showClassName">
								<%
									if (classNames.size() == 0)

									{
								%>
								<option value='null'>空</option>
								<%
									} else {
										for (int i = 0; i < classNames.size(); i++) {
								%>
								<option value='<%=classNames.get(i)%>'><%=classNames.get(i)%></option>;
								<%
									}
									}
								%>
							</select>
							<lable>学期：</lable>
							<select name="showTerm">
								<option value='第一学期'>第一学期</option>
								<option value='第二学期'>第二学期</option>
								<option value='第三学期'>第三学期</option>
								<option value='第四学期'>第四学期</option>
								<option value='第五学期'>第五学期</option>
								<option value='第六学期'>第六学期</option>
								<option value='第七学期'>第七学期</option>
								<option value='第八学期'>第八学期</option>
							</select> <input type="submit" value="检索" />
						</p>
					</form>
					<%
						String showClassName = request.getParameter("showClassName");
						String showTerm = request.getParameter("showTerm");
						
						List<cn.vger.schedule.model.ShowSchedule> scData = service.getScheduleByClassAndTerm(showClassName, showTerm);
					%>
					<table>
						<tr>
							<th></th>
							<th>星期一</th>
							<th>星期二</th>
							<th>星期三</th>
							<th>星期四</th>
							<th>星期五</th>
							<th>星期六</th>
							<th>星期日</th>
						</tr>
						<%
							String[][] show = new String[8][9];
							for(int i = 1; i <= 8; i++) {
								for(int j = 0; j < 8; j++) {
									show[j][i] = "<td></td>";
								}
							}
							
							for(int i = 1; i <= 8; i++) {
								show[0][i] = "<tr><th>第"+i+"节</th>";
							}
							
							for(int a = 0; a < scData.size(); a++) {
								show[service.getX(scData.get(a))][service.getY(scData.get(a))] = "<td>"+scData.get(a).getShowSchedule()+"</td>";
								if(service.getX(scData.get(a))==7) {
									show[service.getX(scData.get(a))][service.getY(scData.get(a))] += "</tr>";
								}
							}
							
							for(int i = 1; i <= 8; i++) {
								for(int j = 0; j < 8; j++) {%>
									<%=show[j][i]%>
								<%}
							}
						%>
					</table>
				</div>
				<div id="body_footer">
					<div id="bottom_left">
						<div id="bottom_right"></div>
					</div>
				</div>
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