<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 3/29/2022
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/view/client/static" var="url"></c:url>
<header id="header"><!--header-->
    <div class="header-middle"><!--header-middle-->
        <!--Logo và login account...-->

        <div class="banner__header">
            <div class="row">
                <div>
                    <div id="countdown">
                        <h1>F <i class="fas fa-bolt"></i>ash sale</h1>
                        <div class="countdown-container">
                            <div class="cont-el days-c">
                                <p class="big-text" id="days">0</p>
                                <span>ngày</span>
                            </div>
                            <div class="cont-el hours-c">
                                <p class="big-text" id="hours">0</p>
                                <span>giờ</span>
                            </div>
                            <div class="cont-el mins-c">
                                <p class="big-text" id="mins">0</p>
                                <span>phút</span>
                            </div>
                            <div class="cont-el secondss-c">
                                <p class="big-text" id="seconds">0</p>
                                <span>giây</span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <input type="date" class="date" id="date" style="display:none;">
                    </div>
                </div>
            </div>
        </div>
        <div class="middle">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><a href="../../../index.html" class="active">Trang Chủ</a></li>
                                <li><a href="../../../shop.html">Sản Phẩm</a></li>


                                <li class="dropdown"><a href="../../../blog.html">Blog</a>
                                </li>
                                <li><a href="../../../contact-us.html">Liên Hệ</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="shop-menu pull-right col-sm-6">
                        <ul class="nav navbar-nav">
                            <li><a href="../../../help.html" target="_blank" class="text"><i class="far fa-question-circle"></i> Trợ Giúp</a></li>
                            <li  id="notify" class="text">
                                <i class="far fa-bell"></i>
                                <span class="header-notify text">Thông Báo</span>
                                <div class="header-notify-text">
                                    <img src="${url}/images/home/cuteoops.jpg" class="header-notify-text__img">
                                    <p>Đăng nhập để xem thông báo</p>
                                </div>
                            </li>
                            <li class="header__navbar-item header__navbar-user">

                                <c:url value="${sessionScope.account.avatar}"
                                       var="imgUrl"></c:url>
                                <c:choose>
                                    <c:when test="${sessionScope.account.avatar==null}">
                                        <a href="login.jsp" class="header__navbar-user-name text" style="display: contents;"><i class="fas fa-user" style=""></i> Đăng nhập<i class="fas fa-chevron-down" style="padding-left: 6px;"></i></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="login.jsp" class="header__navbar-user-name text" style="display: contents;"><img src="${imgUrl}" style="width:24px;height:24px;border-radius: 50%;"> ${sessionScope.account.username}<i class="fas fa-chevron-down" style="padding-left: 6px;"></i></a>
                                    </c:otherwise>
                                </c:choose>


                                <ul class="header__navbar-user-menu">
                                    <li class="header__navbar-user-item">
                                        <a href="../../../account.html"><i class="fas fa-user-alt"></i>Tài khoản của tôi</a>
                                    </li>
                                    <li class="header__navbar-user-item">
                                        <a href=""><i class="fas fa-cog"></i>Cài đặt</a>
                                    </li>
                                    <li class="header__navbar-user-item">
                                        <a href="../../../cart.html"><i class="fas fa-receipt"></i>Đơn mua</a>
                                    </li>
                                    <li class="header__navbar-user-item header__navbar-user-item-separate">
                                        <a href="login.jsp"><i class="fas fa-sign-out-alt"></i>Đăng xuất</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="" class="text"> <i class="fab fa-instagram"></i>Kết Nối </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="../../../index.html"><img src="${url}/images/home/celine_login.png" class="logo-shop" alt=""/></a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="header__search pull-right">
                        <form action="${pageContext.request.contextPath }/product/search" method="get">
                        <div class="header__search-input-wrap">

                            <input type="text" class="header__search-input" placeholder="BỘ SƯU TẬP CUỐI NĂM">
                            <!--Lịch sử tìm kiếm-->
                            <div class="header__search-history">
                                <h3 class="header__search-history-heading">
                                    Lịch sử tìm kiếm
                                </h3>
                                <ul class="header__search-history-list">
                                    <li class="header__search-history-item">
                                        <a href="">Áo thun croptop</a>
                                    </li>
                                    <li class="header__search-history-item">
                                        <a href="">Quần leggy</a>
                                    </li>
                                    <li class="header__search-history-item">
                                        <a href="">Balo thỏ</a>
                                    </li>
                                </ul>
                            </div>
                            <button class="header__search-btn" >
                                <i class="header__search-btn-icon fas fa-search"></i>
                            </button>
                            </form>
                        </div>

                    </div>
                </div>
                <div class="cart col-sm-2">

                    <ul class="list-inline shop-badge badge-lists badge-icons pull-right">
                        <li><a href="#"><i class="fas fa-shopping-cart"><c:set
                                var="count" value="${0}" /></i></a> <c:forEach items="${sessionScope.cart}"
                                                                       var="map">
                            <c:set var="count" value="${count + map.value.quantity}" />
                        </c:forEach> <span class="badge badge-sea rounded-x">${count }</span>

                            <ul class="list-unstyled badge-open mCustomScrollbar"
                                data-mcs-theme="minimal-dark">
                                <c:forEach items="${sessionScope.cart}" var="map">
                                    <li><c:url value="${map.value.product.image}"
                                               var="imgUrl"></c:url> <img src="${imgUrl}" alt="" width="10"
                                                                          height="20"> <a
                                            href="${pageContext.request.contextPath}/member/cart/remove?pId=${map.value.product.id} "><button
                                            type="button" class="close">×</button></a>
                                        <div class="overflow-h">
                                            <span>${map.value.product.name }</span> <small>${map.value.quantity }
                                            * ${map.value.product.price }.0 $ </small>
                                        </div></li>
                                </c:forEach>

<%--                                <div class="row">--%>
<%--                                    <div class="col-xs-6">--%>
<%--                                        <a href="${pageContext.request.contextPath}/member/cart"--%>
<%--                                           class="btn-u btn-brd btn-brd-hover btn-u-sea-shop btn-block">View--%>
<%--                                            Cart</a>--%>
<%--                                    </div>--%>
<%--                                    <div class="col-xs-6">--%>
<%--                                        <a href="${pageContext.request.contextPath}/member/order"--%>
<%--                                           class="btn-u btn-u-sea-shop btn-block">Checkout</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                            </ul>

                        </li>
                    </ul>
                   </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->
<script>
    var newYears = '1 May 2022'
    const dayEl = document.getElementById('days')
    const hourEl = document.getElementById('hours')
    const minsEl = document.getElementById('mins')
    const secondeEl = document.getElementById('seconds')
    const changeDate = document.getElementById('date')
    changeDate.addEventListener('change', myChange)
    function countdown() {
        const newYearsDate = new Date(newYears)
        const currentDate = new Date()
        const totalsecond = (newYearsDate - currentDate) / 1000
        const days = Math.floor(totalsecond / 3600 / 24)
        const hours = Math.floor(totalsecond / 3600) % 24
        const minutes = Math.floor(totalsecond / 60) % 60
        const second = Math.floor(totalsecond % 60)
        dayEl.innerHTML = time(days);
        hourEl.innerHTML = time(hours);
        minsEl.innerHTML = time(minutes);
        secondeEl.innerHTML = time(second);
    }
    function time(time) {
        if (time < 10) {
            return `0${time}`
        } else {
            return time
        }
    }
    function myChange() {
        const change = document.getElementById('date').value
        newYears = change
        console.log(change)
    }
    //countdown ();
    setInterval(countdown, 1000)
</script>