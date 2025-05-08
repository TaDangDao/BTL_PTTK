// src/controller/VehicleController.java
package controller;
import dao.XeDAO;
import model.Xe;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Date;
public class VehicleController extends HttpServlet {
    private XeDAO dao = XeDAO.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session==null || session.getAttribute("user")==null) {
            resp.sendRedirect("LoginController"); return;
        }
        String action = req.getParameter("action");
        try {
            if ("search".equals(action)) {
                String kw = req.getParameter("bienSo")==null? "" : req.getParameter("bienSo");
                List<Xe> list = dao.timKiemXe(kw);
                req.setAttribute("dsXe", list);
                req.getRequestDispatcher("jsp/TimkiemxeFRM.jsp").forward(req, resp);

            } else if ("view".equals(action)) {
                // gọi detail
                Xe x = dao.timKiemXe(req.getParameter("bienSo")).get(0);
                req.getSession().setAttribute("currentXe", x);
                req.getRequestDispatcher("jsp/ThongtinxeFRM.jsp").forward(req, resp);

            } else if ("edit".equals(action)) {
                // xử lý cập nhật
                Xe x = (Xe) req.getSession().getAttribute("currentXe");
                x.setTinhTrang(req.getParameter("tinhTrang"));
                x.setBienSo(req.getParameter("bienSo"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date ngayDangKy = sdf.parse(req.getParameter("ngayDangKy"));
                    x.setNgayDangKy(ngayDangKy);
                } catch (ParseException e) {
                    // thông báo lỗi: định dạng ngày không hợp lệ
                    System.out.println("Ngày không đúng định dạng. Vui lòng nhập yyyy-MM-dd");
                }
                dao.capNhatXe(x);
                resp.sendRedirect("VehicleController?action=search&bienSo=" + x.getBienSo());

            }else if ("formEdit".equals(action)) {
                // Mở giao diện chỉnh sửa
                Xe x = dao.timKiemXe(req.getParameter("bienSo")).get(0);
                req.getSession().setAttribute("currentXe", x);
                req.getRequestDispatcher("jsp/ChinhsuaxeFRM.jsp").forward(req, resp);
            }
            else {
                // mặc định: trang menu chính
                req.getRequestDispatcher("jsp/QuanlychinhFRM.jsp").forward(req, resp);
            }
        } catch (Exception e) { throw new ServletException(e); }
    }
}
