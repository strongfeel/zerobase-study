<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-09
  Time: 오후 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.example.zerobasestudy.db.HistoryDto" %>
<%@ page import="com.example.zerobasestudy.db.HistoryDao" %>
<% request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String X = request.getParameter("X");
    String Y = request.getParameter("Y");
    Timestamp H_DATE = new Timestamp(System.currentTimeMillis());

    HistoryDto dto = new HistoryDto();
    dto.setX(X);
    dto.setY(Y);
    dto.setH_DATE(H_DATE);

    HistoryDao dao = new HistoryDao();
    int res = dao.insert(dto);
    response.sendRedirect("index.jsp");
%>

</body>
</html>
