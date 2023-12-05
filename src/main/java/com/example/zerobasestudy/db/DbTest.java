package com.example.zerobasestudy.db;

import java.sql.*;

public class DbTest {
    public static void main(String[] args) {

        String url = "jdbc:mariadb://localhost:3306/testdb2";
        String dbUserId = "root";
        String dbPassword = "0211";


        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " select H_ID, X, Y, H_DATE " +
                    " form history ";

            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, hIdValue); //SELECT

            rs = preparedStatement.executeQuery();

            while(rs.next()) {

                String hId = rs.getString("H_ID");
                String x = rs.getString("X");
                String y = rs.getString("Y");
                String hDate = rs.getString("H_DATE");

                System.out.println(hId + ", " + x + ", " + y + ", " + hDate);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
