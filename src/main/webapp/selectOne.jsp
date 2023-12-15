<%@ page import="com.example.zerobasestudy.WifiDto" %>
<%@ page import="com.example.zerobasestudy.BgDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-13
  Time: 오후 7:36
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
<h1>와이파이 정보 구하기</h1>
<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a> | <a href="controller.jsp?command=bookmarkSelect">북마크 보기</a> | <a href="controller.jsp?command=bookmark-group">북마크 그룹 관리</a><br>
</body>
<body>
<% WifiDto wifiDto = (WifiDto)request.getAttribute("wifiDto"); %>
<% List<BgDto> bgDtoList = (List<BgDto>)request.getAttribute("bgDtoList"); %>
<form action="controller.jsp" method="get">
    <input type="hidden" name="command" value="bookmarkInsert">
    <input type="hidden" name="X_SWIFI_MAIN_NM" value="<%= wifiDto.getX_SWIFI_MAIN_NM()%>">
    <select name="BG_NAME">
        <option value="none">북마크 그룹 이름 선택</option>
        <%
            for (BgDto bgDto : bgDtoList) {
        %>
            <option value="<%= bgDto.getBG_NAME()%>"><%= bgDto.getBG_NAME()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="북마크 추가 하기">
<table>
    <tr>
        <th>거리(Km)</th>
        <td><%= wifiDto.getWIFIDIST()%></td>
    </tr>
    <tr>
        <th>관리번호</th>
        <td><%= wifiDto.getX_SWIFI_MGR_NO()%></td>
    </tr>
    <tr>
        <th>자치구</th>
        <td><%= wifiDto.getX_SWIFI_WRDOFC()%></td>
    </tr>
    <tr>
        <th>와이파이명</th>
        <td><%= wifiDto.getX_SWIFI_MAIN_NM()%></td>
    </tr>
    <tr>
        <th>도로명주소</th>
        <td><%= wifiDto.getX_SWIFI_ADRES1()%></td>
    </tr>
    <tr>
        <th>상세주소</th>
        <td><%= wifiDto.getX_SWIFI_ADRES2()%></td>
    </tr>
    <tr>
        <th>설치위치(층)</th>
        <td><%= wifiDto.getX_SWIFI_INSTL_FLOOR()%></td>
    </tr>
    <tr>
        <th>설치유형</th>
        <td><%= wifiDto.getX_SWIFI_INSTL_TY()%></td>
    </tr>
    <tr>
        <th>설치기관</th>
        <td><%= wifiDto.getX_SWIFI_INSTL_MBY()%></td>
    </tr>
    <tr>
        <th>서비스구분</th>
        <td><%= wifiDto.getX_SWIFI_SVC_SE()%></td>
    </tr>
    <tr>
        <th>망종류</th>
        <td><%= wifiDto.getX_SWIFI_CMCWR()%></td>
    </tr>
    <tr>
        <th>설치년도</th>
        <td><%= wifiDto.getX_SWIFI_CNSTC_YEAR()%></td>
    </tr>
    <tr>
        <th>실내외구분</th>
        <td><%= wifiDto.getX_SWIFI_INOUT_DOOR()%></td>
    </tr>
    <tr>
        <th>WIFI접속환경</th>
        <td><%= wifiDto.getX_SWIFI_REMARS3()%></td>
    </tr>
    <tr>
        <th>X좌표</th>
        <td><%= wifiDto.getLNT()%></td>
    </tr>
    <tr>
        <th>Y좌표</th>
        <td><%= wifiDto.getLAT()%></td>
    </tr>
    <tr>
        <th>작업일자</th>
        <td><%= wifiDto.getWORK_DTTM()%></td>
    </tr>
</table>
</form>
</body>
</html>
