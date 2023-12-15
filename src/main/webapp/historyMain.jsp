<%@ page import="com.example.zerobasestudy.HistoryDao" %>
<%@ page import="com.example.zerobasestudy.HistoryDto" %>
<%@ page import="java.util.List" %>
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
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmarkSelect">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
</body>
<body>
<%
  List<HistoryDto> list = (List<HistoryDto>)request.getAttribute("historyList");
%>
<form action="">
<table>
  <tr>
    <th>ID</th>
    <th>X좌표</th>
    <th>Y좌표</th>
    <th>조회일자</th>
    <th>비고</th>
  </tr>
  <%
    for (HistoryDto historyDto : list) {
    /*for (int i = 0; i < list.size(); i++){*/
  %>
  <tr>
    <td><%=historyDto.getH_ID() %></td>
    <td><%=historyDto.getX()%></td>
    <td><%=historyDto.getY()%></td>
    <td><%=historyDto.getH_DATE()%></td>
    <td><a href="controller.jsp?command=historyDelete&H_ID=<%= historyDto.getH_ID()%>">삭제</a></td>
  </tr>
  <%
    }
  %>
</table>
</form>
</body>
</html>
