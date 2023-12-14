<%@ page import="com.example.zerobasestudy.BgDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-14
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
<h1>북마크 그룹 이름 추가</h1>
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmark">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
<td>
    <input type="button" value="북마크 그룹 이름 추가" onclick="location.href='controller.jsp?command=bgInsertPage'">
</td>
</body>
<body>
<%
    List<BgDto> bgDtoList = (List<BgDto>)request.getAttribute("bgDtoList");
%>
<form action="">
<table>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>순서</th>
        <th>등록일자</th>
        <th>수정일자</th>
        <th>비고</th>
    </tr>
    <%
        for (BgDto bgDto : bgDtoList) {
            /*for (int i = 0; i < list.size(); i++){*/
    %>
    <tr>
        <td><%=bgDto.getBG_ID() %></td>
        <td><%=bgDto.getBG_NAME()%></td>
        <td><%=bgDto.getBG_PRI()%></td>
        <td><%=bgDto.getBG_IN_DATE()%></td>
        <td><%=bgDto.getBG_UPDATE()%></td>
        <td><a href="controller.jsp?command=bgUpdate&BG_ID=<%= bgDto.getBG_ID()%>">수정</a> <a href="controller.jsp?command=bgDelete&BG_ID=<%= bgDto.getBG_ID()%>">삭제</a></td>
    </tr>
    <%
        }
    %>
</table>
</form>
</body>
</html>
