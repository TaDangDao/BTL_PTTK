<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Xe" %>
<%
    Xe xe = (Xe) session.getAttribute("currentXe");
%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Chỉnh sửa xe</title>
</head>
<body>
    <h2>Chỉnh sửa thông tin xe</h2>
    <form action="VehicleController" method="get">
        <input type="hidden" name="action" value="edit" />
        <p>
           Biển số:
           <input type="text" name="bienSo" value="<%= xe.getBienSo() %>" required />
        </p>
        <p>
           Chủ xe: <%= xe.getChuXe().getTen()%>
        </p>
        <p>
           Ngày đăng ký:
           <input type="text" name="ngayDangKy" value="<%= xe.getNgayDangKy() %>" required />
        </p>
        <p>
            Tình trạng:
            <input type="text" name="tinhTrang" value="<%= xe.getTinhTrang() %>" required />
        </p>
        <input type="submit" value="Xác nhận" />
    </form>
</body>
</html>
