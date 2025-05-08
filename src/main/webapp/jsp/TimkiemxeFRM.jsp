<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tra cứu xe</title>
</head>
<body>
  <form action="VehicleController" method="get">
    <input type="hidden" name="action" value="search"/>
    Biển số: <input name="bienSo" value="${param.bienSo}"/>
    <input type="submit" value="Tìm"/>
  </form>

  <c:if test="${not empty dsXe}">
    <table border="1">
      <tr><th>Biển số</th><th>Chủ xe</th><th>Ngày ĐK</th><th>Tình trạng</th><th>Hành động</th></tr>
      <c:forEach var="x" items="${dsXe}">
        <tr>
          <td>${x.bienSo}</td>
          <td>${x.chuXe.ten}</td>
          <td>${x.ngayDangKy}</td>
          <td>${x.tinhTrang}</td>
          <td>
            <a href="VehicleController?action=view&bienSo=${x.bienSo}">Xem</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</body>
</html>
