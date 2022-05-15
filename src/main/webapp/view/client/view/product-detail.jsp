<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 4/2/2022
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<c:url value="${product.image}" var="imgUrl"></c:url>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Product-Detail</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/fontawesome.min.css">
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${url}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${url}/css/price-range.css" rel="stylesheet">
    <link href="${url}/css/animate.css" rel="stylesheet">
    <link href="${url}/css/main.css" rel="stylesheet">
    <link href="${url}/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="${url}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${url}/css/owl.theme.default.min.css">
    <link rel="shortcut icon" type="image/png" href="${url}/images/home/celine_login.png"/>
    <style>
        #container__body {
            margin-left: 100px;
        }

        .product__infor {
            display: flex;
        }

        .bread {
            margin-left: 100px;
            backface-visibility: hidden;
        }

        .breadcrumb-item a {
            color: var(--main-color);
        }

        .img__inner-detail {
            width: 500px;
            height: 500px;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;

        }

        .product__detail {
            padding-left: 82px;
        }

        .product__item-star {
            display: inline-flex;
            margin: 0 auto;

        }

        .product__item-star .product__item-star-sold {
            display: flex;
            justify-content: space-around;
            padding-left: 12px;
        }

        .home-product-item__price {
            padding: 12px 0;

        }

        .home-product-item__price-old,
        .home-product-item__price-current {
            font-size: 20px;
        }

        .home-product-item__price-current {
            color: var(--main-color);
        }

        #product__size {
            display: flex;
        }

        #product__size .product__size-S {
            margin: 0 6px;
            border: solid 1px gray;
            padding: 3px 12px;
            cursor: pointer;
        }

        .product__number {
            padding: 12px 0;
            display: flex;
        }

        .product__number-input {
            margin-left: 32px;
        }

        #modal__body #quantity {
            width: 60px;
        }

        .add__to-cart, .add__to-checkout {
            padding: 12px;
        }

        .add-cart {
            background-color: whitesmoke;
            padding: 10px 4px;
            color: var(--main-color);
            border: 1px solid gray;
        }

        .add-checkout {
            background-color: #f38772;
            padding: 12px 32px;
            color: whitesmoke;
            border: none;
        }

        .product__brand {
            display: flex;

        }

        .product__buy {
            display: flex;
        }

        .product__brand .first {
            padding-right: 12px;
        }

        #product__describe {
            padding: 12px 0;
            width: 624px;
        }

        #product__detail-more {
            padding: 12px 0;

        }

        #product__comment {
            padding-top: 12px;
        }

        .product__detail-more-text1 {
            display: flex;
        }

        .product__size-S.active {
            color: red;
        }

        .product__comment-text1-cmt {
            display: flex;
        }

        .product__comment-text1-cmt p {
            margin-left: 6px;
            color: var(--main-color);
        }

        .product__comment-input {
            margin-top: 12px;
            padding-bottom: 24px;
        }

        .product__comment-input-first {
            padding: 4px 12px;
        }

        .product__comment-btn {
            background-color: lightgray;
        }

        .recommend-more {
            margin-top: 50px;
        }

        .image-gallery {
            margin: 0 auto;
            display: table;
        }

        .primary,
        .thumbnails {
            display: table-cell;
        }

        .thumbnails {
            width: 100px;
            padding-right: 20px;
        }

        .primary {
            width: 550px;
            height: 550px;
            background-color: #cccccc;
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
        }

        .thumbnail:hover .thumbnail-image, .selected .thumbnail-image {
            border: 1px solid red;
        }

        .thumbnail-image {
            width: 120px;
            height: 120px;
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
            border: 1px solid transparent;
        }
    </style>
