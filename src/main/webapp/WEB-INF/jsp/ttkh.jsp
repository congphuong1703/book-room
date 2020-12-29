<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">

	<div class="container">
		<form action="timttkh">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="text" name="data"
							placeholder="Search by name, phone number, identity card" maxlength="100"
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
					<th>First and last name</th>
					<th>Phone number</th>
					<th>ID code</th>
					<th>Room</th>
					<th>Time set</th>
					<th>Payment time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${l }">
					<tr>
						<td></td>
						<td>${u.hoTen }</td>
						<td>${u.soDT }</td>
						<td>${u.soCMND }</td>
						<td>${u.phong.maPhong }</td>
						<td><fmt:formatDate pattern="HH:mm" value="${u.gioDat }" /> -
							<fmt:formatDate pattern="d/M/yyyy" value="${u.ngayDat }" /></td>


						<td><c:if test="${empty u.traPhongs }">
           Unpaid
           </c:if> <c:forEach var="i" items="${u.traPhongs }">

								<fmt:formatDate pattern="HH:mm" value="${i.gioTra }" /> - <fmt:formatDate
									pattern="d/M/yyyy" value="${i.ngayTra }" />


							</c:forEach></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${danhsach!=0}">

		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="ttkhpage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="ttkhpage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"></a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="ttkhpage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="ttkhpage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="ttkhpage?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>


	<c:if test="${ not empty danhsachtim}">
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="ttkhpagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="ttkhpagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"></a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="ttkhpagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="ttkhpagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="ttkhpagetim?data=${data }&page=${trangcuoi }"
				class="page-link">Last page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
</div>




