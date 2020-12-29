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
		<form action="timqlp">

			<div class="row" style="float: right">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" type="number" name="data"
							placeholder="Tìm theo mã, số, tầng" maxlength="9"
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

					<th style="min-width: 80px; vertical-align: middle;">Room rate
						/ day</th>
					<th style="min-width: 80px; vertical-align: middle;">First
						hour price</th>
					<th style="min-width: 80px; vertical-align: middle;">Prices
						for the next hour</th>
					<th style="min-width: 80px; vertical-align: middle;">Homestay
						price</th>

					<th style="min-width: 80px; vertical-align: middle;">Discount</th>
					<th style="min-width: 80px; vertical-align: middle;">Status</th>
					<th style="width: auto; vertical-align: middle;">Act</th>
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
						<td style="vertical-align: middle;"><fmt:formatNumber
								type="number" pattern="###,###" value="${u.giaPhongGioDau}" />
							$</td>
						<td style="vertical-align: middle;"><fmt:formatNumber
								type="number" pattern="###,###" value="${u.giaPhongGioSau}" />
							$</td>
						<td style="vertical-align: middle;"><fmt:formatNumber
								type="number" pattern="###,###" value="${u.giaHomestay}" /> $</td>
						<td style="vertical-align: middle;">${u.khuyenMai}%</td>
						<td style="vertical-align: middle;"><c:if
								test="${u.trangThai==0}">Empty</c:if>
							<c:if test="${u.trangThai==1}">Hired</c:if></td>
						<td style="vertical-align: middle;"><button type="button"
								class="btn btn-warning btn-sm" data-toggle="modal"
								data-target="#myModalsua${u.maPhong}">
								<i class="fa fa-edit"></i> Edit
							</button>
							<button type="button" class="btn btn-danger btn-sm"
								data-toggle="modal" data-target="#myModalxoa${u.maPhong}">
								<i class="fa fa-trash-o"></i> Delete
							</button></td>
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

					<script>
var modal = document.getElementById('myModal${u.maPhong}');

var img = document.getElementById('myImg${u.maPhong}');
var modalImg = document.getElementById("${u.maPhong}");
var captionText = document.getElementById("caption${u.maPhong}");
img.onclick = function(){
    modal.style.display = "block";
    modalImg.src = this.src;
    captionText.innerHTML = this.alt;
}

var span = document.getElementsByClassName("close${u.maPhong}")[0];

span.onclick = function() { 
    modal.style.display = "none";
}
</script>

					<!-- Modal xoa -->
					<div class="modal fade" id="myModalxoa${u.maPhong}" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">

									<h4 class="modal-title" style="font-weight: bold;">Delete
										Room</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<h6>
										You want to delete the room code is <strong>${u.maPhong}?</strong>
									</h6>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancek</button>
									<a href="deletephong?maphong=${u.maPhong}"
										class="btn btn-success">Agree</a>
								</div>
							</div>
						</div>
					</div>


					<frm:form action="actionsuaqlp" modelAttribute="phong"
						enctype="multipart/form-data">
						<!-- Modal sua -->
						<div class="modal fade" id="myModalsua${u.maPhong}" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">

										<h4 class="modal-title" style="font-weight: bold;">
											Fix the room code is<strong>${u.maPhong }</strong>
										</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<div class="modal-body">
										<frm:hidden path="maPhong" value="${u.maPhong }" />
										<frm:hidden path="trangThai" value="${u.trangThai }" />

										<input type="hidden" name="checktiennghi"
											value="${u.tienNghi }" />

										<div class="form-group">
											<label for="sophong" style="font-weight: bold;">Room
												number:</label>
											<frm:input path="soPhong" class="form-control input-sm"
												id="sophong" type="number" placeholder="Enter the room number"
												value="${u.soPhong }" oninput="checkMaxLenghtNumber(this,9)" />
										</div>

										<div class="form-group">
											<label for="tang" style="font-weight: bold;">Floor</label>
											<frm:input path="tang" class="form-control input-sm"
												id="tang" type="number" placeholder="Enter the floor number"
												value="${u.tang }" oninput="checkMaxLenghtNumber(this,2)" />
										</div>



										<div class="form-group">
											<label for="tienNghi" style="font-weight: bold;">Convenient:</label>
											<frm:label path="tienNghi" id="tienNghi"></frm:label>
											<br>
											<frm:checkbox id="dieuhoa${u.maPhong }" path="tienNghi"
												value="Air conditioning" label="  Điều hòa" />
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
											<frm:checkbox id="quat${u.maPhong }" path="tienNghi"
												value="Fan" label="  Quạt" />
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
											<frm:checkbox id="tivi${u.maPhong }" path="tienNghi"
												value="Television" label="  Tivi" />
											<br>

											<frm:checkbox id="nuocnonglanh${u.maPhong }" path="tienNghi"
												value="Hot and cold water" label="  Hot and cold water" />
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
											<frm:checkbox id="vitritot${u.maPhong }" path="tienNghi"
												value="The good place