</head>
<body>
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<section>
    <nav role="navigation" class="bread">
        <ul class="breadcrumb" style="background-color:#eef9f9">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/welcome">Céline</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/product/list">Sản phẩm</a></li>
            <li class="breadcrumb-item active" aria-current="page">${product.name}</li>
        </ul>
    </nav>
    <div id="container" style="display: block;">
        <div id="container__body">
            <div class="product__infor">
                <%--                <div class="product__img">--%>
                <%--                    <img src="${imgUrl}" alt="" class="img__inner-detail">--%>
                <%--                </div>--%>
                <div class="image-gallery">
                    <aside class="thumbnails">
                        <div href="" class="selected thumbnail" data-big="${imgUrl}">
                            <div class="thumbnail-image" style="background-image: url(${imgUrl})"></div>
                        </div>
                        <div href="" class="thumbnail" data-big="http://placekitten.com/450/600">
                            <div class="thumbnail-image"
                                 style="background-image: url(http://placekitten.com/450/600)"></div>
                        </div>
                        <div href="" class="thumbnail" data-big="http://placekitten.com/460/700">
                            <div class="thumbnail-image"
                                 style="background-image: url(http://placekitten.com/460/700)"></div>
                        </div>
                    </aside>

                    <main class="primary img__inner-detail " style="background-image: url(${imgUrl});"></main>
                </div>
                    <form method="get" action="<c:url value="/member/cart/add"></c:url>">
                        <input type="text" value="${product.id }" name="pId" hidden="">
                <div class="product__detail">
                    <h2>${product.name}</h2>
                    <div class="product__item-star">
                        <div class="home-product-item__rating">
                            <c:forEach begin="1" end="${product.rating}">
                                <i class="home-product-item__star--gold fas fa-star"></i>
                            </c:forEach>
                        </div>
                        <div class="product__item-star-sold">
                            <p>${product.soldQuantity}</p>
                            <p>Đã bán</p>
                        </div>
                    </div>
                    <div class="product__brand">
                        <p class="first">Thương hiệu: </p>
                        <p>${product.brand}</p>
                    </div>
                    <div class="home-product-item__price">
                        <span class="home-product-item__price-old">${product.price}đ</span>
                        <span class="home-product-item__price-current">${product.salePrice}đ</span>
                    </div>
                    <div class="product__number">
                        <p>Số lượng:</p>

                        <div class="product__number-input">
                            <input onclick="var result = document.getElementById('quantity');
                    var qty = result.value; if( !isNaN(qty) & qty > 1 ) result.value--;return false;" type='button'
                                   value='-' style="padding: 0 5px; border-radius: 4px; border: 1px solid gray;"/>
                            <input id='quantity' min='1' name='quantity' type='text' value='1'
                                   style="text-align:center;"/>
                            <input onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty)) result.value++;return false;"
                                   type='button' value='+'
                                   style="padding: 0 5px; border-radius: 4px;border: 1px solid gray;"/>
                        </div>
                    </div>
                    <div id="product__size">
                        Size:
                        <div class="product__size-S first">S</div>
                        <div class="product__size-S second">M</div>
                        <div class="product__size-S third">L</div>
                        <div class="product__size-S four">XL</div>
                    </div>
                    <div class="product__buy">
                        <div class="add__to-cart">
                            <button class="add-cart" type="submit">
                                <i class="fas fa-cart-plus"></i>
                                Thêm Vào Giỏ Hàng
                            </button>
                        </div>
                        <div class="add__to-checkout">
                            <button class="add-checkout">
                                Mua Ngay
                            </button>
                        </div>
                    </div>
                    <div id="product__describe">
                        <div id="product__describe-icon" style="color:teal; cursor: pointer;"><i
                                class="fas fa-angle-right"></i>MÔ TẢ
                        </div>
                        <div id="product__describe-text" style="display: none;
                    -webkit-box-orient: vertical;
                    -webkit-line-clamp: 2;
                    text-align: left;">
                            <p>${product.des}</p>
                        </div>
                    </div>
                    <div id="product__detail-more">
                        <div id="product__describe-icon1" style="color:teal;cursor: pointer;"><i
                                class="fas fa-angle-right"></i>CHI TIẾT SẢN PHẨM
                        </div>
                        <div id="product__detail-more-text" style="display: none;">
                            <div class="product__detail-more-text1">
                                <img src="${url}/images/home/done.png" alt="" style="width: 20px;height: 20px;">
                                <span style="
                    -webkit-box-orient: vertical;
                    -webkit-line-clamp: 3;
                    text-align: left;width:600px;">${product.product_detail}</span>
                            </div>
                        </div>
                    </div>
                    <div id="product__comment">
                        <div id="product__comment-icon2" style="color:teal;cursor: pointer;padding-bottom: 12px;"><i
                                class="fas fa-angle-right"></i>ĐÁNH GIÁ(1)
                        </div>
                        <div id="product__comment-text" style="display: none;">
                            <div class="product__comment-text1">
                                <div class="product__comment-text1-cmt">
                                    <img src="${url}/images/home/man_comment.jpg" alt=""
                                         style="width: 20px;height: 20px;">
                                    <p>Jacky Nguyen</p>
                                </div>
                                <div class="home-product-item__rating" style="float: left; margin-left: -12px;">
                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                </div>
                                <p>Sản phẩm đẹp, mặc vào rất thoải mái.</p>
                                <p style="font-size: 8px;">12:10:56 20/12/2021</p>
                            </div>
                            <div class="product__comment-input">
                                <input type="text" class="product__comment-input-first"
                                       placeholder="Bình luận.........">
                                <button class="btn product__comment-btn">Bình luận</button>
                            </div>
                        </div>
                    </div>

                </div>
                    </form>
            </div>
        </div>
    </div>
    <div class="recommend-more">
        <h2 class="title text-center">Sản phẩm gợi ý</h2>
        <div id="con">
            <div class="owl-carousel">
                <c:forEach items="${categories}" var="p">
                    <c:url value="${p.image}" var="imgUrl2"></c:url>
                    <div class="col-sm-12">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <div id="product-img">
                                        <a href="${pageContext.request.contextPath }/product/detail?id=${p.id}">
                                            <img src="${imgUrl2}" alt="" id="img__sp"/></a>
                                    </div>

                                    <h4 class="home-product-item__name">${p.name}</h4>
                                </div>
                                <div class="home-product-item__price">
                                    <span class="home-product-item__price-old">${p.price}đ</span>
                                    <span class="home-product-item__price-current">${p.salePrice}đ</span>
                                </div>
                                <div class="home-product-item__action">
													<span class="home-product-item__like home-product-item__like--liked">
														<i class="home-product-item__like-icon-empty far fa-heart"></i>
														<i class="home-product-item__like-icon-fill fas fa-heart"></i>
													</span>
                                    <div class="home-product-item__rating">
                                        <c:forEach begin="1" end="${p.rating}">
                                            <i class="home-product-item__star--gold fas fa-star"></i>
                                        </c:forEach>
                                    </div>
                                    <span class="home-product-item__sold">${p.soldQuantity} đã bán</span>
                                </div>
                                <div class="home-product-item__origin">
                                    <span class="home-product-item__brand">${p.brand}</span>
                                    <span class="home-product-item__origin-name">${p.manufacturer}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/view/client/view/footer.jsp"></jsp:include>

