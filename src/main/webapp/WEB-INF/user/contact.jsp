<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <section class="w3l-contact-1 py-5">
    <div class="contacts-9 py-lg-5 py-sm-4">
        <div class="container">
            <div class="d-grid contact-view">
                <div class="cont-details">
                    <p>Get in touch</p>
                    <h3 class="title-big">Contact and Access</h3>
                </div>
                <div class="map-content-9">
                    <p>Officially opened in December 2019, Hotel Homie Saigon, MGallery Collection is located 
                    in the heart of Ho Chi Minh's most vibrant district, just away from Notre Dame Cathedral, Opera House,
                     Central Post Office. history and other key tourist attractions a few kilometers. The hotel is just 20 
                     minutes drive from Tan Son Nhat international Airport.</p>
                </div>
            </div>
            <div class="map-iframe my-5">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.0132881793916!2d106.7151158151533!3d10.810293792298513!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752898ab8dae13%3A0x919950adb1ba27a8!2zMjczIMSQLiBOZ3V54buFbiBHaWEgVHLDrSwgUGjGsOG7nW5nIDI1LCBCw6xuaCBUaOG6oW5oLCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmggNzAwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1607707271941!5m2!1svi!2s"
                    width="100%" height="300" frameborder="0" style="border: 0px; pointer-events: none;"
                    allowfullscreen=""></iframe>
            </div>
            <div class="d-grid contact-view">
                <div class="cont-details">
                    <div class="cont-top">
                        <div class="cont-left text-center">
                            <span class="fa fa-phone text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Call Us</h6>
                            <p><a href="tel:+44 99 555 42">+84 123 456 789</a></p>
                        </div>
                    </div>
                    <div class="cont-top margin-up">
                        <div class="cont-left text-center">
                            <span class="fa fa-envelope-o text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Email Us</h6>
                            <p><a href="mailto:example@mail.com" class="mail">HomieHotel@mail.com</a></p>
                        </div>
                    </div>
                    <div class="cont-top margin-up">
                        <div class="cont-left text-center">
                            <span class="fa fa-map-marker text-primary"></span>
                        </div>
                        <div class="cont-right">
                            <h6>Address</h6>
                            <p>Address here, 273 Nguyen Gia Tri, Ward
									25, Binh Thanh District, Ho Chi Minh City.</p>
                        </div>
                    </div>
                </div>
                <div class="map-content-9 mt-lg-0 mt-4">
                    <form  method="post" action="sendMail.com">
                        <div class="twice-two">
                            <input type="text" class="form-control" name="Name" id="Name" placeholder="Name"
                                required="">
                            <input type="email" class="form-control" name="Sender" id="Sender" placeholder="Email"
                                required="">
                        </div>
                        <div class="twice">
                            <input type="text" class="form-control" name="Subject" id="Subject"
                                placeholder="Subject" required="">
                        </div>
                        <textarea name="w3lMessage" class="form-control" id="Message" placeholder="Message"
                            required=""></textarea>
                        <button type="submit" class="btn btn-contact">Send Message</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>