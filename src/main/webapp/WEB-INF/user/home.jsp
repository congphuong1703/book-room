<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="w3l-main-slider" id="home">
	<div class="companies20-content">
		<div class="owl-one owl-carousel owl-theme">
			<div class="item">
				<li>
					<div class="slider-info banner-view bg bg2">
						<div class="banner-info">
							<div class="container">
								<div class="banner-info-bg">
									<h5>Location is heavenly. Best to visit in week days to
										enjoy the peaceful beauty</h5>
									<a class="btn btn-style transparent-btn mt-sm-5 mt-4"
									   href="service"> Our Services</a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</div>
			<div class="item">
				<li>
					<div class="slider-info  banner-view banner-top1 bg bg2">
						<div class="banner-info">
							<div class="container">
								<div class="banner-info-bg">
									<h5>Our new hotels will play a leading role in prompting
										the world peace.</h5>
									<a class="btn btn-style transparent-btn mt-sm-5 mt-4"
									   href="service"> Our Services</a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</div>
			<div class="item">
				<li>
					<div class="slider-info banner-view banner-top2 bg bg2">
						<div class="banner-info">
							<div class="container">
								<div class="banner-info-bg">
									<h5>Most hotels train their people with the booklets. We
										take ours to the ballet.</h5>
									<a class="btn btn-style transparent-btn mt-sm-5 mt-4"
									   href="service"> Our Services</a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</div>
			<div class="item">
				<li>
					<div class="slider-info banner-view banner-top3 bg bg2">
						<div class="banner-info">
							<div class="container">
								<div class="banner-info-bg">
									<h5>Good tourism will follow good hotels. Experience our
										luxury hotel rooms</h5>
									<a class="btn btn-style transparent-btn mt-sm-5 mt-4"
									   href="service"> Our Services</a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</div>
		</div>
	</div>
</section>
<!-- /main-slider -->
<section class="w3l-availability-form" id="booking">
	<!-- /w3l-availability-form-section -->
	<div class="w3l-availability-form-main py-5">
		<div class="container pt-lg-3 pb-lg-5">
			<div class="forms-top">
				<div class="form-right">
					<div class="form-inner-cont">
						<h3 class="title-small">Check Availability</h3>
						<form:form action="/search-available" method="get"
								   class="signin-form" >
							<div class="row book-form">
								<div class="form-input col-md-4 col-sm-6 mt-3">
									<label>Check-in Date</label>
									<input type="date" name="checkInDate" placeholder="Date"
										   required=""/>
								</div>
								<div class="form-input col-md-4 col-sm-6 mt-3">
									<label>Type Room</label>
									<select name="typeRoom" class="selectpicker" required >
										<option value="Select type room">Select type room</option>
										<option value="VIP">VIP</option>
										<option value="Thường">Thường</option>
										<option value="Homestay">Homestay</option>
									</select>

								</div>
								<div class="form-input col-md-4 col-sm-6 mt-3">
									<label>Price </label>
									<input type="number" name="maxPrice"
										   placeholder="Max Price ($)">
								</div>
								<div class="bottom-btn col-md-4 col-sm-6 mt-3">
									<label>Check availability </label>
									<input type="submit" class="btn btn-style btn-primary w-100 px-2" value="Check Availability"/>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- //w3l-availability-form-section -->
<!-- about -->
<section class="w3l-about py-5">
	<div class="container py-sm-4">
		<div class="row">
			<div class="col-lg-6 about-left mb-md-0 mb-5">
				<h3 class="title-big">Relax in our Resort</h3>
				<h5>We make the best for all our customers.</h5>
				<p class="mt-3">We will be happy to assist you anytime to enjoy
					the unique charm and atmosphere of this lovely hotel with balance
					and harmony. We invite you to explore the exciting array of fine
					amenities and facilities which are designed to enhance your
					experience. Hope you enjoy when you are in our hotel.</p>
				<a href="about.html" class="btn btn-style btn-primary mt-sm-5 mt-4">Learn
					About Us</a>
			</div>
			<div class="col-lg-6 about-right position-relative mt-lg-0 mt-5">
				<img
						src="images/top.jpg"
						alt="" class="img-fluid img-border mt-4"/> <img
					src="images/bottom.jpg"
					alt="" class="img-fluid position-absolute img-position"/>
			</div>
		</div>
	</div>
