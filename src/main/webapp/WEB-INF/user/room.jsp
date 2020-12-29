<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="w3l-breadcrumb">
	<div class="breadcrum-bg py-sm-5 py-4">
		<div class="container py-lg-3">

			<h2>Rooms</h2>
			<p><a href="${pageContext.request.contextPath }/home">Home</a> &nbsp; / &nbsp; Rooms</p>

		</div>
	</div>
</section>

<div class="best-rooms w3l-blog py-5">
	<div class="container py-lg-5 py-sm-4">
		<div class="ban-content-inf row">
			<c:forEach items="${listRoom}" var="room">
				<div class="maghny-gd-1 col-lg-4 col-md-6" >
					<div class="maghny-grid">
						<figure class="effect-lily">
							<img class="img-fluid" src="images/about1.jpg" alt="">
							<figcaption>
								<div>
									<h4 class="top-text">
										Number :
											${room.soPhong}
									</h4>
									<p>Book for ${room.giaPhong}</p>
								</div>
							</figcaption>
						</figure>
						<div class="room-info">
							<h3 class="room-title">
								<a href="/booking">${room.loaiPhong.tenLoaiPhong}</a>
							</h3>
							<p>${room.tienNghi}</p>
							<a href="/booking?roomCode=${room.maPhong}" class="btn mt-sm-4 mt-3" style="color: orange;">Book Now</a>
							<div class="room-info-bottom">
								<ul class="room-amenities">
									<li><a href="#url"><span class="fa fa-bed" title="Beds"></span></a></li>
									<li><a href="#url"><span class="fa fa-television"
															 title="Television"></span></a></li>
									<li><a href="#url"><span class="fa fa-bath"
															 title="Private Bathroom"></span></a></li>
									<li><a href="#url"><span class="fa fa-motorcycle"
															 title="Bike Rental"></span></a></li>
								</ul>
								<a href="/room?roomType=${room.loaiPhong.tenLoaiPhong}" class="btn view">Full Info</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
