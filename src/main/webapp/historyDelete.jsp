<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-08
  Time: 오후 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8");%>

<%
    int H_ID = Integer.parseInt(request.getParameter("H_ID"));

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

        String sql = " delete from history " +
                " where H_ID = ? ";

        pstmt=conn.prepareStatement(sql);

        pstmt.setInt(1,H_ID);

        response.sendRedirect("index.jsp");

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
