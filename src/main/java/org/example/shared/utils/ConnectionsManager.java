package org.example.shared.utils;

import java.sql.*;
import java.util.logging.*;

public class ConnectionsManager {
    private static String url = "jdbc:postgresql://127.0.0.1:5432/testovoe";

    private static String name = "konstantin";

    private static String password = "123456";

    public static Connection getConnecction() {
        try {
            return DriverManager.getConnection(url, name, password);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionsManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
