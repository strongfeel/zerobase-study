<%@ page import="com.example.zerobasestudy.WifiDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.zerobasestudy.WifiDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-13
  Time: 오후 6:40
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
<h1>와이파이 정보 구하기</h1>


<a href="controller.jsp?command=main">홈</a> | <a href="controller.jsp?command=history">위치 히스토리 목록</a> | <a href="controller.jsp?command=wifiSave">Open API 와이파이 정보 가져오기</a><br>

<form action="controller.jsp" method="post">
    <input type="hidden" name="command" value="wifiDistance">
    <td>
        LAT:<input type="text" name="X" id="X" value="0.0">
    </td>
    <td>
        , LNT:<input type="text" name="Y" id ="Y" value="0.0">
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
                    $('#X').val(position.coords.latitude);
                    console.log(id);// 위도
                    $('#Y').val(position.coords.longitude);
                    console.log(id);// 경도
                });
        });
    });
</script>

<body>
    <jsp:useBean id="dao" class="com.example.zerobasestudy.WifiDao"/>
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
    <%
        for (int i = 0; i < 20 && i < dao.wifiAllList().size(); i++){
    %>
        <tr>
            <td><%=dao.wifiAllList().get(i).getWIFIDIST() %></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_MGR_NO()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_WRDOFC()%></td>
            <td><a href=""><%=dao.wifiAllList().get(i).getX_SWIFI_MAIN_NM()%></a></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_ADRES1()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_ADRES2()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_INSTL_FLOOR()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_INSTL_TY()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_INSTL_MBY()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_SVC_SE()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_CMCWR()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_CNSTC_YEAR()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_INOUT_DOOR()%></td>
            <td><%=dao.wifiAllList().get(i).getX_SWIFI_REMARS3()%></td>
            <td><%=dao.wifiAllList().get(i).getLAT()%></td>
            <td><%=dao.wifiAllList().get(i).getLNT()%></td>
            <td><%=dao.wifiAllList().get(i).getWORK_DTTM()%></td>
        </tr>
<%
    }
%>

</table>
</body>
<body>
</body>
</html>
