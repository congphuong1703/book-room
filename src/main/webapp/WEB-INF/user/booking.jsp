<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<section class="w3l-booking-top">
    <!-- /form-16-section -->
    <div class="booking-form-61">
        <div class="container">
            <div class="booking-top-gds">
                <div class="booking-forms-16-info align-self">
                    <h5>Your Reservation</h5>
                    <h3 class="title-big">Select the Room, check for availability and book it.</h3>

                </div>
                <div class="form-right-inf">
                    <div class="booking-form-content">
                        <h6>Book Now</h6>
                        <form:form action="/booking" modelAttribute="bookingDTO" class="book-depature-6 signin-form"
                                   method="post">
                            <div class="d-grid grid-col-2">
                                <div class="hny-frm_grid">
                                    <h5>Name</h5>
                                    <form:input path="name" name="name" type="text" placeholder="Your Name"
                                                required=""></form:input>
                                </div>
                                <div class="hny-frm_grid">
                                    <h5>Phone Number</h5>
                                    <form:input path="phoneNumber" name="phoneNumber" type="text"
                                                placeholder="Phone Number"
                                                required=""></form:input>
                                </div>
                                <div class="hny-frm_grid">
                                    <h5>Email</h5>
                                    <form:input path="email" name="email" type="email" placeholder="Email"
                                                required=""></form:input>
                                </div>
                                <div class="hny-frm_grid">
                                    <h5>Check-in Date</h5>
                                    <form:input path="checkInDate" name="checkInDate" type="date"
                                                placeholder="Check In Date" required=""></form:input>
                                </div>
                                <div class="hny-frm_grid">
                                    <h5>Check-out Date</h5>
                                    <form:input path="checkOutDate" name="checkOutDate" type="date"
                                                placeholder="Check Out Date" required=""></form:input>
                                    <form:input path="roomCode" name="roomCode" type="hidden"
                                                placeholder="Room Code"></form:input>
                                </div>
                                <div class="hny-frm_grid">
                                    <h5>Type Room</h5>
                                    <form:select path="roomType" name="roomType" required="">
                                        <form:option value="VIP">VIP</form:option>
                                        <form:option value="Thường">Thường</form:option>
                                        <form:option value="Homestay">Homestay</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <input type="submit" class="btn btn-style btn-secondary book mt-3"
                                   style="background:#f57b51;color:#fff" value="Book Now"/>
                            <p class="already">You are booking as guest.</p>
                            <p class="already" style="color: red">${error}</p>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>