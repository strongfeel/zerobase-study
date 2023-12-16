<%@ page import="com.example.zerobasestudy.BdDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-16
  Time: 오후 12:36
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
<h1>북마크 목록</h1>
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmarkSelect">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
</body>
<body>
<%
    List<BdDto> list = (List<BdDto>) request.getAttribute("bookmarkList");
%>
</body>
<form action="">
    <table>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>와이파이명</th>
            <th>등록일자</th>
            <th>비고</th>
        </tr>
        <%
            for (BdDto bdDto : list) {
                /*for (int i = 0; i < list.size(); i++){*/
        %>
        <tr>
            <td><%=bdDto.getB_ID()%></td>
            <td><%=bdDto.getB_NAME()%></td>
            <td><%=bdDto.getB_WIFINAME()%></td>
            <td><%=bdDto.getB_IN_DATE()%></td>
            <td><a href="controller.jsp?command=bookmarkDeletePage&B_ID=<%= bdDto.getB_ID()%>">삭제</a></td>
        </tr>
        <%
            }
        %>
    </table>
</form>
</html>
