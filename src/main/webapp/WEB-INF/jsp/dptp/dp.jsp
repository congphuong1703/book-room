<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container" style="min-height: 690px;; margin-top: 15px">
	<div
		style="width: 43%; float: left; box-shadow: 1px 1px 2px #888888; border-radius: .40rem;">
		<table class="table" style="font-size: 15px;">
			<tbody>
				<tr>
					<th style="vertical-align: middle;">Picture</th>
					<td style="vertical-align: middle;"><img alt=""
						id="myImg${thongtinphong.maPhong }"
						src="hinh/phong/${thongtinphong.hinhAnh }" width="60px"
						height="60px"></td>
				</tr>
				<tr>
					<th>Room ID</th>
					<td>${thongtinphong.maPhong }</td>
				</tr>
				<tr>
					<th>Room number</th>
					<td>${thongtinphong.soPhong }</td>
				</tr>
				<tr>
					<th>Room type</th>
					<td><c:if
							test="${thongtinphong.loaiPhong.tenLoaiPhong=='VIP'}">
							<img src="hinh/vip.png" width="55px" height="23px"
								style="margin-bottom: 5px; -webkit-filter: drop-shadow(1px 1px 1px #888888); filter: drop-shadow(1px 1px 1px #888888);"></img>
						</c:if> <c:if test="${thongtinphong.loaiPhong.tenLoaiPhong!='VIP'}">${thongtinphong.loaiPhong.tenLoaiPhong}</c:if></td>
				</tr>
				<tr>
					<th>Floors</th>
					<td>${thongtinphong.tang }</td>
				</tr>
				<tr>
					<th>Convenient</th>
					<td>${thongtinphong.tienNghi }</td>
				</tr>
				<tr>
					<th>Room Rates</th>
					<td><fmt:formatNumber type="number" pattern="###,###"
							value="${thongtinphong.giaPhong }" /> $</td>
				</tr>
				<tr>
					<th>Room rates first hour</th>
					<td><fmt:formatNumber type="number" pattern="###,###"
							value="${thongtinphong.giaPhongGioDau }" /> $</td>
				</tr>
				<tr>
					<th>Room rates next hour</th>
					<td><fmt:formatNumber type="number" pattern="###,###"
							value="${thongtinphong.giaPhongGioSau }" /> $</td>
				</tr>
				<tr>
					<th>Discout</th>
					<td>${thongtinphong.khuyenMai }%</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="breadcrumb"
		style="box-shadow: 1px 1px 5px #888888; width: 55%; float: right;">
		<frm:form action="themddp" modelAttribute="datphong">
			<frm:hidden path="phong.maPhong" value="${maPhong }" />
			<frm:hidden path="tenDangNhap" value="${nguoidung }" />
			<div class="form-group">
				<label for="hoTen" style="font-weight: bold;">Full Name:</label>
				<frm:input id="hoTen" class="form-control" path="hoTen"
					placeholder="Import fullName" required="required" maxlength="100" />
			</div>
			<div class="form-group">
				<label for="soDT" style="font-weight: bold;">Phone number:</label>
				<frm:input id="soDT" type="number" class="form-control" path="soDT"
					placeholder="Import phone number"
					oninput="checkMaxLenghtNumber(this,15)" required="required" />
			</div>
			<div class="form-group">
				<label for="soCMND" style="font-weight: bold;">Identity card number:</label>
				<frm:input id="soCMND" type="number" class="form-control"
					path="soCMND" placeholder="Import identity card number"
					oninput="checkMaxLenghtNumber(this,20)" required="required" />
			</div>
			<div class="form-group">
				<label for="loaiDat" style="font-weight: bold;">Room charged by: </label>
				<frm:select class="form-control" id="loaiDat" path="loaiDat">
					<frm:option value="theogio">Hours</frm:option>
					<frm:option value="theongay">Days</frm:option>
				</frm:select>
			</div>
			<div class="form-group">
				<label for="tienCoc" style="font-weight: bold;">Deposit:</label>
				<frm:input id="tienCoc" type="number" class="form-control"
					path="tienCoc" placeholder="Import deposit" required="required"
					oninput="checkMaxLenghtNumber(this,12)" />
			</div>
			<div class="form-group">
				<label for="gioDat" style="font-weight: bold;">Time set:</label>
				<frm:input id="gioDat" class="form-control" path="gioDat"
					type="time" value="${giohientai }" required="required" />
			</div>
			<div class="form-group">
				<label for="ngayDat" style="font-weight: bold;">Date of booking:</label>
				<frm:input id="ngayDat" class="form-control" path="ngayDat"
					type="date" value="${ngayhientai }" max="9999-12-31" 
					required="required" />
			</div>
			<frm:button type="submit" class="btn btn-success btn-xs float-right">Confirm</frm:button>
		</frm:form>
	</div>
</div>
<style>
#myImg ${thongtinphong .maPhong
	
}

{
border-radius
:
5px
;


cursor
:pointer
;


transition
:
0
.3s
;


}
#myImg ${thongtinphong .maPhong
	
}

:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal ${thongtinphong .maPhong
	
}

{
display
:none
; /* Hidden by default */


position
:fixed
; /* Stay in place */


z-index
:
1
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
:auto
; /* Enable scroll if needed */


background-color
:rgb
(
0
,
0
,
0
)
; /* Fallback color */


background-color
:rgba
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
.modal ${thongtinphong .maPhong
	
}

-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption ${thongtinphong .maPhong
	
}

{
margin
:auto
;


display
:block
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
:center
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
.modal ${thongtinphong .maPhong
	
}

-content, #caption ${thongtinphong .maPhong
	
}

{
-webkit-animation-name
:zoom
;


-webkit-animation-duration
:
0
.6s
;


animation-name
:zoom
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
.close ${thongtinphong .maPhong
	
}

{
position
:absolute
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
:bold
;


transition
:
0
.3s
;


}
.close ${thongtinphong .maPhong
	
}

:hover, .close ${thongtinphong .maPhong
	
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
<div id="myModal${thongtinphong.maPhong}"
	class="modal${thongtinphong.maPhong}">
	<span class="close${thongtinphong.maPhong}">&times;</span> <img
		class="modal${thongtinphong.maPhong}-content"
		id="${thongtinphong.maPhong}">
	<div id="caption${thongtinphong.maPhong}"></div>
</div>
<!-- script image -->
<script>
	// Get the modal
	var modal = document.getElementById('myModal${thongtinphong.maPhong}');

	// Get the image and insert it inside the modal - use its "alt" text as a caption
	var img = document.getElementById('myImg${thongtinphong.maPhong}');
	var modalImg = document.getElementById("${thongtinphong.maPhong}");
	var captionText = document
			.getElementById("caption${thongtinphong.maPhong}");
	img.onclick = function() {
		modal.style.display = "block";
		modalImg.src = this.src;
		captionText.innerHTML = this.alt;
	}

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close${thongtinphong.maPhong}")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
</script>
