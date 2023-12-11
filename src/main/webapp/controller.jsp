<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.zerobasestudy.*" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
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
    if (command.equals("main")){
        pageContext.forward("index.jsp");
    // 히스토리 버튼 눌렀을떄
    } else if (command.equals("history")){
        List<HistoryDto> list = dao.selectAll();
        request.setAttribute("historyList", list);
        
        pageContext.forward("historyMain.jsp");
    // 좌표 히스토리 추가
    } else if (command.equals("historyInsert")) {
        String X = request.getParameter("X");
        String Y = request.getParameter("Y");
        Timestamp H_DATE = new Timestamp(System.currentTimeMillis());

        HistoryDto dto = new HistoryDto();
        dto.setX(X);
        dto.setY(Y);
        dto.setH_DATE(H_DATE);

        int res = dao.insert(dto);

        if (res > 0) {
%>
<script type="text/javascript">
    location.href = "controller.jsp?command=main&LAT=<%= dto.getX()%>&LNT=<%= dto.getY()%>";
</script>
<%
        }
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
        pageContext.forward("load-wifi.jsp");
    }
%>

</body>
</html>
