<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div id="messageCustom" class="alert alert-danger"
		style="display: none;">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>....</strong>
	</div>
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${message }</strong>
		</div>
	</c:if>
</div>
<div class="container">
	<button type="button" class="btn btn-success"
		style="margin-bottom: 10px;"
		onclick="backthemlich(${maPhong}, ${soPhong})">Come back</button>
	<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
		<div>
			<frm:form action="/actionthemlich" modelAttribute="lichDatPhong">
				<div class="form-group">
					<label for=tenNguoiDat style="font-weight: bold;">Customer's full name:</label>
					<frm:input id="tenNguoiDat" class="form-control" path="tenNguoiDat"
						placeholder="Import FullName" maxlength="50" required="required" />
				</div>
				<div class="form-group">
					<label for="soDienThoai" style="font-weight: bold;">Phone number:</label>
					<frm:input id="soDienThoai" type="number" class="form-control"
						path="soDienThoai" placeholder="Import phone number"
						oninput="checkMaxLenghtNumber(this,20)" required="required" />
				</div>
				<div class="form-group">
					<label for="gioDat" style="font-weight: bold;">Time set:</label>
					<frm:input id="gioDat" class="form-control" path="gioDat"
						type="time" required="required" />
				</div>
				<div class="form-group">
					<label for="ngayDat" style="font-weight: bold;">Date of booking:</label> <input
						id="ngayDat" name="ngayDat" class="form-control" type="date"
						max="9999-12-31" required="required" />
				</div>
				<div class="form-group">
					<label for="thongTinThem" style="font-weight: bold;">More information:</label>
					<frm:input id="thongTinThem" class="form-control"
						path="thongTinThem" placeholder="Optional" maxlength="255" />
				</div>
				<frm:hidden id="tenDangNhap" class="form-control" path="tenDangNhap"
					value="${nguoidung }" />
				<frm:hidden class="form-control" path="phong.maPhong"
					value="${maPhong }" />
				<input id="maPhong" type="hidden" name="maPhong" value="${maPhong }">
				<input id="soPhong" type="hidden" name="soPhong" value="${soPhong }">
				<frm:button type="submit" class="btn btn-success btn-xs float-right">Confirm</frm:button>
			</frm:form>
		</div>
	</div>
</div>
<script type="text/javascript">
function backthemlich(maPhong,soPhong) {
	window.location="/dslichdatphong?maPhong=" + maPhong + "&soPhong="+ soPhong;
}

</script>
