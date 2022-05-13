<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 4/5/2022
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Contact | Céline</title>
    <link href="${url}/css/all.min.css" rel="stylesheet">
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${url}/css/fontawesome.min.css" rel="stylesheet">
    <link href="${url}/css/fontawesome.css" rel="stylesheet">
    <link href="${url}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${url}/css/price-range.css" rel="stylesheet">
    <link href="${url}/css/animate.css" rel="stylesheet">
    <link href="${url}/css/main.css" rel="stylesheet">
    <link href="${url}/css/responsive.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="${url}/images/home/celine_login.png"/>
    <link href="${url}/css/contact-us.css" rel="stylesheet">
    <!--[if lt IE 9]>

    <![endif]-->
</head><!--/head-->

<body>
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<div id="contact-page" class="container">
    <div class="row align-items-stretch no-gutters contact-wrap">
        <div class="col-md-8 col-sm-12">
            <div class="form h-100">
                <h3>Liên hệ với chúng tôi</h3>
                <form class="mb-5" id="contactForm" name="contactForm">
                    <div class="row">
                        <div class="col-md-6 form-group mb-5">
                            <label class="col-form-label">Họ và tên *</label>
                            <input type="text" class="form-control" name="name" id="name"
                                   placeholder="Nhập tên của bạn" required>
                        </div>
                        <div class="col-md-6 form-group mb-5">
                            <label class="col-form-label">Email *</label>
                            <input type="email" class="form-control" name="email" id="email"
                                   placeholder="Nhập email của bạn" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group mb-5">
                            <label class="col-form-label">Tiêu đề</label>
                            <input type="text" class="form-control" name="phone" id="phone" placeholder="Tiêu đề">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group mb-5">
                            <label for="message" class="col-form-label">Nội dung *</label>
                            <textarea class="form-control" name="message" id="message" cols="30" rows="4"
                                      placeholder="Nhập nội dung" required></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input type="submit" value="Gửi" class="btn rounded-0 py-2 px-4">
                            <span class="submitting"></span>
                        </div>
                    </div>
                </form>

                <!--                <div id="form-message-warning mt-4"></div>-->
                <!--                <div id="form-message-success">-->
                <!--                    Your message was sent, thank you!-->
                <!--                </div>-->

            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="contact-info h-100">
                <div class="row">
                    <h3>Thông tin liên hệ</h3>
                    <p class="mb-5">Cửa hàng Céline - nơi mua sắm uy tín của mọi người!</p>
                    <ul class="list-unstyled">
                        <li class="d-flex">
                            <span class="wrap-icon fas fa-map-marked-alt mr-3"></span>
                            <span class="text">Khu phố 6, phường Linh Trung, quận Thủ Đức, TP Hồ chí Minh, Việt
                            Nam</span>
                        </li>
                        <li class="d-flex">
                            <span class="wrap-icon fas fa-phone-square mr-3"></span>
                            <span class="text">+84342111202</span>
                        </li>
                        <li class="d-flex">
                            <span class="wrap-icon fas fa-envelope mr-3"></span>
                            <span class="text">celine_shop@gmail.com</span>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <h3>Mạng xã hội</h3>
                    <ul class="social-networks">
                        <li><a href="#"><img src="${url}/images/home/face.png" alt="Facebook"></a>
                        </li>

                        <li><a href="#"><img src="${url}/images/home/google_contact.png" alt="Google"></a>
                        </li>

                        <li><a href="#"><img src="${url}/images/home/instar_contact.png" alt="Instagram"></a>
                        </li>

                        <li><a href="#"><img src="${url}/
            images/home/twitter_contact.png" alt="Twtter"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div><!--/#contact-page-->

<jsp:include page="/view/client/view/footer.jsp"></jsp:include>

<jsp:include page="/view/client/view/facebook_noti.jsp"></jsp:include>

<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="${url}/js/gmaps.js"></script>
<script src="${url}/js/contact.js"></script>
<script src="${url}/js/price-range.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/html5shiv.js"></script>
<script src="${url}/js/respond.min.js"></script>
</body>
</html>