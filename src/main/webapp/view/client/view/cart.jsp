<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 4/17/2022
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<c:set var="numProduct" value="${0}"/>
<c:forEach
        items="${sessionScope.cart}" var="map">
    <c:set var="numProduct"
           value="${numProduct + 1}"/>
</c:forEach>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | Céline</title>
    <link href="${url}/css/all.min.css" rel="stylesheet">
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${url}/css/fontawesome.min.css" rel="stylesheet">
    <link href="${url}/css/fontawesome.css" rel="stylesheet">
    <link href="${url}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${url}/css/price-range.css" rel="stylesheet">
    <link href="${url}/css/animate.css" rel="stylesheet">
    <link href="${url}/css/main.css" rel="stylesheet">
    <link href="${url}/css/responsive.css" rel="stylesheet">
    <link href="${url}/css/cart.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="${url}/images/home/celine_login.png"/>
    <!--[if lt IE 9]>

    <![endif]-->
</head><!--/head-->

<body>
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath }/welcome">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">
                        <input type="checkbox" class="checkbox-filter" name="brands">
                        Tất cả (${numProduct} sản phẩm)
                    </td>
                    <td class="description"></td>
                    <td class="price">Đơn giá</td>
                    <td class="quantity">Số lượng</td>
                    <td class="total">Thành tiền</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.cart}" var="map">
                    <tr>
                        <c:url value="${map.value.product.image }"
                               var="imgUrl"></c:url>
                        <td class="cart_product">
                            <input type="checkbox" class="checkbox-filter" name="brands">
                            <a href=""><img src="${imgUrl}" alt=""></a>
                        </td>
                        <td class="cart_description">
                            <h4><a href="">${map.value.product.name}</a></h4>
                        </td>
                        <td class="cart_price">
                            <p>${map.value.product.salePrice}đ</p>
                        </td>
                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <input onclick="var result = document.getElementById('quantity');
                   					 var qty = result.value; if( !isNaN(qty) & qty > 1 ) result.value--;return false;"
                                       type='button' value='-' style="width:18px;border-radius:5px;"/>
                                <input id='quantity' min='1' name='quantity' type='text' value='${map.value.quantity}'
                                       style="width: 30px;"/>
                                <input onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty)) result.value++;return false;"
                                       type='button' value='+' style="width:18px;border-radius:5px;"/>
                            </div>
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">${map.value.product.salePrice * map.value.quantity }đ</p>
                        </td>
                        <td class="cart_delete">
                            <a class="cart_quantity_delete"
                               href="${pageContext.request.contextPath}/member/cart/remove?pId=${map.value.product.id}"><i
                                    class="fa fa-times"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</section> <!--/#cart_items-->

<section id="do_action">
    <div class="container">
        <div class="row">
            <!-- <div class="col-sm-6">
                <div class="chose_area">
                    <div class="heading">
                        <h3>Giao tới </h3>
                        <div class="change_address">Thay đổi</div>
                    </div>
                    <div class="user_infor">
                        <p class="name">Mít tơ Tèo</p>
                        <div class="filter-price-range-filter__range-line"></div>
                        <p class="phone">0909153245</p>
                    </div>
                    <div class="user_address">
                        33/1, khu phố 6, phường Linh Trung, Thành phố Thủ Đức, TP.HCM
                    </div>
                    <div class="discount_area">
                        <div class="discount_header">
                            <h3 class="discount">Khuyến mãi</h3>
                            <p class="number_of_discount">Có thể chọn mã giảm giá hoặc mã freeship</p>
                        </div>
                        <i class="fas fa-tag"> Chọn hoặc nhập mã khuyến mãi</i>
                    </div>
                </div>
            </div> -->
            <div class="col-sm-12">
                <div class="total_area">
                    <c:set var="total" value="${0}"/>
                    <c:set var="numProduct" value="${0}"/>
                    <c:forEach
                        items="${sessionScope.cart}" var="map">
                    <c:set var="total"
                           value="${total + map.value.quantity * map.value.product.salePrice}"/>
                        <c:set var="numProduct"
                               value="${numProduct + 1}"/>
                </c:forEach>
                    <div class="checkout_calculate">
                        <div class="temp_price">
                            <p>Tạm tính</p>
                            <p>${total}đ</p>
                        </div>
                        <div class="discount_checkout">
                            <p>Giảm giá</p>
                            <p>0đ</p>
                        </div>
                        <div class="filter-price-range-filter__range-line-checkout"></div>
                        <div class="sum_price">
                            <p>Tổng cộng:${total}</p>
                            <p class="no_product">Vui lòng chọn sản phẩm</p>
                        </div>
                        <p class="vat">(Đã bao gồm thuế VAT nếu có)</p>
                    </div>
                    <div class="checkout_button">
                        <form action="/member/order">
                            <button class="checkout">Mua hàng (${numProduct})</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section><!--/#do_action-->

<jsp:include page="/view/client/view/footer.jsp"></jsp:include>

<jsp:include page="/view/client/view/facebook_noti.jsp"></jsp:include>
<!--/Footer-->


<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/html5shiv.js"></script>
<script src="${url}/js/respond.min.js"></script>
</body>
</html>
