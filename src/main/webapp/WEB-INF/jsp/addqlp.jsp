<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="phong">
		<c:if test="${not empty errors|| not empty errorimg }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Error!</strong>
				<p>
					<frm:errors path="*"></frm:errors>
					<br>${errorimg }</p>
			</div>
		</c:if>
	</frm:form>
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>${message }</strong>
		</div>
	</c:if>
</div>
<div class="container">
	<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
		<div>
			<frm:form action="actionaddqlp" modelAttribute="phong" enctype="multipart/form-data">
				<div class="form-group">
					<div class="col-sm-10">
						<label for="sophong" style="font-weight: bold;">Room number:</label>
						<frm:input path="soPhong" class="form-control input-sm" id="sophong" type="number" oninput="checkMaxLenghtNumber(this,9)" placeholder="Enter the room number" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="tang" style="font-weight: bold;">Floor</label>
						<frm:input path="tang" class="form-control input-sm" id="tang" type="number" placeholder="Enter the floor number" oninput="checkMaxLenghtNumber(this,2)" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="tienNghi" style="font-weight: bold;">Convenient:</label>
						<frm:label path="tienNghi" id="tienNghi"></frm:label>
						<br>
						<table>
							<tr>
								<td width="120px;"><frm:checkbox path="tienNghi" value="Air conditioning" label="  Air conditioning" /></td>
								<td><frm:checkbox path="tienNghi" value="Fan" label="  Fan" /></td>
							</tr>
							<tr>
								<td><frm:checkbox path="tienNghi" value="Tivi" label="  Television" /></td>
								<td><frm:checkbox path="tienNghi" value="Hot and cold water" label="  Hot and cold water" /></td>
							</tr>
							<tr>
								<td><frm:checkbox path="tienNghi" value="The good place" label="  The good place" /></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="loaiPhong" style="font-weight: bold;">Kind of room:</label>
						<frm:select path="loaiPhong.maLoaiPhong" class="form-control input-sm" id="loaiPhong">
							<frm:options items="${itemloaiphong }" itemLabel="tenLoaiPhong" itemValue="maLoaiPhong" />
						</frm:select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="hinhAnh" style="font-weight: bold;">Picture:</label> <input type="file" class="form-control" id="file" name="file" accept=".jpg,.JPG,.png,.PNG,.jpeg,.JPEG" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="giaPhong" style="font-weight: bold;">Room Rates:</label>
						<frm:input path="giaPhong" class="form-control input-sm" id="giaPhong" type="number" placeholder="Enter the room rate" oninput="checkMaxLenghtNumber(this,12)" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="giaPhongGioDau" style="font-weight: bold;">First hour price:</label>
						<frm:input path="giaPhongGioDau" class="form-control input-sm" id="giaPhongGioDau" type="number" placeholder="Enter the first hour price" oninput="checkMaxLenghtNumber(this,12)" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="giaPhongGioSau" style="font-weight: bold;">Prices for the next hour:</label>
						<frm:input path="giaPhongGioSau" class="form-control input-sm" id="giaPhongGioSau" type="number" placeholder="Enter the next hourly rate" oninput="checkMaxLenghtNumber(this,12)"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="giaHomestay" style="font-weight: bold;">Homestay price:</label>
						<frm:input path="giaHomestay" class="form-control input-sm" id="giaHomestay" type="number" placeholder="Enter the homestay price" oninput="checkMaxLenghtNumber(this,12)"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label for="khuyenMai" style="font-weight: bold;">Discount:</label>
						<frm:input path="khuyenMai" class="form-control input-sm" id="khuyenMai" type="number" placeholder="Enter a discount percentage" min="0" max="100" oninput="checkMaxLenghtNumber(this,3)"/>
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">More</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('#file').change(function() {

			//because this is single file upload I use only first index
			var f = this.files[0]

			//here I CHECK if the FILE SIZE is bigger than 8 MB (numbers below are in bytes)
			if (f.size > 8388608 || f.fileSize > 8388608) {
				//show an alert to the user
				alert("Picture size exceeds the limit of 8 MB");

				//reset file upload control
				this.value = null;
			}
		})
	});
</script>
