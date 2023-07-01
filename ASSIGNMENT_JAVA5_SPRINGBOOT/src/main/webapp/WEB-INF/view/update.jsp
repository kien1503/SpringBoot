<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section class="container">
    <form action="/nhan-vien/update" method="post">
        <input type="hidden" name="id" value="${listNV.id}">
        Mã NV: <input type="text" name="maNV" value="${listNV.ma}">
        <br>
        Mã Cửa Hàng: <select class="form-select" name="maCH" value="${cuaHang}" >
        <c:forEach items="${listCH}" var="ch"><option value="${ch.id}" ${ch.id == listNV.cuaHang.id ? 'selected' : ''}>${ch.ma}</option>
        </c:forEach>
    </select>
        <br>
        Mã Chức Vụ: <select class="form-select" name="maCV" value="${chucVu}" >
        <c:forEach items="${listCV}" var="cv"><option value="${cv.id}" ${cv.id == listNV.chucVu.id ? 'selected' : ''}>${cv.ma}</option>
        </c:forEach>
    </select>
        <br>
        Tên:<input type="text" name="ten" value="${listNV.ten}">
        <br>
        Tên Đệm:<input type="text" name="tenDem" value="${listNV.tenDem}">
        <br>
        Họ:<input type="text" name="ho" value="${listNV.ho}">
        <br>
        Giới Tính:<input type="radio" name="gioiTinh" value="1" ${listNV.gioiTinh == 1 ? 'checked' : ''}> Nam
        <input type="radio" name="gioiTinh" value="0" ${listNV.gioiTinh == 0 ? 'checked' : ''}> Nữ
        <br>
        Ngày Sinh:<input type="date" name="ngaySinh" value="${ns}">
        <br>
        Trạng Thái:<input type="radio" value="1" name="trangThai" value="1" ${listNV.trangThai == 1 ? 'checked' : ''}> Đang Làm Việc
        <input type="radio" value="0" name="trangThai" value="0" ${listNV.trangThai == 0 ? 'checked' : ''}> Đã Nghỉ Làm Việc
        <br>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</section>
</body>
</html>