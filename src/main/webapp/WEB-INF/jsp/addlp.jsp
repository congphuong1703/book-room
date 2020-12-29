<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="loaiphong">
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
			<frm:form action="actionaddlp" modelAttribute="loaiphong">
				<div class="form-group">
					<label for="tenLoaiPhong" style="font-weight: bold;">Room Type-name:</label>
					<div class="col-sm-10">
						<frm:input id="tenLoaiPhong" class="form-control"
							path="tenLoaiPhong" maxlength="100" placeholder="Room Type-name..." />
					</div>
				</div>
				<div class="form-group">
					<label for="moTa" style="font-weight: bold;">Description:</label>
					<div class="col-sm-10">
						<frm:input id="moTa" class="form-control" path="moTa"
							maxlength="250" placeholder="Description..." />
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">Add</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>
