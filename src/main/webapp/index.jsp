<%--
  Created by IntelliJ IDEA.
  User: StrongFeel
  Date: 2023-12-04
  Time: 오후 6:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>와이파이 정보 구하기</h1>
<form action="historyPro.jsp" method="post">
    <a href="index.jsp">홈</a> | <input type="submit" value="위치 히스토리 목록"> | <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
    <table>
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
            <input id="wifiInfo" type="button" value="근처 WIFI 정보 가져오기">
        </td>
    </table>
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

</body>
</html>
