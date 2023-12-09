<%@ page import="com.example.zerobasestudy.HistoryDao" %>
<%@ page import="com.example.zerobasestudy.HistoryDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-09
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    th {
      text-align: center;
      background-color:MediumSeaGreen;
      color:white;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }

    button {
      margin:auto;
      display:block;
    }
  </style>
  <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>
<a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</body>
<%
  HistoryDao dao = new HistoryDao();
  List<HistoryDto> list = dao.selectAll();
%>
<body>
<table>
  <tr>
    <th>ID</th>
    <th>X좌표</th>
    <th>Y좌표</th>
    <th>조회일자</th>
    <th>비고</th>
  </tr>
  <%
    for (int i = 0; i < list.size(); i++){
  %>
  <tr>
    <td><%=list.get(i).getH_ID() %></td>
    <td><%=list.get(i).getX()%></td>
    <td><%=list.get(i).getY()%></td>
    <td><%=list.get(i).getH_DATE()%></td>
    <td><a href="historyDelete.jsp?H_ID=<%= list.get(i).getH_ID()%>">삭제</a> </td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
