package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        try {
            // Driver MySQL mới
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Sử dụng "mysql" (service name trong docker-compose.yml) thay cho localhost
            String url = "jdbc:mysql://mysql-db:3306/vehicle_db?useSSL=false&serverTimezone=UTC";
            return DriverManager.getConnection(url, "user", "pass"); // "user" và "pass" phải giống trong docker-compose.yml

        } catch (Exception e) {
            e.printStackTrace();
            return null;  // In ra lỗi chi tiết để debug
        }
    }
}
