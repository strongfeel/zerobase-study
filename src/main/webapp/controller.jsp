        <%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.zerobasestudy.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String command = request.getParameter("command");

    HistoryDao dao = new HistoryDao();

    // 홈 버튼 누를떄
    if (command.equals("main")) {
        response.sendRedirect("index.jsp");



        // 히스토리 버튼 눌렀을떄
    } else if (command.equals("history")) {
        List<HistoryDto> list = dao.selectAll();
        request.setAttribute("historyList", list);

        response.sendRedirect("historyMain.jsp");
        // 히스토리 삭제
    } else if (command.equals("historyDelete")) {
        int H_ID = Integer.parseInt(request.getParameter("H_ID"));

        HistoryDao dao2 = new HistoryDao();
        int res2 = dao2.delete(H_ID);

        if (res2 > 0) {
%>
        <script type="text/javascript">
            alert("히스토리 삭제 성공");
            location.href = "controller.jsp?command=history";
        </script>
<%
        } else {
%>
        <script type="text/javascript">
            alert("히스토리 삭제 실패");
            location.href = "controller.jsp?command=history";
        </script>
<%
        }




        // 와이파이 데이터 불러 들이기
    } else if (command.equals("wifiSave")) {
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.AddWifi();
        response.sendRedirect("load-wifi.jsp");
        //와이파이 거리 업데이트, 히스토리 저장
    } else if (command.equals("wifiDistance")) {

        String X = request.getParameter("X");
        String Y = request.getParameter("Y");
        Timestamp H_DATE = new Timestamp(System.currentTimeMillis());

        HistoryDto dto = new HistoryDto();
        dto.setX(X);
        dto.setY(Y);
        dto.setH_DATE(H_DATE);

        dao.insert(dto);

        WifiDao wifiDao = new WifiDao();
        Distance distance = new Distance();

        Double getY = Double .valueOf(Y);
        Double getX = Double .valueOf(X);

        ArrayList<WifiDto> result = wifiDao.wifiList();
        for (WifiDto wifiDto1 : result) {
            String X_SWIFI_MGR_NO = wifiDto1.getX_SWIFI_MGR_NO();
            Double lat = Double.valueOf(wifiDto1.getLAT());
            Double lnt = Double.valueOf(wifiDto1.getLNT());

            Double WIFIDIST = distance.getDistance(getY, getX, lat, lnt);
            wifiDao.updateDist(X_SWIFI_MGR_NO, WIFIDIST);
        }
        response.sendRedirect("wifiData.jsp");
    //와이파이 정보 보여주기
    } else if (command.equals("selectOne")) {
        String X_SWIFI_MGR_NO = request.getParameter("X_SWIFI_MGR_NO");

        WifiDao wifiDao = new WifiDao();
        WifiDto wifiDto = wifiDao.selectOne(X_SWIFI_MGR_NO);

        request.setAttribute("wifiDto", wifiDto);

        response.sendRedirect("selectOne.jsp");




        // 북마크 보기
    } else if (command.equals("bookmark")) {


    // 북마크 그룹 관리
    } else if (command.equals("bookmark-group")) {
        BgDao bgDao = new BgDao();
        List<BgDto> list = bgDao.selectAll();
        request.setAttribute("bgList", list);

        response.sendRedirect("bookmarkGroupMain.jsp");
    //북마크 삭제
    } else if (command.equals("bgDelete")) {
        int BG_ID = Integer.parseInt(request.getParameter("BG_ID"));

        BgDao bgDao = new BgDao();
        int res2 = bgDao.delete(BG_ID);

        if (res2 > 0) {
%>
        <script type="text/javascript">
            alert("북마크 그룹 삭제 성공");
            location.href = "controller.jsp?command=bookmarkGroupMain";
        </script>
<%
        } else {
%>
        <script type="text/javascript">
            alert("북마크 그룹 삭제 실패");
            location.href = "controller.jsp?command=bookmarkGroupMain";
        </script>
<%
        }

        // 와이파이 데이터 불러 들이기
    } else if (command.equals("bgUpdate")) {


    // 북마크 그룹 추가페이지 요청
    } else if (command.equals("bgInsertPage")) {
        response.sendRedirect("bgInsert.jsp");
    // 북마크 그룹 추가하기
    } else if (command.equals("bgInset")) {
        String BG_NAME = request.getParameter("BG_NAME");
        String BG_PRI = request.getParameter("BG_PRI");

        BgDto bgDto = new BgDto();
        bgDto.setBG_NAME(BG_NAME);
        bgDto.setBG_PRI(BG_PRI);

        BgDao bgDao = new BgDao();
        bgDao.insert(bgDto);
    }
%>

</body>
</html>
