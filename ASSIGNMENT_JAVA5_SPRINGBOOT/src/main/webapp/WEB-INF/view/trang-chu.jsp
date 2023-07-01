<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản Lý Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section class="container">
    <h2>Quản Lý Nhân Viên</h2>
    <form action="/nhan-vien/add" method="post">
        Mã NV: <input type="text" name="maNV">
        <br>
        Mã Cửa Hàng: <select class="form-select" name="maCH">
        <c:forEach items="${listCH}" var="ch"><option value="${ch.id}">${ch.ma}</option>
        </c:forEach>
    </select>
        <br>
        Mã Chức Vụ: <select class="form-select" name="maCV">
        <c:forEach items="${listCV}" var="cv"><option value="${cv.id}">${cv.ma}</option>
        </c:forEach>
    </select>
        <br>
        Tên:<input type="text" name="ten">
        <br>
        Tên Đệm:<input type="text" name="tenDem">
        <br>
        Họ:<input type="text" name="ho">
        <br>
        Giới Tính:<input type="radio" name="gioiTinh" value="1"> Nam
        <input type="radio" name="gioiTinh" value="0"> Nữ
        <br>
        Ngày Sinh:<input type="date" name="ngaySinh">
        <br>
        Trạng Thái:<input type="radio" value="1" name="trangThai"> Đang Làm Việc
        <input type="radio" value="0" name="trangThai"> Đã Nghỉ Làm Việc
        <br>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
    <br>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã Nhân viên</th>
            <th scope="col">Mã Cửa Hàng</th>
            <th scope="col">Mã Chức Vụ</th>
            <th scope="col">Họ Tên Nhân Viên</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNV.content}" var="nv" varStatus="viTri">
            <tr>
                <th scope="row">${viTri.index}</th>
                <td>${nv.ma}</td>
                <td>${nv.cuaHang.ma}</td>
                <td>${nv.chucVu.ma}</td>
                <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                <td>${nv.gioiTinh == 1 ? "Nam" : "Nữ"}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.trangThai == 1 ? "Đang Làm Việc" : "Đã Nghỉ Việc"}</td>
                <td>
                    <a href="/nhan-vien/detail/${nv.id}" class="btn btn-success">Detail</a>
                    <a href="/nhan-vien/remove/${nv.id}" class="btn btn-danger">Remove</a>
                    <a href="/nhan-vien/view-update/${nv.id}" class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <c:forEach begin="0" end="${listNV.totalPages-1}" var="page">
                <li class="page-item ${listNV.number == 1 ? "action" : ""}">
                    <a class="page-link" href="/nhan-vien/hien-thi?page=${page}">${page+1}</a></li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</section>
</body>
</html>