<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script>
<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/price-range.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/product_detail.js"></script>
<script src="${url}/js/html5shiv.js"></script>
<script src="${url}/js/respond.min.js"></script>
<script src="${url}/js/owl.carousel.min.js"></script>

<script>
    $(document).ready(function () {
        $(".owl-carousel").owlCarousel({
            loop: true,
            margin: 10,
            items: 5
        });
    });
    $('.thumbnail').on('click', function () {
        let clicked = $(this);
        let newSelection = clicked.data('big');
        let $img = $('.primary').css("background-image", "url(" + newSelection + ")");
        clicked.parent().find('.thumbnail').removeClass('selected');
        clicked.addClass('selected');
        $('.primary').empty().append($img.hide().fadeIn('slow'));
    });
</script>
<script>
    let i, j, k;
    i = 0;
    j = 0;
    k = 0;
    $(document).ready(function () {
        $('#product__describe').click(function () {
            $('#product__describe-text').toggle();

            i++;
            if (i % 2 !== 0) {
                $('#product__describe-icon').replaceWith('<div id="product__describe-icon" style="color:teal; cursor: pointer;"><i class="fas fa-angle-down"></i>MÔ TẢ</div>');
            } else $("#product__describe-icon").replaceWith('<div id="product__describe-icon" style="color:teal; cursor: pointer;"><i class="fas fa-angle-right"></i>MÔ TẢ</div>');

        });
        $("#product__detail-more").click(function () {
            $("#product__detail-more-text").toggle();
            j++;
            if (j % 2 !== 0) {
                $("#product__describe-icon1").replaceWith('<div id="product__describe-icon1" style="color:teal; cursor: pointer;"><i class="fas fa-angle-down"></i>CHI TIẾT SẢN PHẨM</div>');
            } else $("#product__describe-icon1").replaceWith('<div id="product__describe-icon1" style="color:teal; cursor: pointer;"><i class="fas fa-angle-right"></i>CHI TIẾT SẢN PHẨM</div>');
        });
        $("#product__comment-icon2").click(function () {
            $("#product__comment-text").toggle();
            k++;
            if (k % 2 !== 0) {
                $("#product__comment-icon2").replaceWith('<div id="product__comment-icon2" style="color:teal; cursor: pointer;"><i class="fas fa-angle-down"></i>ĐÁNH GIÁ(1)</div>');
            } else $("#product__comment-icon2").replaceWith('<div id="product__comment-icon2" style="color:teal; cursor: pointer;"><i class="fas fa-angle-right"></i>ĐÁNH GIÁ(1)</div>');
        });
    });

    $(document).ready(
        function () {
            $(".product__size-S").click(
                function () {
                    $(this).addClass("active").siblings().removeClass("active");
                }
            );
        });
</script>
</body>
</html>
