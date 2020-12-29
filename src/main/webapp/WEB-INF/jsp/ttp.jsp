<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<frm:form modelAttribute="phong">


		<!-- thông báo lỗi ngoại lệ form -->
		<c:if test="${not empty errors|| not empty errorimg }">
			<div class="alert alert-danger">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong>
				<p>
					<frm:errors path="*"></frm:errors>
					<br>${errorimg }</p>
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
		<form action="timttp">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="number" name="data"
							placeholder="Search by room number, floor number"
							oninput="checkMaxLenghtNumber(this,9)" value="${data }" required />
						<span class="input-group-btn">
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
		<table class="table table-striped"
			style="font-size: 15px; white-space: nowrap;">
			<thead style="vertical-align: middle;">
				<tr>
					<th style="max-width: 92px">Picture</th>

					<th style="min-width: 80px; vertical-align: middle;">Room
						number</th>
					<th style="min-width: 80px; vertical-align: middle;">Kind of
						room</th>
					<th style="min-width: 80px; vertical-align: middle;">Floor</th>
					<th style="min-width: 80px; vertical-align: middle;">Convenient</th>

					<th style="min-width: 80px; vertical-align: middle;">Room
						Rates</th>
					<th style="min-width: 80px; vertical-align: middle;">Discount</th>
					<th style="min-width: 80px; vertical-align: middle;">Status</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="u" items="${lPhongs}">
					<tr>
						<td style="vertical-align: middle;"><img alt=""
							id="myImg${u.maPhong}" src="hinh/phong/${u.hinhAnh}" width="60px"
							height="60px"></td>

						<td style="vertical-align: middle;">${u.soPhong}</td>
						<td style="vertical-align: middle;">${u.loaiPhong.tenLoaiPhong}</td>
						<td style="vertical-align: middle;">${u.tang}</td>
						<td style="vertical-align: middle;">${u.tienNghi}</td>
						<td style="vertical-align: middle;"><fmt:formatNumber
								type="number" pattern="###,###" value="${u.giaPhong}" /> $</td>
						<td style="vertical-align: middle;">${u.khuyenMai}%</td>
						<td style="vertical-align: middle;"><c:if
								test="${u.trangThai==0}">Empty</c:if>
							<c:if test="${u.trangThai==1}">Hired</c:if></td>

					</tr>


					<style>
#myImg ${u .maPhong
	
}

{
border-radius
:
 
5px
;

    
cursor
:
 
pointer
;

    
transition
:
 
0
.3s
;


}
#myImg ${u .maPhong
	
}

:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal ${u .maPhong
	
}

{
display
:
 
none
; /* Hidden by default */

    
position
:
 
fixed
; /* Stay in place */

    
z-index
:
 
99
; /* Sit on top */

    
padding-top
:
 
100px
; /* Location of the box */

    
left
:
 
0
;

    
top
:
 
0
;

    
width
:
 
100
%; /* Full width */

    
height
:
 
100
%; /* Full height */

    
overflow
:
 
auto
; /* Enable scroll if needed */

    
background-color
:
 
rgb
(
0
,
0
,
0
)
; /* Fallback color */

    
background-color
:
 
rgba
(
0
,
0
,
0
,
0
.9
)
; /* Black w/ opacity */


}

/* Modal Content (image) */
.modal ${u .maPhong
	
}

-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption ${u .maPhong
	
}

{
margin
:
 
auto
;

    
display
:
 
block
;

    
width
:
 
80
%;

    
max-width
:
 
700px
;

    
text-align
:
 
center
;

    
color
:
 
#ccc
;

    
padding
:
 
10px
 
0
;

    
height
:
 
150px
;


}

/* Add Animation */
.modal ${u .maPhong
	
}

-content, #caption ${u .maPhong
	
}

{
-webkit-animation-name
:
 
zoom
;

    
-webkit-animation-duration
:
 
0
.6s
;

    
animation-name
:
 
zoom
;

    
animation-duration
:
 
0
.6s
;


}
@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close ${u .maPhong
	
}

{
position
:
 
absolute
;

    
top
:
 
15px
;

    
right
:
 
35px
;

    
color
:
 
#f1f1f1
;

    
font-size
:
 
40px
;

    
font-weight
:
 
bold
;

    
transition
:
 
0
.3s
;


}
.close ${u .maPhong
	
}

:hover, .close ${u .maPhong
	
}

:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
}
</style>

					<!-- The Modal image -->
					<div id="myModal${u.maPhong}" class="modal${u.maPhong}">
						<span class="close${u.maPhong}">&times;</span> <img
							class="modal${u.maPhong}-content" id="${u.maPhong}">
						<div id="caption${u.maPhong}"></div>
					</div>

					<!-- script image -->
					<script>
						// Get the modal
						var modal = document
								.getElementById('myModal${u.maPhong}');

						// Get the image and insert it inside the modal - use its "alt" text as a caption
						var img = document.getElementById('myImg${u.maPhong}');
						var modalImg = document.getElementById("${u.maPhong}");
						var captionText = document
								.getElementById("caption${u.maPhong}");
						img.onclick = function() {
							modal.style.display = "block";
							modalImg.src = this.src;
							captionText.innerHTML = this.alt;
						}

						// Get the <span> element that closes the modal
						var span = document
								.getElementsByClassName("close${u.maPhong}")[0];

						// When the user clicks on <span> (x), close the modal
						span.onclick = function() {
							modal.style.display = "none";
						}
					</script>





				</c:forEach>


			</tbody>
		</table>
	</div>

	<c:if test="${danhsach!=0}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="ttppage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="ttppage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="ttppage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="ttppage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="ttppage?data=${data }&page=${trangcuoi }" class="page-link">Last
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
				href="ttppagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="ttppagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="ttppagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="ttppagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="ttppagetim?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>
</div>