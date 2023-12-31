<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-04
  Time: 오후 6:27
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

<form action="controller.jsp" method="post">
    <input type="hidden" name="command" value="wifiDistance">
    <td>
        LNT:<input type="text" name="X" id="Y" value="0.0">
    </td>
    <td>
        , LAT:<input type="text" name="Y" id ="X" value="0.0">
    </td>
    <td>
        <input id="btnStart" type="button" value="내 위치 가져오기">
    </td>
    <td>
        <input id="btn" type="submit" value="근처 WIFI 정보 가져오기">
    </td>
</form>
</body>

<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
<script>
    $(function() {
            //위치 정보를 버튼 누를때  얻기
            $('#btnStart').click(function() {
            var id = navigator.geolocation.watchPosition(
                function(position) {
                    $('#X').val(position.coords.longitude);
                    console.log(id);// 경도
                    $('#Y').val(position.coords.latitude);
                    console.log(id);// 위도
                });
            });
    });
</script>

<body>
<table>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
</table>
</body>
<body>

<div id="display">
    위치 정보를 입력한 후에 조회해 주세요.
</div>
</body>
</html>
