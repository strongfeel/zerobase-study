
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>
<a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>

<%
    //사용자의 정보가 저장 되어 있는 객체
    String X = request.getParameter("X");
    String Y = request.getParameter("Y");
%>
    <h2>
    당신의 LAT는 <%= X %> 이고 LNT는 <%= Y %> 입니다.
    </h2>

</body>
</html>
