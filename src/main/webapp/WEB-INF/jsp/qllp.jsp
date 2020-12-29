<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form action="actionsuadsqldv" modelAttribute="loaiphong">
		<c:if test="${not empty errors }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong>
				<p>
					<frm:errors path="*"></frm:errors>
				</p>
			</div>
		</c:if>

		<!-- thông báo khi sửa hoặc xóa thành công -->
		<c:if test="${not empty message }">
			<div class="alert alert-success">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>

				<strong>${message }</strong>
			</div>
		</c:if>

	</frm:form>

	<div class="container">
		<form action="timdsqllp">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="text" name="data"
							placeholder="Search by code, name" maxlength="100"
							value="${data }" required /> <span class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span><span
									style="margin-left: 2px;"><i class="fa fa-search"></i>
									Search</span>
							</button>
						</span>
					</div>
				</div>
			</div>

		</form>
	</div>

	<div
		style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
		<table class="table table-striped css-serial"
			style="white-space: nowrap;">
			<thead>
				<tr>
					<th style="width: 50px;"></th>
					<th style="min-width: 100px;">Kind of room</th>
					<th style="min-width: 500px;">Description</th>
					<th style="min-width: 100px;">Act</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${lLoaiphongs}">
					<tr>
						<td></td>
						<td>${u.tenLoaiPhong}</td>
						<td>${u.moTa}</td>

						<td><button type="button" class="btn btn-warning btn-sm"
								data-toggle="modal" data-target="#myModalsua${u.maLoaiPhong}">
								<i class="fa fa-edit"></i> Edit
							</button>
							<button type="button" class="btn btn-danger btn-sm"
								data-toggle="modal" data-target="#myModalxoa${u.maLoaiPhong}">
								<i class="fa fa-trash-o"></i> Delete
							</button></td>
					</tr>



					<!-- Modal xoa -->
					<div class="modal fade" id="myModalxoa${u.maLoaiPhong}"
						role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">

									<h4 class="modal-title" style="font-weight: bold;">Delete
										room type</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<h6>
										You want to delete the room type code is <strong>${u.maLoaiPhong}</strong>?
									</h6>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<a href="deletelp?maLoaiPhong=${u.maLoaiPhong}"
										class="btn btn-success">Agree</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal sua -->
					<div class="modal fade" id="myModalsua${u.maLoaiPhong }"
						role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">
										Fix the room type code is <strong>${u.maLoaiPhong }</strong>
									</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<frm:form action="editlp" modelAttribute="loaiphong">
									<frm:hidden path="maLoaiPhong" value="${u.maLoaiPhong }" />
									<div class="modal-body">
										<div class="form-group">
											<label for="tenLoaiPhong" style="font-weight: bold;">Room
												type name:</label>
											<div class="col-sm-10">
												<frm:input id="tenLoaiPhong" class="form-control"
													path="tenLoaiPhong" placeholder="Enter a room type name"
													value="${u.tenLoaiPhong }" maxlength="100" />
											</div>
										</div>
										<div class="form-group">
											<label for="moTa" style="font-weight: bold;">Description:</label>
											<div class="col-sm-10">
												<frm:input id="moTa" class="form-control" path="moTa"
													placeholder="Enter a description" value="${u.moTa }" maxlength="250" />
											</div>
										</div>

									</div>

									<div class="modal-footer">
										<frm:button class="btn btn-warning">
											<i class="fa fa-edit"></i>  Completed</frm:button>
									</div>
								</frm:form>
							</div>
						</div>
					</div>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<c:if test="${not empty hienVaAnFormSua}">
		<table align="center">
			<tr>
				<td>
					<h1 align="center">Edit room type</h1> <frm:form action="editlp"
						modelAttribute="loaiphong">
						<tr>
							<td><frm:input type="hidden" path="maLoaiPhong"
									value="${maLoaiPhong }" /></td>

						</tr>
						<tr>
							<td>Room type name :</td>
							<td><frm:input path="tenLoaiPhong" value="${tenLoaiPhong }"
									maxlength="100" /></td>
						</tr>
						<tr>
							<td>Description :</td>
							<td><frm:input path="moTa" value="${moTa }" maxlength="250" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Sửa" /></td>
						</tr>
					</frm:form>
				</td>
			</tr>
		</table>
	</c:if>




	<!-- Khi danh sách bằng 0 thì không hiện chọn page -->
	<c:if test="${danhsach!=0}">
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="lppage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="lppage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="lppage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="lppage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="lppage?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
	<c:if test="${ not empty danhsachtim}">
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="lppagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="lppagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="lppagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="lppagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="lppagetim?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>

</div>




