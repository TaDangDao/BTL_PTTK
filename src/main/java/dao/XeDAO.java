// src/dao/XeDAO.java
package dao;
import model.ChuXe;
import model.Xe;
import util.DBUtil;
import java.sql.*;
import java.util.*;

public class XeDAO {
    private static XeDAO instance;
    private XeDAO(){ }
    public static XeDAO getInstance() {
        if (instance == null) instance = new XeDAO();
        return instance;
    }

    public List<Xe> timKiemXe(String bienSo) throws SQLException {
        String sql = "SELECT x.id, x.bienSo, x.ngayDangKy, x.tinhTrang,"
                + " c.ten, c.ngaySinh, c.diaChi"
                + " FROM xe x JOIN chuxe c ON x.chuXeId = c.id"
                + " WHERE x.bienSo LIKE ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + bienSo + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Xe> list = new ArrayList<>();
                while (rs.next()) {
                    ChuXe cz = new ChuXe();
                    cz.setTen(rs.getString("ten"));
                    cz.setNgaySinh(rs.getDate("ngaySinh"));
                    cz.setDiaChi(rs.getString("diaChi"));

                    Xe x = new Xe();
                    x.setId(rs.getInt("id"));
                    x.setBienSo(rs.getString("bienSo"));
                    x.setNgayDangKy(rs.getDate("ngayDangKy"));
                    x.setTinhTrang(rs.getString("tinhTrang"));
                    x.setChuXe(cz);
                    list.add(x);
                }
                return list;
            }
        }
    }

    public void capNhatXe(Xe x) throws SQLException {

        String sql = "UPDATE xe SET bienSo = ?, ngayDangKy = ?, tinhTrang = ?, chuXeId = "
                + "(SELECT id FROM chuxe WHERE ten = ?) WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, x.getBienSo());
            ps.setDate(2, new java.sql.Date(x.getNgayDangKy().getTime()));
            ps.setString(3, x.getTinhTrang());
            ps.setString(4, x.getChuXe().getTen());
            ps.setInt(5, x.getId());
            System.out.println("Cập nhật xe ID: " + x.getId());

            ps.executeUpdate();
        }
    }


}
