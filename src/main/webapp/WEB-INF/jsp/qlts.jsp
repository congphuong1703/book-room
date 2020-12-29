<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="thongSoTheoGio">
		<c:if test="${not empty errors }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong>

				<p>
					<frm:errors path="*"></frm:errors>
				</p>

			</div>
		</c:if>
	</frm:form>
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>

			<strong>${message }</strong>
		</div>
	</c:if>
</div>
<div class="container">
	<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
		<div>
			<frm:form action="updategiaodien" modelAttribute="giaoDien">
				<h5>
					<b>Display</b>
				</h5>
				<hr>
				<div class="form-group">
					<label for="tenToChuc" style="font-weight: bold;">Name of
						motel / hotel</label>

					<div class="col-sm-10">
						<frm:input id="tenToChuc" class="form-control" path="tenToChuc"
							placeholder="Enter the hostel / hotel name" required="required"
							maxlength="25" />
						<p style="color: darkgray;">** Display on web and print
							invoice.</p>
					</div>
				</div>
				<div class="form-group">
					<label for="diaChi" style="font-weight: bold;">Address</label>

					<div class="col-sm-10">
						<frm:input id="diaChi" class="form-control" path="diaChi"
							placeholder="Enter the motel / hotel address" required="required"
							maxlength="60" />
						<p style="color: darkgray;">** Show on invoice.</p>
					</div>
				</div>
				<div class="form-group">
					<label for="soDienThoai" style="font-weight: bold;">Phone
						number</label>

					<div class="col-sm-10">
						<frm:input type="number" id="soDienThoai" class="form-control"
							path="soDienThoai" placeholder="Enter your phone number"
							required="required" oninput="checkMaxLenghtNumber(this,20)" />
						<p style="color: darkgray;">** Show on invoice.</p>
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">Update</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>

<div class="container">
	<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
		<div>
			<frm:form action="updatets" modelAttribute="thongSoTheoGio">
				<h5>
					<b>Hourly rental specifications</b>
				</h5>
				<hr>
				<frm:hidden id="maThongSo" class="form-control" path="maThongSo" />
				<div class="form-group">
					<label for="baoNhieuGioDau" style="font-weight: bold;">First
						hours: </label>

					<div class="col-sm-10">
						<frm:input type="number" id="baoNhieuGioDau" class="form-control"
							path="baoNhieuGioDau" placeholder="Enter the first hours"
							required="required" oninput="checkMaxLenghtNumber(this,9)" />
						<p style="color: darkgray;">** ${thongSoTheoGio.baoNhieuGioDau }
							first time 50$, from now on only 20$ / hour.</p>
					</div>
				</div>
				<div class="form-group">
					<label for="soGioChuyenThanhNgay" style="font-weight: bold;">Hours
						converted to daily rentals: </label>
					<div class="col-sm-10">
						<frm:input type="number" id="soGioChuyenThanhNgay"
							class="form-control" path="soGioChuyenThanhNgay"
							placeholder="Enter the hours" required="required"
							oninput="checkMaxLenghtNumber(this,9)" />
						<p style="color: darkgray;">** Too
							${thongSoTheoGio.soGioChuyenThanhNgay } Now, we will change from
							hourly to daily.</p>
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">Update</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>