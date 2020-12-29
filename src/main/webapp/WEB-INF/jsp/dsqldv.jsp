
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">

	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form action="actionsuadsqldv" modelAttribute="dichvu">
		<c:if test="${not empty errors }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Lỗi!</strong>
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
		<form action="timdsqldv">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="text" name="data"
							placeholder="Search by code or name" maxlength="50"
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
		style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888; margin-bottom: 25px;">
		<table class="table table-striped css-serial"
			style="font-size: 15px; white-space: nowrap;">
			<thead>
				<tr>
					<th style="width: 50px;"></th>
					<th style="min-width: 250px;">Service name</th>
					<th style="min-width: 200px;">Species</th>
					<th style="min-width: 200px;">Prices</th>
					<th style="min-width: 130px;">Act</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${lqldv}">
					<tr>
						<td></td>
						<td style="min-width: 200px;">${u.tenDichVu }</td>
						<td style="min-width: 200px;"><c:if
								test="${u.loaiDichVu==0 }">Eating</c:if> <c:if
								test="${u.loaiDichVu==1 }">Laundry</c:if> <c:if
								test="${u.loaiDichVu==2 }">Relax</c:if></td>
						<td style="min-width: 200px;"><fmt:formatNumber
								value="${u.giaDichVu }" type="number" pattern="###,###" /> $</td>
						<td style="min-width: 130px;">
							<button type="button" class="btn btn-warning btn-sm"
								data-toggle="modal" data-target="#myModal${u.maDichVu }">
								<i class="fa fa-edit"></i> Edit
							</button>
							<button type="button" class="btn btn-danger btn-sm"
								data-toggle="modal" data-target="#myModalxoa${u.maDichVu }">
								<i class="fa fa-trash-o"></i> Delete
							</button>
						</td>
					</tr>





					<!-- Modal xoa -->
					<div class="modal fade" id="myModalxoa${u.maDichVu }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">

									<h4 class="modal-title" style="font-weight: bold;">Delete
										services</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<h6>
										You want to delete the service code <strong>${u.maDichVu }</strong>?
									</h6>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<a href="deleteqldv?id=${u.maDichVu}" class="btn btn-success">Agree</a>
								</div>
							</div>
						</div>
					</div>






					<!-- Modal sua -->
					<div class="modal fade" id="myModal${u.maDichVu }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">
										Edit service code is <strong>${u.maDichVu }</strong>
									</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<frm:form action="actionsuadsqldv" modelAttribute="dichvu">
									<frm:hidden path="maDichVu" value="${u.maDichVu }" />
									<div class="modal-body">
										<div class="form-group">
											<label for="tendv">Service name:</label>
											<frm:input path="tenDichVu" class="form-control input-sm"
												id="tendv" type="text" value="${u.tenDichVu }"
												maxlength="50" />
										</div>
										<div class="form-group">
											<label for="loaidv">Type of service:</label>
											<frm:select path="loaiDichVu" class="form-control"
												id="loaidv">
												<option value="0" label="Eating"
													<c:if test="${u.loaiDichVu == 0 }">selected="selected"</c:if> />
												<option value="1" label="Laundry"
													<c:if test="${u.loaiDichVu == 1 }">selected="selected"</c:if> />
												<option value="2" label="Relax"
													<c:if test="${u.loaiDichVu == 2 }">selected="selected"</c:if> />
											</frm:select>
										</div>
										<label for="giadv">Price service:</label>
										<frm:input path="giaDichVu" class="form-control input-sm"
											id="giadv" value="${u.giaDichVu }" type="number"
											oninput="checkMaxLenghtNumber(this,12)" />
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
	<!-- Khi danh sách bằng 0 thì không hiện chọn page -->
	<c:if test="${danhsach!=0}">
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="dsqldvpage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="dsqldvpage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="dsqldvpage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="dsqldvpage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="dsqldvpage?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>

	<c:if test="${ not empty danhsachtim}">
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="dsqldvpagetim?data=${data }&page=${trangdau }"
				class="page-link">First page</a></li>
			<li class="page-item prev"><a
				href="dsqldvpagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="dsqldvpagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="dsqldvpagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="dsqldvpagetim?data=${data }&page=${trangcuoi }"
				class="page-link">Last page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
</div>

