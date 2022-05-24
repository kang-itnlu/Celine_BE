<%--
  Created by IntelliJ IDEA.
  User: khang
  Date: 5/16/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý bình luận</title>
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
                        <h1>Quản lý bình luận</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Admin/Welcome">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý bình luận</li>
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
                                        Bảng quản lý các bình luận</a>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-responsive-md">
                                <thead>
                                <tr>
                                    <th title="Số thứ tự">STT</th>
                                    <th>Mã bình luận</th>
                                    <th>Nội dunng</th>
                                    <th>Người bình luận</th>
                                    <th>Phân loại</th>
                                    <th>Thời gian</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>bl1</td>
                                    <td>Sản phẩm rất tốt, vưa tầm giá</td>
                                    <td>Tony Tèo</td>
                                    <td>Bình thường
                                    </td>
                                    <td>1/11/2021</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a target="_blank" href="${pageContext.request.contextPath}/Admin/comment/delete">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>bl2</td>
                                    <td>aaaaaaaaaaaa</td>
                                    <td>Mr.Đờm</td>
                                    <td>Spam
                                    </td>
                                    <td>11/11/2021</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a target="_blank" href="${pageContext.request.contextPath}/Admin/comment/delete">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
                                                </button>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>bl3</td>
                                    <td>Chất vải chưa tốt lắm, cần nâng cấp</td>
                                    <td>Ms.Kim</td>
                                    <td>Bình thường
                                    </td>
                                    <td>1/12/2021</td>
                                    <td>
                                        <div class="row justify-content-center">
                                            <a target="_blank" href="${pageContext.request.contextPath}/Admin/comment/delete">
                                                <button type="button" class="btn btn-block btn-outline-danger">
                                                    <i class="fa fa-trash-alt"></i>
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



