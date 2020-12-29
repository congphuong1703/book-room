<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="dichvu">
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
			<frm:form action="actionthemdsqldv" modelAttribute="dichvu">

				<div class="form-group">
					<label for="tendv" style="font-weight: bold;">Service name:</label>
					<div class="col-sm-10">
						<frm:input id="tendv" class="form-control" path="tenDichVu"
							placeholder="Enter a service name" maxlength="50"/>
					</div>
				</div>

				<div class="form-group">
					<label style="font-weight: bold;" for="loaidv">Type of service:</label>
					<div class="col-sm-10">
						<frm:select class="form-control" id="loaidv" path="loaiDichVu">
							<frm:option value="0">Eating</frm:option>
							<frm:option value="1">Laundry</frm:option>
							<frm:option value="2">Relax</frm:option>
						</frm:select>
					</div>
				</div>

				<div class="form-group">
					<label style="font-weight: bold;" for="giadv">Service prices:</label>
					<div class="col-sm-10">

						<frm:input type="number" id="giadv" class="form-control"
							path="giaDichVu" placeholder="Enter the service price" oninput="checkMaxLenghtNumber(this,12)"/>
					</div>
				</div>

				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">More</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>