<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
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
	<button type="button" class="btn btn-success"
		style="margin-bottom: 10px;" onclick="backthuchi()">Come back</button>
	<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
		<div>
			<frm:form action="themthuchipost" modelAttribute="thuchi">
				<div class="form-group">
					<label for="loaiThuChi" style="font-weight: bold;">Category:</label>
					<div class="col-sm-10">
						<frm:select id="loaiThuChi" class="form-control input-sm"
							path="loaiThuChi">
							<frm:option value="1" label="Chi" />
							<frm:option value="0" label="Thu" />
						</frm:select>
					</div>
				</div>
				<div class="form-group">
					<label for="noiDungChi" style="font-weight: bold;">Content:</label>
					<div class="col-sm-10">
						<frm:input id="noiDungChi" class="form-control" path="noiDungChi"
							placeholder="Import content" maxlength="255" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="soTien" style="font-weight: bold;">amount of money:</label>
					<div class="col-sm-10">
						<frm:input id="soTien" type="number" class="form-control"
							path="soTien" placeholder="Enter the amount"
							oninput="checkMaxLenghtNumber(this,12)" required="required" />
					</div>
				</div>
				<div class="container">
					<frm:button type="submit" class="btn btn-success btn-xs">Add</frm:button>
				</div>
			</frm:form>
		</div>
	</div>
</div>
<script>
	function backthuchi() {
		window.location = "/thuchi";
	}
</script>
