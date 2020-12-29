<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${message }</strong>
		</div>
	</c:if>

	<div class="container">
		<button type="button" class="btn btn-success"
			style="margin-bottom: 10px;" onclick="themthuchi()">Add new</button>
		<div class="row" style="float: right; margin-right: 0px;">
			<form action="timthuchi">
				<div class="form-group row">
					<div class="col-xs-2 input-timkiemdate">
						<input class="form-control" type="text"
							onfocus="(this.type='date')"
							onblur="if(this.value==''){this.type='text'}" name="tungay"
							placeholder="Since" value="${tungay }" max="9999-12-31"
							required="required" />
					</div>
					<b>&nbsp;_&nbsp;</b>
					<div class="col-xs-2 input-timkiemdate">
						<input class="form-control" type="text"
							onfocus="(this.type='date')"
							onblur="if(this.value==''){this.type='text'}" name="denngay"
							placeholder="To date" value="${denngay }" max="9999-12-31"
							required="required" />
					</div>

					<span class="input-group-btn">
						<button class="btn btn-success" type="submit">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span><span
								style="margin-left: 2px;"><i class="fa fa-search"></i>
								Statistical</span>
						</button>
					</span>
				</div>
			</form>
		</div>

	</div>
	<div
		style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
		<table class="table table-striped css-serial"
			style="font-size: 15px; word-wrap: break-word;">
			<thead style="vertical-align: middle;">
				<tr>
					<th style="width: 50px;"></th>
					<th style="max-width: 200px; vertical-align: middle;">Content</th>
					<th
						style="max-width: 200px; vertical-align: middle; white-space: nowrap;">Species</th>
					<th
						style="min-width: 80px; vertical-align: middle; white-space: nowrap;">Amount
						of money</th>
					<th
						style="min-width: 80px; vertical-align: middle; white-space: nowrap;">Time</th>
					<th
						style="min-width: 80px; vertical-align: middle; white-space: nowrap;">Username</th>
					<th
						style="width: auto; vertical-align: middle; white-space: nowrap;">Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="u" items="${l}">
					<tr>
						<td></td>
						<td style="vertical-align: middle;">${u.noiDungChi}</td>
						<td style="vertical-align: middle; white-space: nowrap;">${u.loaiThuChi==0?'Thu':'Chi'}</td>
						<td style="vertical-align: middle; white-space: nowrap;"><fmt:formatNumber
								type="number" pattern="###,###" value="${u.soTien }" /> $</td>
						<td style="vertical-align: middle; white-space: nowrap;"><fmt:formatDate
								pattern="HH:mm" value="${u.gioChi }" /> - <fmt:formatDate
								pattern="d/M/yyyy" value="${u.ngayChi }" /></td>
						<td style="vertical-align: middle; white-space: nowrap;">${u.tenDangNhap}</td>
						<td style="vertical-align: middle; white-space: nowrap;"><button
								type="button" class="btn btn-danger btn-sm"
								onclick="xoaThuChi(${u.maThuChi })"
								<c:if test="${empty ancaidai }">disabled="disabled"</c:if>>
								<i class="fa fa-trash-o"></i> Delete
							</button></td>
					</tr>
				</c:forEach>
				<tr>
					<th colspan="7" style="vertical-align: middle; text-align: center;">total
						revenue: <fmt:formatNumber type="number" pattern="###,###"
							value="${tongTienThu }" />
						VNĐ&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;total expenditure: <fmt:formatNumber
							type="number" pattern="###,###" value="${tongTienChi }" /> $
					</th>
				</tr>
			</tbody>
		</table>
	</div>
	<c:if test="${l.size()!=0}">
		<c:if test="${danhsach!=0}">
			<br>
			<ul class="pagination" id="pagination"
				style="float: right; box-shadow: 1px 1px 5px #888888;">
				<li class="page-item first"><a
					href="thuchipage?tungay=${tungay }&denngay=${denngay }&page=${trangdau }"
					class="page-link">First page</a></li>
				<li class="page-item prev"><a
					href="thuchipage?tungay=${tungay }&denngay=${denngay }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
					<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
					class="page-link"></a></li>

				<c:forEach items="${listSoLuongTrang }" var="u">
					<li class="page-item"><a
						<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
						href="thuchipage?tungay=${tungay }&denngay=${denngay }&page=${u }"
						class="page-link">${u }</a></li>
				</c:forEach>

				<li class="page-item next"><a
					href="thuchipage?tungay=${tungay }&denngay=${denngay }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
					<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
					class="page-link">></a></li>
				<li class="page-item last"><a
					href="thuchipage?tungay=${tungay }&denngay=${denngay }&page=${trangcuoi }"
					class="page-link">Last page</a></li>
			</ul>
			<br>
			<br>
		</c:if>


		<c:if test="${ not empty danhsachtim}">
			<br>
			<ul class="pagination" id="pagination"
				style="float: right; box-shadow: 1px 1px 5px #888888;">
				<li class="page-item first"><a
					href="thuchipagetim?tungay=${tungay }&denngay=${denngay }&page=${trangdau }"
					class="page-link">First page</a></li>
				<li class="page-item prev"><a
					href="thuchipagetim?tungay=${tungay }&denngay=${denngay }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
					<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
					class="page-link"></a></li>

				<c:forEach items="${listSoLuongTrang }" var="u">
					<li class="page-item"><a
						<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
						href="thuchipagetim?tungay=${tungay }&denngay=${denngay }&page=${u }"
						class="page-link">${u }</a></li>
				</c:forEach>

				<li class="page-item next"><a
					href="thuchipagetim?tungay=${tungay }&denngay=${denngay }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
					<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
					class="page-link">></a></li>
				<li class="page-item last"><a
					href="thuchipagetim?tungay=${tungay }&denngay=${denngay }&page=${trangcuoi }"
					class="page-link">Last page</a></li>
			</ul>
			<br>
			<br>
		</c:if>
	</c:if>
</div>

<script>
            function xoaThuChi(maThuChi) {
            	if (confirm("You want to delete?")) 
                {
            	window.location="/actionxoathuchi?maThuChi=" + maThuChi;
                }
            }
            
            function themthuchi() {
            	window.location="/themthuchi";
               
            }
            </script>