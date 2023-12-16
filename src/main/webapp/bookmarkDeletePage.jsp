<%@ page import="com.example.zerobasestudy.BdDto" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-16
  Time: 오후 12:53
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
<%
    BdDto bdDto = (BdDto)request.getAttribute("bdDto");
%>

<h1>북마크 삭제</h1>
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmarkSelect">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
북마크를 삭제 하시겠습니까?
<form action="controller.jsp" method="get">
    <input type="hidden" name="B_ID" value="<%= bdDto.getB_ID()%>">
    <input type="hidden" name="command" value="bookmarkDelete">
    <table>
        <tr>
            <th>북마크 이름</th>
            <td><%= bdDto.getB_NAME()%></td>
        </tr>
        <tr>
            <th>와이파이명</th>
            <td><%= bdDto.getB_WIFINAME()%></td>
        </tr>
        <tr>
            <th>등록일자</th>
            <td><%= bdDto.getB_IN_DATE()%></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="삭제">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
