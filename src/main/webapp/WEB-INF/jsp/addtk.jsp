<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="taikhoan">
		<c:if test="${not empty errors|| not empty errortk }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong>

				<p>
					<frm:errors path="*"></frm:errors>
					<br>${errortk }</p>

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
<frm:form action="actionaddtk" modelAttribute="taikhoan">
	<div class="container">
		<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
			<div>

				<div class="form-group">
					<label for="tenDangNhap" style="font-weight: bold;">User name:</label>
					<div class="col-sm-10">
						<frm:input id="tenDangNhap" class="form-control"
							path="tenDangNhap" placeholder="Enter your username" maxlength="50"/>
					</div>
				</div>

				<div class="form-group">
					<label for="matKhau" style="font-weight: bold;">Password:</label>
					<div class="col-sm-10">
						<frm:input type="password" id="matKhau" class="form-control"
							path="matKhau" placeholder="Enter password" maxlength="100"/>
					</div>
				</div>
				<div class="form-group">
					<label for="hoTen" style="font-weight: bold;">First and last name:</label>
					<div class="col-sm-10">
						<frm:input id="hoTen" class="form-control" path="hoTen"
							placeholder="Enter your first and last name" maxlength="100"/>
					</div>
				</div>
				<div class="form-group">
					<label for="gioiTinh" style="font-weight: bold;">Gender:</label>
					<div class="col-sm-10">
						<frm:select id="gioiTinh" class="form-control" path="gioiTinh">
							<frm:option value="Male">Male</frm:option>
							<frm:option value="Female">Female</frm:option>
						</frm:select>
					</div>
				</div>

				<div class="form-group">
					<label for="ngaySinh" style="font-weight: bold;">Date of birth:</label>
					<div class="col-sm-10">
						<frm:input type="date" id="ngaySinh" class="form-control"
							path="ngaySinh" placeholder="Choose a date of birth" max="9999-12-31"/>
					</div>
				</div>

				<div class="form-group">
					<label for="CMND" style="font-weight: bold;">Identity card:</label>
					<div class="col-sm-10">
						<frm:input type="number" id="CMND" class="form-control"
							path="cmnd" placeholder="Enter your identity card number" oninput="checkMaxLenghtNumber(this,20)"/>
					</div>
				</div>

				<div class="form-group">
					<label for="soDT" style="font-weight: bold;">Phone number:</label>
					<div class="col-sm-10">
						<frm:input type="number" id="soDT" class="form-control"
							path="soDT" placeholder="Enter your phone number" oninput="checkMaxLenghtNumber(this,15)"/>
					</div>
				</div>

				<div class="form-group">
					<label for="Email" style="font-weight: bold;">Email:</label>
					<div class="col-sm-10">
						<frm:input type="Email" id="Email" class="form-control"
							path="Email" placeholder="Enter your email address" oninput="checkMaxLenghtNumber(this,100)"/>
					</div>
				</div>

				<div class="form-group">
					<label for="Email" style="font-weight: bold;">Position:</label>
					<div class="col-sm-10">
						<frm:select class="form-control" path="chucVu.maChucVu">
							<frm:option value="1">Manager</frm:option>
							<frm:option value="2">Staff</frm:option>
						</frm:select>
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">Save</frm:button>
				</div>
			</div>
		</div>
	</div>
</frm:form>