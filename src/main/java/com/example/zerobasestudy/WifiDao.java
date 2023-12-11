package com.example.zerobasestudy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.*;

public class WifiDao{
    public int wifiInsert(WifiDto wifiDto) throws IOException, ParseException { //히스토리 데이터 추가
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

            /*if(jsonArr.size()>0) {
                for (int i = 0; i < jsonArr.size(); i++) {
                    JSONObject jsonObj = (JSONObject) jsonArr.get(i);*/

                    /*String X_SWIFI_MGR_NO = (String) jsonObj.get("X_SWIFI_MGR_NO");
                    String X_SWIFI_WRDOFC = (String) jsonObj.get("X_SWIFI_WRDOFC");
                    String X_SWIFI_MAIN_NM = (String) jsonObj.get("X_SWIFI_MAIN_NM");
                    String X_SWIFI_ADRES1 = (String) jsonObj.get("X_SWIFI_ADRES1");
                    String X_SWIFI_ADRES2 = (String) jsonObj.get("X_SWIFI_ADRES2");
                    String X_SWIFI_INSTL_FLOOR = (String) jsonObj.get("X_SWIFI_INSTL_FLOOR");
                    String X_SWIFI_INSTL_TY = (String) jsonObj.get("X_SWIFI_INSTL_TY");
                    String X_SWIFI_INSTL_MBY = (String) jsonObj.get("X_SWIFI_INSTL_MBY");
                    String X_SWIFI_SVC_SE = (String) jsonObj.get("X_SWIFI_SVC_SE");
                    String X_SWIFI_CMCWR = (String) jsonObj.get("X_SWIFI_CMCWR");
                    String X_SWIFI_CNSTC_YEAR = (String) jsonObj.get("X_SWIFI_CNSTC_YEAR");
                    String X_SWIFI_INOUT_DOOR = (String) jsonObj.get("X_SWIFI_INOUT_DOOR");
                    String X_SWIFI_REMARS3 = (String) jsonObj.get("X_SWIFI_REMARS3");
                    String LAT = (String) jsonObj.get("LAT");
                    String LNT = (String) jsonObj.get("LNT");
                    String WORK_DTTM = (String) jsonObj.get("WORK_DTTM");*/


                    /*pstmt.setString(1, X_SWIFI_MGR_NO);
                    pstmt.setString(2, X_SWIFI_WRDOFC);
                    pstmt.setString(3, X_SWIFI_MAIN_NM);
                    pstmt.setString(4, X_SWIFI_ADRES1);
                    pstmt.setString(5, X_SWIFI_ADRES2);
                    pstmt.setString(6, X_SWIFI_INSTL_FLOOR);
                    pstmt.setString(7, X_SWIFI_INSTL_TY);
                    pstmt.setString(8, X_SWIFI_INSTL_MBY);
                    pstmt.setString(9, X_SWIFI_SVC_SE);
                    pstmt.setString(10, X_SWIFI_CMCWR);
                    pstmt.setString(11, X_SWIFI_CNSTC_YEAR);
                    pstmt.setString(12, X_SWIFI_INOUT_DOOR);
                    pstmt.setString(13, X_SWIFI_REMARS3);
                    pstmt.setString(14, LAT);
                    pstmt.setString(15, LNT);
                    pstmt.setString(16, WORK_DTTM);
                }
            }*/

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
        return affected;
    }
}
