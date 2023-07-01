<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detail Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section class="container">
    Mã Nhân Viên : ${listNV.ma}
    <br>
    Mã Cửa Hàng : ${listNV.cuaHang.ma}
    <br>
    Mã Chức Vụ : ${listNV.chucVu.ma}
    <br>
    Họ Tên : ${listNV.ho} ${listNV.tenDem} ${listNV.ten}
    <br>
    Giới Tính : ${listNV.gioiTinh == 1 ? "Nam" : "Nữ"}
    <br>
    Ngày Sinh : ${listNV.ngaySinh}
    <br>
    Trạng Thái : ${listNV.trangThai}
</section>
</body>
</html>