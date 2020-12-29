<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<!-- thông báo lỗi ngoại lệ form -->
	<frm:form modelAttribute="taikhoan">
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
	<div class="container">
		<form action="timkiemidornametk">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="text" name="data"
							placeholder="Enter information to look for" maxlength="50"
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
			style="white-space: nowrap; font-size: 15px;">
			<thead>
				<tr>
					<th style="width: 50px;"></th>
					<th style="min-width: 80px;">Username</th>
					<th style="min-width: 80px;">First and last name</th>
					<th style="min-width: 80px;">Gender</th>
					<th style="min-width: 80px;">Date of birth</th>
					<th style="min-width: 80px;">Identity card</th>
					<th style="min-width: 80px;">Phone number</th>
					<th style="min-width: 80px;">Email</th>
					<th style="min-width: 80px;">Position</th>
					<th style="min-width: 80px;">Creation time</th>
					<th style="min-width: 80px;">Work</th>
				</tr>
			</thead>
			<c:forEach var="u" items="${lTaikhoans}">
				<tr>
					<td></td>
					<td>${u.tenDangNhap}</td>

					<td>${u.hoTen}</td>
					<td>${u.gioiTinh}</td>
					<td><fmt:formatDate value="${u.ngaySinh }" pattern="yyyy-MM-dd" /></td>
					<td>${u.cmnd}</td>
					<td>${u.soDT}</td>
					<td>${u.email}</td>
					<td>${u.chucVu.tenChucVu}</td>
					<td><fmt:formatDate value="${u.gioTao }" pattern="HH:mm" /> -
						<fmt:formatDate value="${u.ngayTao }" pattern="yyyy-MM-dd" /></td>
					<td><button type="button" class="btn btn-warning btn-sm"
							data-toggle="modal" data-target="#myModalsua${u.tenDangNhap}"
							onclick="changeNgaySinhEdit('${u.tenDangNhap}')">
							<i class="fa fa-edit"></i> Edit
						</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-toggle="modal" data-target="#myModalxoa${u.tenDangNhap}">
							<i class="fa fa-trash-o"></i> Delete
						</button></td>
				</tr>
				<!-- Modal xoa -->
				<div class="modal fade" id="myModalxoa${u.tenDangNhap}"
					role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" style="font-weight: bold;">Delete
									the account</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<h6>
									You want to delete the account <strong>${u.tenDangNhap}?</strong>
								</h6>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
								<a href="delete?tenDangNhap=${u.tenDangNhap}"
									class="btn btn-success">Agree</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal sua -->
				<frm:form action="edittk" modelAttribute="taikhoan">
					<div class="modal fade" id="myModalsua${u.tenDangNhap }"
						role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">

									<h4 class="modal-title" style="font-weight: bold;">
										Modify your account <strong>${u.tenDangNhap }</strong>
									</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="tenDangNhap" style="font-weight: bold;">User
											name:</label> <input class="form-control input-sm" id="tenDangNhap"
											placeholder="Enter your username" value="${u.tenDangNhap }"
											disabled />
										<frm:hidden path="tenDangNhap" value="${u.tenDangNhap }" />
									</div>
									<div class="form-group">
										<label for="matKhau" style="font-weight: bold;">Password:</label>

										<frm:input type="password" id="matKhau" class="form-control"
											path="matKhau" placeholder="Enter password" value=""
											maxlength="100" />
									</div>
									<div class="form-group">
										<label for="hoTen" style="font-weight: bold;">First
											and last name:</label>

										<frm:input id="hoTen" class="form-control" path="hoTen"
											placeholder="Enter your first and last name"
											value="${u.hoTen }" maxlength="100" />
									</div>
									<div class="form-group">
										<label for="gioiTinh" style="font-weight: bold;">Gender:</label>

										<frm:select id="gioiTinh" class="form-control" path="gioiTinh">
											<frm:option value="Male">Male</frm:option>
											<frm:option value="Female">Female</frm:option>
										</frm:select>
									</div>
									<div id="inputngaySinh-${u.tenDangNhap }" class="form-group">
										<label for="ngaySinh" style="font-weight: bold;">Date
											of birth:</label> <span id="ngaySinh-${u.tenDangNhap }"
											style="display: none"><fmt:formatDate
												value="${u.ngaySinh }" pattern="yyyy-MM-dd" /></span>
										<frm:input type="date" id="ngaySinh" class="form-control"
											path="ngaySinh" placeholder="Choose a date of birth" value=""
											max="9999-12-31" />
									</div>


									<div class="form-group">
										<label for="CMND" style="font-weight: bold;">Identity card:</label>

										<frm:input type="number" id="CMND" class="form-control"
											path="cmnd" placeholder="Enter your identity card number"
											value="${u.cmnd }" oninput="checkMaxLenghtNumber(this,20)" />
									</div>


									<div class="form-group">
										<label for="soDT" style="font-weight: bold;">Phone
											number:</label>

										<frm:input type="number" id="soDT" class="form-control"
											path="soDT" placeholder="Enter your phone number"
											value="${u.soDT }" oninput="checkMaxLenghtNumber(this,15)" />
									</div>


									<div class="form-group">
										<label for="Email" style="font-weight: bold;">Email:</label>

										<frm:input type="Email" id="Email" class="form-control"
											path="Email" placeholder="Enter your email address"
											value="${u.email }" maxlength="100" />
									</div>


									<div class="form-group">
										<label for="Email" style="font-weight: bold;">Position:</label>

										<frm:select class="form-control" path="chucVu.maChucVu">
											<option value="1"
												${u.chucVu.maChucVu == 1?"selected='selected'":"" }>Manager</option>
											<option value="2"
												${u.chucVu.maChucVu == 2?"selected='selected'":"" }>Staff</option>
										</frm:select>
									</div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-success">Agree</button>
								</div>

							</div>
						</div>
					</div>
				</frm:form>
			</c:forEach>
		</table>
	</div>
	<c:if test="${danhsach!=0}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="tkpage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="tkpage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="tkpage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="tkpage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="tkpage?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>


	<c:if test="${ not empty danhsachtim}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="tkpagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="tkpagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="tkpagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="tkpagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="tkpagetim?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
</div>

