<%@page import="common.JDBCConnectBoard"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JDBCConnect jc = new JDBCConnect();
	Connection con =jc.getConnection();
	jc.writeMemberToTable(con, out);
	%>
	
	<%
	String driver = application.getInitParameter("mysqlDriver");
	String url = application.getInitParameter("mysqlUrl");
	String id = application.getInitParameter("mysqlId");
	String pwd = application.getInitParameter("mysqlPwd");
	JDBCConnectBoard jcb = new JDBCConnectBoard(driver, url, id, pwd);
	Connection con1 = jcb.getConnection();
	jcb.writeBoardToTable(con1, out);
	
	%>
	

</body>
</html>