<%@ page session="true"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html><body>
  <c:set var="x" value="${sessionScope.currentXe}" />
  <h3>Chi tiết ${x.bienSo}</h3>
  <form action="VehicleController" method="get">
    <input type="hidden" name="action" value="formEdit"/>
    Chu xe: <c:out value="${x.chuXe.ten}" default="Không rõ"/><br/>
    Ngay đăng ký: <c:out value="${x.ngayDangKy}"/><br/>
    Tình trạng: <c:out value="${x.tinhTrang}"/><br/>
    <form action="VehicleController" method="get" style="display:inline;">
      <input type="hidden" name="action" value="formEdit"/>
      <input type="hidden" name="bienSo" value="${x.bienSo}"/>
      <input type="submit" value="Cập nhật"/>
    </form>

  </form>
</body></html>
