// src/controller/LoginController.java
package controller;
import dao.StaffDAO;
import model.Staff;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private StaffDAO dao = new StaffDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("jsp/DangnhapFRM.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Staff s = new Staff();
        s.setUsername(req.getParameter("username"));
        s.setPass(req.getParameter("password"));
        try {
            if (dao.checkLogin(s)) {
                req.getSession().setAttribute("user", s);
                resp.sendRedirect("VehicleController");
            } else {
                req.setAttribute("error", "Sai username hoặc password");
                req.getRequestDispatcher("jsp/DangnhapFRM.jsp").forward(req, resp);
            }
        } catch (Exception e) { throw new ServletException(e); }
    }
}
