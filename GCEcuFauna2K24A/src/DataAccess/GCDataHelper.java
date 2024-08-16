package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GCDataHelper {
    private static String GCConnection = "jdbc:sqlite:DataBase/GCEcuAFauna.sqlite";
    private static Connection conn = null;

    protected static synchronized Connection openConnection() throws Exception {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(GCConnection);
            }
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    protected static void closeConnection() throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(GCConnection);
    }

}