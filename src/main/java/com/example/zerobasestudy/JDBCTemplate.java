package com.example.zerobasestudy;

import java.sql.*;

public class JDBCTemplate {

    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mariadb://localhost:3306/testdb2";
        String id = "root";
        String pw = "0211";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, id, pw);

            con.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static boolean isConnection(Connection con) {
        boolean valid = true;

        try {
            if (con == null || con.isClosed()) {
                valid = false;
            }
        } catch (SQLException e) {
            valid = true;
            e.printStackTrace();
        }
        return valid;
    }

    public static void close(Connection con) {
        if (isConnection(con)) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection con) {
        if (isConnection(con)) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection con) {
        if (isConnection(con)) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
