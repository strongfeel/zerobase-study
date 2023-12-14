package com.example.zerobasestudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BgDao {

    public List<BgDto> selectAll() {

        List<BgDto> BgDtoList = new ArrayList<>();

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

            String sql = " select BG_ID, BG_NAME, BG_PRI, BG_IN_DATE, BG_UPDATE " +
                    " from bookmark_group ";

            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, hIdValue); //SELECT

            rs = preparedStatement.executeQuery();

            while(rs.next()) {

                String BG_ID = rs.getString("BG_ID");
                String BG_NAME = rs.getString("BG_NAME");
                String BG_PRI = rs.getString("BG_PRI");
                String BG_IN_DATE = rs.getString("BG_IN_DATE");
                String BG_UPDATE = rs.getString("BG_UPDATE");

                BgDto bgDto = new BgDto();
                bgDto.setBG_ID(Integer.parseInt(BG_ID));
                bgDto.setBG_NAME(BG_NAME);
                bgDto.setBG_PRI(BG_PRI);
                bgDto.setBG_IN_DATE(Timestamp.valueOf(BG_IN_DATE));
                bgDto.setBG_UPDATE(Timestamp.valueOf(BG_UPDATE));

                BgDtoList.add(bgDto);

                System.out.println(BG_ID + ", " + BG_NAME + ", " + BG_PRI + ", " + BG_IN_DATE + ", " + BG_UPDATE);
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

        return BgDtoList;
    }

    public int insert(BgDto bgDto) { //히스토리 데이터 추가
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

            String sql = " insert into bookmark_group (BG_NAME, BG_PRI, BG_IN_DATE) " +
                    " values (?, ?, now()) ";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, bgDto.getBG_NAME());
            preparedStatement.setString(2, bgDto.getBG_PRI());

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

    public int delete(int bgDto) {
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

            String sql = " delete from bookmark_group " +
                    " where BG_ID = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(bgDto));

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

    public int update(String BG_NAME, String BG_PRI) {
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

            String sql = " UPDATE bookmark_group SET BG_PRI = ? WHERE BG_NAME = ? ";


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, BG_PRI);
            preparedStatement.setString(2, BG_NAME);

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
