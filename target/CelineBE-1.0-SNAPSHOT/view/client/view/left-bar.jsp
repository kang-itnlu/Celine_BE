<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 3/29/2022
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Danh mục</h2>
        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
                            <span class="badge pull-right"><i class="fas fa-plus"></i></span>
                            Thương hiệu thời trang
                        </a>
                    </h4>
                </div>
                <div id="sportswear" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul>
                            <li><a href="#">Hades </a></li>
                            <li><a href="#">Loren </a></li>
                            <li><a href="#">Venus </a></li>
                            <li><a href="#">Pearl</a></li>
                            <li><a href="#">Tote </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordian" href="#mens">
                            <span class="badge pull-right"><i class="fas fa-plus"></i></span>
                            Thời trang cho nam
                        </a>
                    </h4>
                </div>
                <div id="mens" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul>
                            <li><a href="${pageContext.request.contextPath }/product/detail?cate_id=${5}">Thời trang theo mùa</a></li>
                            <li><a href="#">Thời trang tối giản</a></li>
                            <li><a href="#">Thời trang Vintage</a></li>
                            <li><a href="#">Thời trang lịch lãm</a></li>
                            <li><a href="#">Thời trang công sở</a></li>
                            <li><a href="#">Thời trang thường ngày</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordian" href="#womens">
                            <span class="badge pull-right"><i class="fas fa-plus"></i></span>
                            Thời trang cho nữ
                        </a>
                    </h4>
                </div>
                <div id="womens" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul>
                            <li><a href="#">Thời trang công sở</a></li>
                            <li><a href="#">Thời trang Vintage</a></li>
                            <li><a href="#">Thời trang du mục</a></li>
                            <li><a href="#">Thời trang cổ điển</a></li>
                            <li><a href="#">Thời trang dark-wear</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title"><a href="#">Túi xách</a></h4>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title"><a href="#">Phụ kiện</a></h4>
                </div>
            </div>
        </div><!--/category-products-->

        <div class="filter_products"><!--filter_products-->
            <h2>Bộ lọc tìm kiếm</h2>
            <div class="filter_products-brand">
                <div class="filter_products-header">Thương Hiệu</div>
                <div class="filter_products-father-list">
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Hades</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Loren</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Venus</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Pearl</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Tote</label>
                    </div>
                    <div class="filter_products-more">Thêm
                        <i class="fas fa-angle-down"></i>
                    </div>
                </div>
            </div>
            <!--Đường kẻ ngang-->
            <div class="line"></div>
            <!--Lọc giá-->
            <div class="filter_products-price-range">
                <div class="filter_products-price-range-header">Khoảng giá</div>
                <div class="filter_products-price-range-input">
                    <input type="text" maxlength="13" class="filter-price-range-filter__input" placeholder="₫ TỪ" value="">
                    <div class="filter-price-range-filter__range-line"></div>
                    <input type="text" maxlength="13" class="filter-price-range-filter__input" placeholder="₫ ĐẾN" value="">
                </div>
                <button class="filter-button-solid" style="background-color: #efac92;">ÁP DỤNG</button>
            </div>
            <!--Theo đánh giá-->
            <div class="filter_product-rating">
                <div class="filter_product-rating-header">Đánh giá</div>
                <div class="filter_product-rating-star">
                    <div class="filter_product-rating-5star star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="filter_product-rating-4star star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                        trở lên
                    </div>
                    <div class="filter_product-rating-3star star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        trở lên
                    </div>
                    <div class="filter_product-rating-2star star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        trở lên
                    </div>
                    <div class="filter_product-rating-1star star">
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                        trở lên
                    </div>
                </div>
            </div>
            <!--Shipping-->
            <div class="filter_products-ship">
                <div class="filter_products-ship-header">Dịch vụ & khuyến mãi</div>
                <div class="filter_products-ship-father">
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Freeship Xtra</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Đang giảm giá</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Miễn phí vận chuyển</label>
                    </div>
                    <div class="filter_product-son">
                        <input type="checkbox" class="checkbox-filter" id="brands" name="brands">
                        <label for="brands" class="brand-name">Hàng có sẵn</label>
                    </div>
                    <div class="filter_products-more">Thêm
                        <i class="fas fa-angle-down"></i>
                    </div>
                </div>
            </div>
            <button class="shop-button-solid" style="background-color: #efac92;"><p>XÓA TẤT CẢ</p></button>
        </div><!--/filter_products-->

        <div class="shipping text-center"><!--shipping-->
            <img src="${url}/images/home/shipping.jpg">
            <img src="${url}/images/home/sale50.jpg" alt="" class="img-sale50"/>
        </div><!--/shipping-->

    </div>
</div>
