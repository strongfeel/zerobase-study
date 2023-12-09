<%@ page import="com.example.zerobasestudy.ApiExplorer" %>
<%@ page import="com.example.zerobasestudy.WifiInfo" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-04
  Time: 오후 5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    WifiInfo wifiInfo = new WifiInfo();
    int result = wifiInfo.TotalCnt();
    out.print(result + "개의 WIFI 정보를 정상적으로 저장하였습니다.");
%>
<br>
<a href="index.jsp" style="text-align: center">홈 으로 가기</a>
</body>
</html>