package com.example.zerobasestudy.db;

import java.sql.*;

public class DbHistoryTest {

    public void dbSelect() {
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

    public void dbInsert() {
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

        String hIdValue = "";
        String xValue = "";
        String yValue = "";


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " insert into history (H_ID, X, Y, H_DATE) " +
                    " values (?, ?, ?, now()) ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hIdValue);
            preparedStatement.setString(2, xValue);
            preparedStatement.setString(3, yValue);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
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

    public void dbDelete() {
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

        String hIdValue = "";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " delete from history " +
                    " where H_ID = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hIdValue);

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
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
