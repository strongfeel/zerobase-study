<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-14
  Time: 오후 4:40
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
<h1>북마크 그룹 추가</h1>
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmarkSelect">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
</body>
<form action="controller.jsp" method="get">
  <input type="hidden" name="command" value="bgInsert">
  <table>
    <tr>
      <th>북마크 이름</th>
      <td><input type="text" name="BG_NAME"></td>
    </tr>
    <tr>
      <th>순서</th>
      <td><input type="text" name="BG_PRI"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="추가">
      </td>
    </tr>
  </table>
</form>
</html>
