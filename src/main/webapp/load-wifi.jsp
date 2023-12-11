<%@ page import="com.example.zerobasestudy.WifiInfo" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.example.zerobasestudy.WifiDto" %>
<%@ page import="org.json.simple.JSONObject" %><%--
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
<a href="index.jsp">홈 으로 가기</a>
</body>
</html>