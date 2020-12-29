<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${message }</strong>
		</div>
	</c:if>
</div>
<div class="container">
	<div
		style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
		<table class="table table-striped css-serial" style="margin-bottom: 0">
			<thead>
				<tr>
					<th></th>
					<th style="min-width: 100px;">Full Name</th>
					<th style="min-width: 130px;">Phone number</th>
					<th style="min-width: 150px;">Time set</th>
					<th style="min-width: 100px;">Room number</th>
					<th style="min-width: 150px;">More information</th>
					<th style="min-width: 120px;">Staff</th>
					<th style="min-width: 100px;">Manipulation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${danhsach}">
					<tr>
						<td></td>
						<td style="white-space: nowrap;">${u.tenNguoiDat}</td>
						<td style="white-space: nowrap;">${u.soDienThoai}</td>
						<td style="white-space: nowrap;"><fmt:formatDate
								pattern="HH:mm" value="${u.gioDat }" /> - <fmt:formatDate
								pattern="yyyy-MM-dd" value="${u.ngayDat }" /></td>
						<td style="white-space: nowrap;">${u.phong.soPhong}</td>
						<td style="white-space: nowrap;">${u.thongTinThem}</td>
						<td style="white-space: nowrap;">${u.tenDangNhap}</td>
						<td style="white-space: nowrap;"><button type="button"
								class="btn btn-primary btn-sm"
								onclick="xoaLich(${u.phong.maPhong},${u.maLich})">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script>
function xoaLich(maPhong, maLich) {
	if (confirm("You want to delete?")) 
    {
	window.location="/actionxoalichds?maLich=" + maLich + "&maPhong=" + maPhong;
    }
}
</script>
