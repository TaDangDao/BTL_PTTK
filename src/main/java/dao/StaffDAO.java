package dao;
// src/dao/StaffDAO.java
import model.Staff;
import util.DBUtil;
import java.sql.*;

public class StaffDAO {
    public boolean checkLogin(Staff s) throws SQLException {
        String sql = "SELECT * FROM staff WHERE username=? AND pass=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getPass());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}

