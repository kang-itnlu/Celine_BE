<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 5/16/2022
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý tin tức</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="${url}/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${url}/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${url}/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-dark navbar-info">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <!-- SEARCH FORM -->
        <form class="form-inline ml-3">
            <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Tìm kiếm..." aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">

            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-user-circle fa-2x"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">Tài khoản Admin</span>
                    <div class="dropdown-divider"></div>
                    <a href="" class="dropdown-item">
                        <i class="fas fa-sign-in-alt mr-2"></i> Đăng nhập
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-registered mr-2"></i> Đăng ký
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-sign-out-alt mr-2"></i> Đăng xuất
                    </a>
                    <div class="dropdown-divider"></div>
                </div>
            </li>

        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-light-info elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link navbar-cyan">
            <img src="${url}/dist/img/logo_login.png"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-bolder">Céline Store</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="${url}/dist/img/logo_login.png" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Céline Admin</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="trangchu.html" class="nav-link">
                            <i class="nav-icon fas fa-home"></i>
                            <p>
                                Trang chủ
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlidanhmuc.html" class="nav-link">
                            <i class="nav-icon fas fa-th-list"></i>
                            <p>
                                Quản lý danh mục
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlitaikhoan.html" class="nav-link">
                            <i class="nav-icon fas fa-user"></i>
                            <p>
                                Quản lý tài khoản
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlidonhang.html" class="nav-link">
                            <i class="nav-icon fas fa-money-bill"></i>
                            <p>
                                Quản lý hóa đơn
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlisanpham.html" class="nav-link">
                            <i class="nav-icon fa fa-book"></i>
                            <p>
                                Quản lý sản phẩm
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlitintuc.html" class="nav-link active">
                            <i class="nav-icon fa fa-newspaper"></i>
                            <p>
                                Quản lý tin tức
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="quanlibinhluan.html" class="nav-link">
                            <i class="nav-icon fas fa-comment"></i>
                            <p>
                                Quản lý bình luận
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="thongke.html" class="nav-link">
                            <i class="nav-icon fas fa-chart-area"></i>
                            <p>
                                Thống kê
                            </p>
                        </a>
                    </li>

                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Quản lý tin tức</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="trangchu.html">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý tin tức</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <div class="row">
                                <div class=" col-6">
                                    <a class="card-title">
                                        Bảng quản lý các tin tức</a>
                                </div>
                                <div class=" col-6 text-right">
                                    <a href="themtintuc.html">
                                        <button type="button" class="btn btn-primary text-right">
                                            <i class="fa fa-plus-circle"></i> Thêm tin tức
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered">
                                <thead>
                                <tr>
                                    <th title="Số thứ tự">STT</th>
                                    <th>Mã tin</th>
                                    <th>Tiêu đề</th>
                                    <th>Nội dung</th>
                                    <th>Hình ảnh</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>tt1
                                    </td>
                                    <td>Thời trang Đông-Xuân 2022</td>
                                    <td>Giai đoạn chuyển năm chính là lúc để các xu hướng thời trang mới ra đời và dẫn đẫu xu hướng, với các phong cách thời trang...</td>
                                    <td><img src="${url}/dist/img/thudong.jpg" alt="" style="width:30%; height: 20%;margin: 0 auto;
                    display: block"></td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a href="suatintuc.html">
                                                <button type="button" class="btn btn-block btn-outline-success ml-1">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </a>

                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>tt2
                                    </td>
                                    <td>Gucci ra mắt sản phẩm giày mới</td>
                                    <td>Mới đây Gucci đã cho ra mắt sản phẩm giày mới mang tên Gucci Aventador lấy cảm hứng từ mẫu siêu xe Lamborghini...</td>
                                    <td><img src="${url}/dist/img/gucci.png" alt="" style="width:30%; height: 20%;margin: 0 auto;
                    display: block"></td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a href="suatintuc.html">
                                                <button type="button" class="btn btn-block btn-outline-success ml-1">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </a>

                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>tt3
                                    </td>
                                    <td>Khuyến mãi cực sốc đón Giáng sinh 2021</td>
                                    <td>Nhân dịp Giáng sinh cửa hàng Céline sẽ giảm giá đồng loạt các sản phẩm thời trang localbrand..</td>
                                    <td><img src="${url}/dist/img/sale.jpg" alt="" style="width:30%; height: 20%;margin: 0 auto;
                    display: block"></td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a href="suatintuc.html">
                                                <button type="button" class="btn btn-block btn-outline-success ml-1">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </a>

                                        </div>
                                    </td>
                                </tr>

                                </tbody>
                                <tfoot>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.0.2-pre
        </div>
        <strong>Copyright &copy;2021 <a href="#">AdminCéline</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${url}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${url}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="${url}/plugins/datatables/jquery.dataTables.js"></script>
<script src="${url}/plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
<!-- AdminLTE App -->
<script src="${url}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${url}/dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
        });
    });
</script>
</body>
</html>



