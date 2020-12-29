<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.class-thao-tac {
	text-decoration: none;
}

.class-thao-tac:hover {
	text-decoration: none;
	text-shadow: 1px 1px 1px #888888;
	font-weight: bold;
}

.hovera {
	text-decoration: none;
	color: black;
}

.hovera:hover {
	text-decoration: none;
	color: black;
	text-shadow: 1px 1px 1px #888888;
}

.margin-status {
cursor: pointer;
margin-right: 30px;
margin-left: 30px;
}
.margin-status:hover {
text-shadow:0px 0px 1px black;
}
.active-status {
color:brown;
}
.active-status:hover {
text-shadow:0px 0px 1px brown;
}
.sizebtn {
cursor: pointer;
padding: 1px; 
padding-left: 10px; 
padding-right: 10px;
}

@media (max-width: 1320px) {
	.margin-status {
cursor: pointer;
margin-right: 4px;
margin-left: 4px;
font-size: 12px;
}
.sizebtn {
font-size: 16px;
cursor: pointer;
padding: 1px; 
padding-left: 10px; 
padding-right: 10px;
}
}

.st-tang {
color: white; 
position: absolute; 
right: 215px; 
margin-top: 13px; 
font-size: 30px
}
@media (max-width: 991px) {
.st-tang {
color: white; 
position: absolute; 
right: 215px; 
margin-top: 17px; 
font-size: 25px
}
.margin-status {
    cursor: pointer;
    margin-right: 30px;
    margin-left: 30px;
    font-size: 13px;
}


.sizebtn {
font-size: 16px;
cursor: pointer;
padding: 1px; 
padding-left: 10px; 
padding-right: 10px;
width: 100%
}
}

@media (max-width: 768px) {
	.margin-status {
cursor: pointer;
margin-right: 20px;
margin-left: 20px;
font-size: 13px;
}
.sizebtn {
font-size: 16px;
cursor: pointer;
padding: 1px; 
padding-left: 10px; 
padding-right: 10px;
width: 100%;
}
}


</style>
<div class="container">
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>${message }</strong>
		</div>
	</c:if>
	<div class="container contaiStatus">
		<span style="opacity: 1;"><span onclick="dptppck()" class="margin-status ${activedptppck }"><b>Room with guests: </b>${phongCoKhach}</span>
		<span onclick="dptppt()" class="margin-status ${activedptppt }"><b>Empty room: </b>${phongTrong}</span>
		<span onclick="dptppdt()" class="margin-status ${activedptppdt }"><b>Room reservation: </b>${phongDatTruoc}</span>
		<span onclick="dptptong()" class="margin-status ${activedptptong }"><b>Total: </b>${tongPhong}</span></span>
	
	<button class="btn btn-success btn-xs float-right sizebtn" onclick="dsdattruoc()">See the full list of reservations</button>
	</div>
</div>
<div class="container" style="height: auto; margin-top: 20px;">
	<c:forEach var="i" items="${ltang }">
		<div style="width: 100%">
			<div style="width: 100%; height: 80px;">
				<img align="right" style="-webkit-filter: drop-shadow(1px 1px 2px #888888); filter: drop-shadow(1px 1px 2px #888888); margin-bottom: 10px;" src='hinh/title tang.png' width="450px" height="70px">
				<div class="st-tang">
					<b>Floors ${i }</b>
				</div>
			</div>
			<div style="clear: both; width: 100%;">
				<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888; width: 100%;">
					<c:forEach var="u" items="${l }">
						<c:if test="${i==u.tang }">
							<div class="hovera itemdptp"
								onclick="showThaoTac(${u.maPhong})"
							>
								<c:if test="${u.countDatLich > 0 }">
									<img style="-webkit-filter: drop-shadow(1px 1px 2px #888888); filter: drop-shadow(1px 1px 2px #888888); z-index: 9999; position: absolute;" src='hinh/calendaricon.png' width="40px"
										height="40px"
									>
									<span style="position: absolute; z-index: 9999; margin-top: 13px;color: cornflowerblue;text-align: center;font-weight: 1000;width: 40px;height: 26px;"><b>${u.countDatLich}</b></span>
								</c:if>
								<img class="icondptp"
									src='<c:if test="${u.trangThai==0 }">hinh/homegreen.png</c:if><c:if test="${u.trangThai==1 }">hinh/homered.png</c:if><c:if test="${u.trangThai==2 }">hinh/homecam.png</c:if>'>
								<div id="thongtin-${u.maPhong}" class="thongtin ${u.trangThai==2?'thongtintt2':'thongtinttk2'}">
									<div>
										<b>Room: </b>${u.soPhong }</div>
									<div>
										<b>Type: </b>
										<c:if test="${u.loaiPhong.tenLoaiPhong=='VIP'}">
											<img src="hinh/vip.png" width="55px" height="23px" style="margin-bottom: 5px; -webkit-filter: drop-shadow(1px 1px 1px #fff0b6); filter: drop-shadow(1px 1px 1px #fff0b6);"></img>
										</c:if>
										<c:if test="${u.loaiPhong.tenLoaiPhong!='VIP'}">${u.loaiPhong.tenLoaiPhong}</c:if>
									</div>
									<div>
										<b>Cost: </b>
										<fmt:formatNumber type="number" pattern="###,###" value="${u.giaPhong}" />
										$
									</div>
									<div>
										<b>Discount: </b>${u.khuyenMai } %
									</div>
									<c:if test="${u.trangThai==2}">
										<div>
											<b>Amount of people: </b>${u.countHomestay }
										</div>
									</c:if>
								</div>
								<div id="thaotac-${u.maPhong}" class="thaotac">
									<c:if test="${u.trangThai==0}">
										<div>
											<a class="class-thao-tac" href="actionclickdptp?maPhong=${u.maPhong }&trangThai=${u.trangThai }&soPhong=${u.soPhong }">Rent normal</a>
										</div>
										<div>
											<a class="class-thao-tac" href="homestay?maPhong=${u.maPhong }&trangThai=${u.trangThai }&soPhong=${u.soPhong }">HomeStay</a>
										</div>
										<div>
											<a class="class-thao-tac" href="dslichdatphong?maPhong=${u.maPhong }&soPhong=${u.soPhong }">Book</a>
										</div>
									</c:if>
									<c:if test="${u.trangThai==1}">
										<div>
											<a class="class-thao-tac" href="actionclickdptp?maPhong=${u.maPhong }&trangThai=${u.trangThai }&soPhong=${u.soPhong }">Rent normal</a>
										</div>
										<div>
											<a class="class-thao-tac" href="dslichdatphong?maPhong=${u.maPhong }&soPhong=${u.soPhong }">Book</a>
										</div>
									</c:if>
									<c:if test="${u.trangThai==2}">
										<div>
											<a class="class-thao-tac" href="homestay?maPhong=${u.maPhong }&trangThai=${u.trangThai }&soPhong=${u.soPhong }">Homestay</a>
										</div>
										<div>
											<a class="class-thao-tac" href="dslichdatphong?maPhong=${u.maPhong }&soPhong=${u.soPhong }">Book</a>
										</div>
									</c:if>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<script type="text/javascript" src="/js/dptp.js"></script>
