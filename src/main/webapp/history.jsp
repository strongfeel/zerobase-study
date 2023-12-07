
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
