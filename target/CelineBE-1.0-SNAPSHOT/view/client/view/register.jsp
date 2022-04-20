<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%
    String alertMsg = (String) request.getAttribute("alert");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | Céline</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${url}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${url}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${url}/css/price-range.css" rel="stylesheet">
    <link href="${url}/css/animate.css" rel="stylesheet">
    <link href="${url}/css/main.css" rel="stylesheet">
    <link href="${url}/css/responsive.css" rel="stylesheet">
    <link href="${url}/css/login.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="${url}/images/home/celine_login.png"/>
</head><!--/head-->

<body>
<header id="header"><!--header-->
    <div class="header_inner">
        <div class="header_inner_left">
            <img src="${url}/images/home/celine_login.png" alt="" class="img">
            <p>Tạo tài khoản</p>
        </div>
        <div class="header_inner_right">
            Cần trợ giúp?
        </div>
    </div>

</header><!--/header-->
<div id="container" style="height:690px;">
    <div>.</div>
    <!--Form register-->
    <div id="auth-form-register" style="display:block;">
        <div class="auth-form__container">
            <div class="auth-form__header">
                <h3 class="auth-form__heading">
                    Đăng ký
                </h3>

            </div>
            <form id="form-regex" autocomplete="off" onsubmit="return(checkForm())" action="register" method="post">
                <%
                    if (alertMsg != null) {
                %>
                <p class="alert alert-danger" role="alert">
                    <%= alertMsg %>
                </p>
                <%
                    }
                %>
                <div class="auth-form__form">

                    <div class="auth-form__group">
                        <input type="text" class="auth-form__input" id="email" name="email" placeholder="Email">
                        <small>Error message</small>
                    </div>
                    <div class="auth-form__group">
                        <input type="text" class="auth-form__input" id="phone" name="username"
                               placeholder="Tên người dùng">
                        <small>Error message</small>
                    </div>
                    <div class="auth-form__group">
                        <input type="password" class="auth-form__input" id="password" name="password"
                               placeholder="Mật khẩu">
                        <small>Error message</small>
                    </div>
                    <div class="auth-form__group">
                        <input type="password" class="auth-form__input" id="re-password" name="re-password"
                               placeholder="Nhập lại mật khẩu">
                        <small>Error message</small>
                    </div>
                </div>

                <div class="auth-form__aside">
                    <p class="auth-form__policy-text">
                        Bằng việc đăng ký, bạn đã đồng ý với Céline về
                        <a href="" class="auth-form__text-link">Điều khoản dịch vụ</a>&
                        <a href="" class="auth-form__text-link">Chính sách bảo mật</a>
                    </p>
                </div>
                <div class="auth-form__controls">
                    <input type="button" class="btn auth-form__controls-back btn--normal"
                           onclick=location.href="${pageContext.request.contextPath }/login" value="TRỞ LẠI"></input>
                    <input type="submit" class="btn btn--primary" value="ĐĂNG KÝ"></input>
                </div>
            </form>
        </div>
        <div class="auth-form__socials">
            <a href="" class="auth-form__socials--facebook btn btn--size-s btn--with-icon">
                <i class="auth-form__socials-icon fab fa-facebook-square"></i>
                <span class="auth-form__socials-title">
                                 Facebook
                            </span>
            </a>
            <a href="" class="auth-form__socials--google btn btn--size-s btn--with-icon">
                <img src="${url}/images/home/google.png" alt="">
                <span class="auth-form__socials-title">
                                 Google
                            </span>
            </a>
        </div>
    </div>

</div>

<footer id="footer"><!--Footer-->
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="single-widget">
                        <h3>Chăm sóc khách hàng</h3>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Trung tâm trợ giúp</a></li>
                            <li><a href="#">Céline Blog</a></li>
                            <li><a href="#">Hướng dẫn mua hàng</a></li>
                            <li><a href="#">Thanh toán</a></li>
                            <li><a href="#">Vận chuyển</a></li>
                            <li><a href="#">Trả hàng & Hoàn tiền</a></li>
                            <li><a href="#">Chăm sóc khách hàng</a></li>
                            <li><a href="#">Chính sách bảo hành</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="single-widget">
                        <h3>Về Céline</h3>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Giới thiệu về Céline</a></li>
                            <li><a href="#">Tuyển dụng</a></li>
                            <li><a href="#">Điều khoản</a></li>
                            <li><a href="#">Chính sách bảo mật</a></li>
                            <li><a href="#">Chính hãng</a></li>
                            <li><a href="#">Flash sales</a></li>
                            <li><a href="#">Liên hệ với truyền thông</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="payment shipping_units">
                        <div class="big_title">
                            <h3>Thanh toán</h3>
                        </div>
                        <div class="sub_image">
                            <img class="" src="${url}/images/home/payment.png">
                        </div>
                    </div>
                    <div class="payment shipping_units">
                        <div class="big_title">
                            <h3>Đơn vị vận chuyển</h3>
                        </div>
                        <div class="sub_image">
                            <img id="ship_img" src="${url}/images/home/ship.jpg">
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="follow_on">
                        <div class="big_title">
                            <h3>Theo dõi chúng tôi</h3>
                        </div>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">
                                <div class="social_icon fab fa-facebook"></div>
                                Facebook</a></li>
                            <li><a href="#">
                                <div class="social_icon fab fa-twitter"></div>
                                Twitter</a></li>
                            <li><a href="#">
                                <div class="social_icon fab fa-instagram"></div>
                                Instagram</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row row_p2">
                <div class="col-sm-3">
                    <div class="end_titles">
                        <a href="">CHÍNH SÁCH BẢO MẬT</a>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="end_titles">
                        <a href="">QUY CHẾ HOẠT ĐỘNG</a>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="end_titles">
                        <a href="">CHÍNH SÁCH VẬN CHUYỂN</a>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="end_titles">
                        <a href="">CHÍNH SÁCH TRẢ HÀNG VÀ HOÀN TIỀN</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer-widget">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <div class="dk_banquyen">
                        <img class="ban_quyen" src="${url}/images/home/img/bocongthuong/bo-cong-thuong.svg">
                        <img class="ban_quyen" src="${url}/images/home/img/bocongthuong/bocongthuong.jpg">
                    </div>
                </div>
            </div>
            <div class="row text-center">
                <div class="big_title">
                    <h3>Cửa hàng Céline</h3>
                    <div class="sub_title">
                        <p class="txt_style">Địa chỉ: Khu phố 6, phường Linh Trung, quận Thủ Đức, TP Hồ chí Minh, Việt
                            Nam</p>
                        <p class="txt_style">Tổng đài hỗ trợ: 0342111202 - Email:celine_shop@gmail.com</p>
                        <p class="txt_style">Mã số doanh nghiệp: 0106773786 do Sở Kế hoạch & Đầu tư TP Hồ Chí Minh cấp
                            lần đầu ngày 01/11/2019</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer-bottom">
        <div class="container text-center">
            <div class="row">
                <p>Copyright © Bản quyền thuộc về cửa hàng Céline</p>
            </div>
        </div>
    </div>
</footer><!--/Footer-->
<script src="${url}/js/html5shiv.js"></script>
<script src="${url}/js/respond.min.js"></script>
<script src="${url}/js/register.js"></script>
</body>
</html>