" label="  The good place" />


											<script>
   <c:if test="${u.tienNghi.contains('Điều hòa')}">document.getElementById("dieuhoa${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Quạt')}">document.getElementById("quat${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Tivi')}">document.getElementById("tivi${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Nước nóng lạnh')}">document.getElementById("nuocnonglanh${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Vị trí tốt')}">document.getElementById("vitritot${u.maPhong }").checked = true;</c:if>
   

</script>
										</div>


										<div class="form-group">

											<label for="loaiPhong" style="font-weight: bold;">Kind
												of room:</label>
											<frm:select path="loaiPhong.maLoaiPhong"
												class="form-control input-sm" id="loaiPhong">
												<c:forEach items="${listLoaiPhong }" var="lp">
													<option value="${lp.maLoaiPhong }"
														label="${lp.tenLoaiPhong }"
														<c:if test="${u.loaiPhong.maLoaiPhong == lp.maLoaiPhong }">selected="selected"</c:if> />
												</c:forEach>
											</frm:select>

										</div>


										<div class="form-group">

											<label for="hinhAnh" style="font-weight: bold;">Picture:</label>
											<input type="file" class="form-control" id="file" name="file"
												accept=".jpg,.JPG,.png,.PNG" />
										</div>

										<div class="form-group">
											<label for="giaPhong" style="font-weight: bold;">Room
												Rates:</label>
											<frm:input path="giaPhong" class="form-control input-sm"
												id="giaPhong" type="number"
												placeholder="Enter the room rate" value="${u.giaPhong }"
												oninput="checkMaxLenghtNumber(this,12)" />
										</div>

										<div class="form-group">
											<label for="giaPhongGioDau" style="font-weight: bold;">Room
												rates first hour:</label>
											<frm:input path="giaPhongGioDau"
												class="form-control input-sm" id="giaPhongGioDau"
												type="number" placeholder="Enter the room rate first hour"
												value="${u.giaPhongGioDau }"
												oninput="checkMaxLenghtNumber(this,12)" />
										</div>

										<div class="form-group">
											<label for="giaPhongGioSau" style="font-weight: bold;">Room
												rates next hour:</label>
											<frm:input path="giaPhongGioSau"
												class="form-control input-sm" id="giaPhongGioSau"
												type="number"
												placeholder="Enter the room rate for the next hour"
												value="${u.giaPhongGioSau }"
												oninput="checkMaxLenghtNumber(this,12)" />
										</div>

										<div class="form-group">
											<label for="giaHomestay" style="font-weight: bold;">Homestay
												price:</label>
											<frm:input path="giaHomestay" class="form-control input-sm"
												id="giaHomestay" type="number"
												placeholder="Enter the homestay price"
												value="${u.giaHomestay }"
												oninput="checkMaxLenghtNumber(this,12)" />
										</div>

										<div class="form-group">

											<label for="khuyenMai" style="font-weight: bold;">Discount:</label>
											<frm:input path="khuyenMai" class="form-control input-sm"
												id="khuyenMai" type="number"
												placeholder="Enter a discount percentage" min="0" max="100"
												value="${u.khuyenMai }"
												oninput="checkMaxLenghtNumber(this,3)" />
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
			</tbody>
		</table>
	</div>

	<c:if test="${danhsach!=0}">
		<br>
		<ul class="pagination" id="pagination"
			style="float: right; box-shadow: 1px 1px 5px #888888;">
			<li class="page-item first"><a
				href="qlppage?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="qlppage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="qlppage?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="qlppage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="qlppage?data=${data }&page=${trangcuoi }" class="page-link">Last
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
				href="qlppagetim?data=${data }&page=${trangdau }" class="page-link">First
					page</a></li>
			<li class="page-item prev"><a
				href="qlppagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
				class="page-link"><</a></li>

			<c:forEach items="${listSoLuongTrang }" var="u">
				<li class="page-item"><a
					<c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
					href="qlppagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
			</c:forEach>

			<li class="page-item next"><a
				href="qlppagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
				class="page-link">></a></li>
			<li class="page-item last"><a
				href="qlppagetim?data=${data }&page=${trangcuoi }" class="page-link">Last
					page</a></li>
		</ul>
		<br>
		<br>
	</c:if>


	<script>
	 $(function () {        
    $('#file').change(function () {

        //because this is single file upload I use only first index
        var f = this.files[0]

        //here I CHECK if the FILE SIZE is bigger than 8 MB (numbers below are in bytes)
        if (f.size > 8388608 || f.fileSize > 8388608)
        {
           //show an alert to the user
           alert("Picture size exceeds the limit of 8 MB");

           //reset file upload control
           this.value = null;
        }
    })
});
</script>

</div>


