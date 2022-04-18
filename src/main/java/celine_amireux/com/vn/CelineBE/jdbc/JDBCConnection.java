package celine_amireux.com.vn.CelineBE.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost/celinedatabase";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("thanh cong");


        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }
}