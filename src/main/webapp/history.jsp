<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
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
<h1>위치 히스토리 목록</h1>
<a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</body>
<body>
    <%
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("mariadb 사용가능");

        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb2","root","0211");
        System.out.println(conn + "<-- conn");

        PreparedStatement stmt = conn.prepareStatement("select * from history");
        System.out.println(stmt + "<-- stmt");

        ResultSet rs = stmt.executeQuery();
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
        </tr>
        <%
            while(rs.next()){
        %>
        <tr>
            <td><%=rs.getString("H_ID") %></td>
            <td><%=rs.getString("X") %></td>
            <td><%=rs.getString("Y") %></td>
            <td><%=rs.getString("H_DATE") %></td>
            <td><button>삭제</button></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
