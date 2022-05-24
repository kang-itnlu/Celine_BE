<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 5/16/2022
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý hóa đơn</title>
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
   <jsp:include page="/view/admin/view/navbar.jsp"></jsp:include>
    <jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Quản lý hóa đơn</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="trangchu.html">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý hóa đơn</li>
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
                                        Bảng quản lý các hóa đơn</a>
                                </div>
                                <div class=" col-6 text-right">
                                    <a href="themdonhang.html">
                                        <button type="button" class="btn btn-primary text-right">
                                            <i class="fa fa-plus-circle"></i> Thêm mới hóa đơn
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-responsive-md">
                                <thead>
                                <tr>
                                    <th title="Số thứ tự">STT</th>
                                    <th>Mã hóa đơn</th>
                                    <th>Họ tên</th>
                                    <th>Địa chỉ</th>
                                    <th>Tình trạng</th>
                                    <th>Ngày mua</th>
                                    <th>Tổng tiền</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>hd1</td>
                                    <td>Nguyễn Văn Tèo</td>
                                    <td>56, Phan Văn Trị, Gò Vấp, TP.HCM</td>
                                    <td>Đã đóng gói</td>
                                    <td>
                                        12/12/2021
                                    </td>
                                    <td>125000</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a  href="suadonhang.html">
                                                <button type="button" class="btn btn-block btn-outline-success ml-1">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </a>

                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>hd2</td>
                                    <td>Cao Thị Thấp</td>
                                    <td>23/10, đường số 7, Linh Trung, Tp. Thủ Đức</td>
                                    <td>Đang xử lí</td>
                                    <td>13/12/2021
                                    </td>
                                    <td>399000</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a  href="suadonhang.html">
                                                <button type="button" class="btn btn-block btn-outline-success ml-1">
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                            </a>

                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>hd3</td>
                                    <td>Huỳnh Văn Phúc</td>
                                    <td>1, Võ Văn Ngân, Tp. Thủ Đức</td>
                                    <td>Đã giao</td>
                                    <td>5/12/2021
                                    </td>
                                    <td>999000</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a href="#">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                            <a  href="suadonhang.html">
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
  <jsp:include page="/view/admin/view/footer.jsp"></jsp:include>
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