</section>
<!-- //about -->
<div class="best-rooms py-5">
	<div class="container py-lg-5 py-sm-4">
		<h3 class="title-big text-center">Best Rooms</h3>
		<div class="ban-content-inf row py-lg-3">
			<div class="maghny-gd-1 col-lg-6">
				<div class="maghny-grid">
					<figure class="effect-lily">
						<img class="img-fluid"
							 src="images/room1.jpg"
							 alt="">
						<figcaption class="w3set-hny">
							<div>
								<h4 class="top-text">
									Homie Hotel and Best Resort <span>Peaceful Place to stay</span>
								</h4>
								<p>From 20$</p>
							</div>
						</figcaption>
					</figure>
					<div class="room-info">
						<h3 class="room-title">
							<a href="room-single.html">Homie Hotel</a>
						</h3>
						<ul class="mb-3">
							<li><span class="fa fa-users"></span> 2 Guests</li>
							<li><span class="fa fa-bed"></span> Double bed</li>
							<li><span class="fa fa-bed"></span> 15sqft</li>
						</ul>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. A
							recusandae, illum sequi numquam tempora voluptates?</p>
						<a href="#book" class="btn btn-style btn-primary mt-sm-4 mt-3">Book
							Now</a>
					</div>
				</div>
			</div>
			<div class="maghny-gd-1 col-lg-6 mt-lg-0 mt-4">
				<div class="row">
					<div class="maghny-gd-1 col-6">
						<div class="maghny-grid">
							<figure class="effect-lily border-radius">
								<img class="img-fluid"
									 src="images/room2.jpg"
									 alt=""/>
								<figcaption>
									<div>
										<h4>
											Family Rooms <span> Resort</span>
										</h4>
										<p>From 20$</p>
									</div>

								</figcaption>
							</figure>
						</div>
					</div>
					<div class="maghny-gd-1 col-6">
						<div class="maghny-grid">
							<figure class="effect-lily border-radius">
								<img class="img-fluid"
									 src="images/room3.jpg"
									 alt=""/>
								<figcaption>
									<div>
										<h4>
											Double Rooms <span> Resort</span>
										</h4>
										<p>From 20$</p>
									</div>

								</figcaption>
							</figure>
						</div>
					</div>
					<div class="maghny-gd-1 col-6 mt-4">
						<div class="maghny-grid">
							<figure class="effect-lily border-radius">
								<img class="img-fluid"
									 src="images/room4.jpg"
									 alt=""/>
								<figcaption>
									<div>
										<h4>
											Luxury Rooms <span> Resort</span>
										</h4>
										<p>From 20$</p>
									</div>

								</figcaption>
							</figure>
						</div>
					</div>
					<div class="maghny-gd-1 col-6 mt-4">
						<div class="maghny-grid">
							<figure class="effect-lily border-radius">
								<img class="img-fluid"
									 src="images/room5.jpg"
									 alt=""/>
								<figcaption>
									<div>
										<h4>
											Resort Rooms <span> Resort</span>
										</h4>
										<p>From 20$</p>
									</div>

								</figcaption>
							</figure>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<section class="w3l-index3">
	<div class="midd-w3 py-5">
		<div class="container py-lg-5 py-md-3">
			<div class="row">
				<div class="col-lg-6 left-wthree-img text-righ">
					<div class="position-relative">
						<img
								src="images/videobg.jpg"
								alt="" class="img-fluid"/> <a href="#small-dialog"
															  class="popup-with-zoom-anim play-view text-center position-absolute">
					</a>

					</div>
				</div>
				<div class="col-lg-6 mt-lg-0 mt-5 about-right-faq align-self">
					<h6>Discover our Locations</h6>
					<h3 class="title-big">1 Years of Hotels and Resort Experience</h3>
					<p class="mt-3"></p>
					<ul class="w3l-right-book mt-4">
						<li><span class="fa fa-check" aria-hidden="true"></span>We
							make the best for all our customers
						</li>
						<li><span class="fa fa-check" aria-hidden="true"></span>Follow
							our Resort Luxury Hotels
						</li>
						<li><span class="fa fa-check" aria-hidden="true"></span>Luxury
							hotels and best resorts
						</li>
						<li><span class="fa fa-check" aria-hidden="true"></span>Double
							rooms and family rooms
						</li>
						<li><span class="fa fa-check" aria-hidden="true"></span>Enjoy
							a luxury experience
						</li>
					</ul>
					<a href="about"
					   class="btn btn-style btn-primary mt-4">Check all packages</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- quotation -->
<div class="quotation py-5">
	<div class="container py-xl-5 py-lg-3">
		<div class="welcome-left text-center py-md-5 py-3">
			<h3>Enjoy a Luxury experience. Discover our locaions. Relax and
				enjoy your holiday</h3>
			<a href="booking"
			   class="btn btn-style transparent-btn mt-sm-5 mt-4 mr-2">Book Now</a>
			<a href="contact" class="btn btn-style btn-primary mt-sm-5 mt-4">Contact
				Us</a>
		</div>
	</div>
</div>
<!-- //quotation -->

<section class="w3l-logos py-5">
	<div class="container py-lg-3">
		<div class="row">
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view">
				<img
						src="images/logo1.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view">
				<img
						src="images/logo2.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view mt-sm-0 mt-4">
				<img
						src="images/logo3.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view mt-md-0 mt-4">
				<img
						src="images/logo4.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view mt-lg-0 mt-4">
				<img
						src="images/logo2.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-4 col-6 logo-view mt-lg-0 mt-4">
				<img
						src="images/logo1.jpg"
						alt="company-logo" class="img-fluid"/>
			</div>
		</div>
	</div>
</section>