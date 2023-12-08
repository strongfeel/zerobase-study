<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-08
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8");%>

<%
    String X = request.getParameter("X");
    String Y = request.getParameter("Y");
    Timestamp H_DATE = new Timestamp(System.currentTimeMillis());

    Connection conn = null;
    PreparedStatement pstmt = null;
    String str = "";

    String jdbcUrl = "jdbc:mariadb://localhost:3306/testdb2";
    String dbId = "root";
    String dbPass = "0211";

    try {
        Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    try{
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

        String sql= " insert into history (X, Y, H_DATE) values (?,?,now()) ";

        pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,X);
        pstmt.setString(2,Y);
        pstmt.executeUpdate();

        response.sendRedirect("history.jsp");

        System.out.print(pstmt);

    }catch(Exception e){
        e.printStackTrace();
        str="실패했습니다";
    }finally{
        if(pstmt != null)
            try{pstmt.close();}catch(SQLException sqle){}
        if(conn != null)
            try{conn.close();}catch(SQLException sqle){}
    }
%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Insert title here</title>

</head>

<body>

</body>

</html>
