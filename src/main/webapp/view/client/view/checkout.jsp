<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 4/17/2022
  Time: 8:47 PM
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
    <title>Checkout | Céline</title>
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
    <link href="${url}/css/checkout.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="${url}/images/home/celine_login.png"/>
    <!--[if lt IE 9]>

    <![endif]-->
</head><!--/head-->

<body>
<jsp:include page="/view/client/view/header.jsp"></jsp:include>

<section id="cart_items">
    <div class="container">
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">
                        Sản phẩm
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
                            <a href=""><img src="${imgUrl}" alt=""></a>
                        </td>
                        <td class="cart_description">
                            <h4><a href="">${map.value.product.name}</a></h4>
                        </td>
                        <td class="cart_price">
                            <p>${map.value.product.salePrice}đ</p>
                        </td>
                        <td class="cart_quantity">
                                ${map.value.quantity}
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">${map.value.quantity* map.value.product.salePrice}đ</p>
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
            <div class="col-sm-12">
                <div class="payment__type">
                    <div class="payment__type-left">Phương thức thanh toán</div>
                    <div class="payment__type-right">
                        <p>Thanh toán khi nhận hàng</p>
                        <div class="payment__type-right-change">
                            <div type="button" class="launch" data-toggle="modal" data-target="#staticBackdrop">THAY ĐỔI
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"
                                 tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <div class="text-right"><i class="fas fa-times-circle text-close"
                                                                       data-dismiss="modal"></i></div>
                                            <div class="tabs mt-3">
                                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                    <li class="nav-item" role="presentation"><a class="nav-link active"
                                                                                                id="visa-tab"
                                                                                                data-toggle="tab"
                                                                                                href="#visa" role="tab"
                                                                                                aria-controls="visa"
                                                                                                aria-selected="true">
                                                        <img src="images/home/visa.jpg" width="80"> </a></li>
                                                    <li class="nav-item" role="presentation"><a class="nav-link"
                                                                                                id="paypal-tab"
                                                                                                data-toggle="tab"
                                                                                                href="#paypal"
                                                                                                role="tab"
                                                                                                aria-controls="paypal"
                                                                                                aria-selected="false">
                                                        <img src="images/home/Paypal.png" width="80"> </a></li>
                                                </ul>
                                                <div class="tab-content" id="myTabContent">
                                                    <div class="tab-pane fade" id="visa" role="tabpanel"
                                                         aria-labelledby="visa-tab">
                                                        <div class="mt-4 mx-4">
                                                            <div class="text-center">
                                                                <h5>Credit card</h5>
                                                            </div>
                                                            <div class="form mt-3">
                                                                <div class="inputbox"><input type="text" name="name"
                                                                                             class="form-control"
                                                                                             required="required"> <span>Cardholder Name</span>
                                                                </div>
                                                                <div class="inputbox"><input type="text" name="name"
                                                                                             min="1" max="999"
                                                                                             class="form-control"
                                                                                             required="required"> <span>Card Number</span>
                                                                    <i class="fa fa-eye"></i></div>
                                                                <div class="d-flex flex-row">
                                                                    <div class="inputbox"><input type="text" name="name"
                                                                                                 min="1" max="999"
                                                                                                 class="form-control"
                                                                                                 required="required">
                                                                        <span>Expiration Date</span></div>
                                                                    <div class="inputbox"><input type="text" name="name"
                                                                                                 min="1" max="999"
                                                                                                 class="form-control"
                                                                                                 required="required">
                                                                        <span>CVV</span></div>
                                                                </div>
                                                                <div class="px-5 pay">
                                                                    <button class="btn btn-success btn-block">Add card
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane fade  show active" id="paypal" role="tabpanel"
                                                         aria-labelledby="paypal-tab">
                                                        <div class="px-5 mt-5">
                                                            <div class="inputbox"><input type="text" name="name"
                                                                                         class="form-control"
                                                                                         required="required"> <span>Paypal Email Address</span>
                                                            </div>
                                                            <div class="pay px-5">
                                                                <button class="btn btn-primary btn-block">Add paypal
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
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
            </div>
            <div class="col-sm-6">
                <div class="total_area">
                    <c:set var="total" value="${0}"/> <c:forEach
                        items="${sessionScope.cart}" var="map">
                    <c:set var="total"
                           value="${total + map.value.quantity * map.value.product.price}"/>
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
                            <p>Tổng cộng:</p>
                            <p style="font-size: 24px;color: #efac92">${total}đ</p>
                            <p class="no_product" style="display:none">Vui lòng chọn sản phẩm</p>
                        </div>
                        <p class="vat">(Đã bao gồm thuế VAT nếu có)</p>
                    </div>
                    <div class="checkout_button">
                        <button class="checkout">Mua hàng (${map.size()} sản phẩm)</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section><!--/#do_action-->


<jsp:include page="/view/client/view/footer.jsp"></jsp:include>

<jsp:include page="/view/client/view/facebook_noti.jsp"></jsp:include><!--/Footer-->


<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/html5shiv.js"></script>
<script src="${url}/js/respond.min.js"></script>
</body>
</html>
