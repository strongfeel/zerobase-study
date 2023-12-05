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
    <a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</body>
<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
<script>
    $(function() {
        // Geolocation API에 액세스할 수 있는지를 확인
        if (navigator.geolocation) {
            //위치 정보를 정기적으로 얻기
            var id = navigator.geolocation.watchPosition(
                function(pos) {
                    $('#latitude').html(pos.coords.latitude);     // 위도
                    $('#longitude').html(pos.coords.longitude); // 경도
                });

            // 버튼 클릭으로 감시를 중지
            $('#btnStop').click(function() {
                navigator.geolocation.clearWatch(id);
            });
        } else {
            alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
        }

    });
</script>
</head>
<body>
<ul>
    <li>LAT:<span id="latitude"></span></li><li>, LNT:<span id="longitude"></span></li>
</ul>
<input id="btnStop" type="button" value="감시를 끝낸다" />
</body>
</html>
