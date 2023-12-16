package com.example.zerobasestudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BdDao {

    public int insert(BdDto bdDto) { //히스토리 데이터 추가
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

            String sql = " insert into bookmark_data (B_WIFINAME, B_NAME, B_IN_DATE) " +
                    " values (?, ?, now()) ";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bdDto.getB_WIFINAME());
            preparedStatement.setString(2, bdDto.getB_NAME());

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

    public List<BdDto> selectAll() {

        List<BdDto> BdDtoList = new ArrayList<>();

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

            String sql = " select B_ID, B_NAME, B_WIFINAME, B_IN_DATE " +
                    " from bookmark_data ";

            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, hIdValue); //SELECT

            rs = preparedStatement.executeQuery();

            while(rs.next()) {

                int B_ID = rs.getInt("B_ID");
                String B_NAME = rs.getString("B_NAME");
                String B_WIFINAME = rs.getString("B_WIFINAME");
                Timestamp B_IN_DATE = rs.getTimestamp("B_IN_DATE");

                BdDto bdDto = new BdDto();
                bdDto.setB_ID(B_ID);
                bdDto.setB_NAME(B_NAME);
                bdDto.setB_WIFINAME(B_WIFINAME);
                bdDto.setB_IN_DATE(B_IN_DATE);

                BdDtoList.add(bdDto);
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

        return BdDtoList;
    }

    public int delete(int bdDto) {
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

            String sql = " delete from bookmark_data " +
                    " where B_ID = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(bdDto));

            affected = preparedStatement.executeUpdate();

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
        return affected;
    }

    public BdDto selectOne(int B_ID) {
        String url = "jdbc:mariadb://localhost:3306/testdb2";
        String dbUserId = "root";
        String dbPassword = "0211";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        BdDto bdDto = new BdDto();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " SELECT * FROM bookmark_data WHERE B_ID=? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, B_ID);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                bdDto.setB_ID(rs.getInt(1));
                bdDto.setB_NAME(rs.getString(4));
                bdDto.setB_WIFINAME(rs.getString(2));
                bdDto.setB_IN_DATE(rs.getTimestamp(3));
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
        return bdDto;
    }
}
