<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-08
  Time: 오후 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.example.zerobasestudy.HistoryDao" %>
<% request.setCharacterEncoding("utf-8");%>

<%
    int H_ID = Integer.parseInt(request.getParameter("H_ID"));

    HistoryDao dao = new HistoryDao();
    int res = dao.delete(H_ID);

    if (res > 0) {
%>
    <script type="text/javascript">
        alert("히스토리 삭제 성공");
        location.href = "historyMain.jsp";
    </script>
<%
    } else {
%>
<script type="text/javascript">
    alert("히스토리 삭제 실패");
    location.href = "historyMain.jsp";
</script>
<%
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
