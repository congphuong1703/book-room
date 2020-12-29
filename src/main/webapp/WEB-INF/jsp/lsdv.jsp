<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="container">
		<form action="timlsdv">
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
			style="font-size: 15px; white-space: nowrap;">
			<thead>
				<tr>
					<th style="width: 50px;"></th>
					<th>Name service</th>
					<th>Species</th>
					<th>Quantity</th>
					<th>Room set</th>
					<th>Time</th>
					<th>More information</th>
					<th>Staff</th>
				</tr>
			</thead>
			<c:forEach var="u" items="${l }">
				<tr>
					<td></td>
					<td>${u.dichVu.tenDichVu }</td>
					<td><c:if test="${u.dichVu.loaiDichVu ==0}">Eating</c:if> <c:if
							test="${u.dichVu.loaiDichVu ==1}">Laundry</c:if> <c:if
							test="${u.dichVu.loaiDichVu ==2}">Relax</c:if></td>
					<td>${u.soLuong }</td>
					<td>${u.datPhong.phong.soPhong }</td>
					<td><fmt:formatDate value="${u.gioDat }" pattern="HH:mm" /> -
						<fmt:formatDate value="${u.ngayDat }" pattern="d/M/yyyy" /></td>
					<td>${u.thongTinThem }</td>
					<td>${u.tenDangNhap }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:if test="${danhsach!=0}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="lsdvpage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="lsdvpage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>
			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="lsdvpage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>
			<li class="page-item next"><a
				href="lsdvpage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="lsdvpage?data=${data }&page=${trangcuoi }" class="page-link">
					Last page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
	<c:if test="${ not empty danhsachtim}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="lsdvpagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="lsdvpagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>
			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="lsdvpagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>
			<li class="page-item next"><a
				href="lsdvpagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="lsdvpagetim?data=${data }&page=${trangcuoi }"
				class="page-link">Last page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
</div>
