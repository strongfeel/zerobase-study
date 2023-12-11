package com.example.zerobasestudy;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.sql.*;

public class WifiDao{
    public void wifiInsert(WifiDto wifiDto) throws IOException, ParseException{ //히스토리 데이터 추가
        String url = "jdbc:mariadb://localhost:3306/testdb2";
        String dbUserId = "root";
        String dbPassword = "0211";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int affected = 0;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


            String sql = " insert into public_wifi_info (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) " +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, wifiDto.getX_SWIFI_MGR_NO());
            pstmt.setString(2, wifiDto.getX_SWIFI_WRDOFC());
            pstmt.setString(3, wifiDto.getX_SWIFI_MAIN_NM());
            pstmt.setString(4, wifiDto.getX_SWIFI_ADRES1());
            pstmt.setString(5, wifiDto.getX_SWIFI_ADRES2());
            pstmt.setString(6, wifiDto.getX_SWIFI_INSTL_FLOOR());
            pstmt.setString(7, wifiDto.getX_SWIFI_INSTL_TY());
            pstmt.setString(8, wifiDto.getX_SWIFI_INSTL_MBY());
            pstmt.setString(9, wifiDto.getX_SWIFI_SVC_SE());
            pstmt.setString(10, wifiDto.getX_SWIFI_CMCWR());
            pstmt.setString(11, wifiDto.getX_SWIFI_CNSTC_YEAR());
            pstmt.setString(12, wifiDto.getX_SWIFI_INOUT_DOOR());
            pstmt.setString(13, wifiDto.getX_SWIFI_REMARS3());
            pstmt.setString(14, wifiDto.getLAT());
            pstmt.setString(15, wifiDto.getLNT());
            pstmt.setString(16, wifiDto.getWORK_DTTM());

            affected = pstmt.executeUpdate();

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
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
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

    public int insertDist(WifiDto wifiDto) { //히스토리 데이터 추가
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
        int affected = 0;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " insert into public_wifi_info (Dist) " +
                    " values (?) ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(wifiDto.getDIST()));

            affected = preparedStatement.executeUpdate();

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
        return affected;
    }

    public int updateDist(WifiDto wifiDto) {
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
        int affected = 0;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " update history set DIST=?, " +
                    " where X_SWIFI_MGR_NO=? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(wifiDto.getDIST()));
            preparedStatement.setString(2, wifiDto.getX_SWIFI_MGR_NO());

            affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 업데이트 성공 ");
            } else {
                System.out.println(" 업데이트 실패 ");
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
        return affected;
    }
}
