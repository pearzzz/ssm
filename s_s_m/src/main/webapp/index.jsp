<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>员工列表</title>
        <!-- 引入jquery -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
        <!-- Bootstrap -->
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- 搭建显示页面 -->
        <div class="container">
            <!-- 标题 -->
            <div class="row">
                <div class="col-md-12">
                    <h1>SSM-CRUD</h1>
                </div>
            </div>
            <!-- 按钮 -->
            <div class="row">
                <div class="col-md-4 col-md-offset-8">
                    <button class="btn btn-primary">新增</button>
                    <button class="btn btn-danger">删除</button>
                </div>
            </div>
            <!-- 显示表格数据 -->
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover" id="emps_table">

                        <thead>
                        <tr>
                            <th>#</th>
                            <th>empName</th>
                            <th>gender</th>
                            <th>email</th>
                            <th>deptName</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody>

                        </tbody>

                    </table>
                </div>
            </div>

            <!-- 显示分页信息 -->
            <div class="row">
                <!--分页文字信息  -->
                <div class="col-md-6" id="page_info_div">
                </div>
                <!-- 分页条信息 -->
                <div class="col-md-6" id="page_nav_div">

                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        $(function () {
            toPage(1);
        })

        function toPage(pn) {
            $.ajax({
                url: "${pageContext.request.contextPath}/emps",
                data: "pn=" + pn,
                type: "get",
                success: function (result) {
                    build_emps_table(result);
                    build_page_info(result);
                    build_page_nav(result);
                }
            })
        }

        function build_emps_table(result) {
            $("#emps_table tbody").empty();

            var emps = result.extend.pageInfo.list;
            $.each(emps, function (index, item) {
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var genderTd = $("<td></td>").append(item.gender == "M" ? "男" : "女");
                var emailTd = $("<td></td>").append(item.email);
                var deptNameTd = $("<td></td>").append(item.department.deptName);

                /*<td>
                    <button class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        编辑
                    </button>
                    <button class="btn btn-danger btn-sm">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        删除
                    </button>
                </td>*/
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                var buttonTd = $("<td></td>").append(editBtn).append(deleteBtn);

                $("<tr></tr>").append(empIdTd).append(empNameTd).append(genderTd).append(emailTd).append(deptNameTd).append(buttonTd)
                    .appendTo("#emps_table tbody");

            })
        }

        function build_page_info(result) {
            $("#page_info_div").empty();

            var page = result.extend.pageInfo;
            $("#page_info_div").append("当前" + page.pageNum + "页,共" + page.pages + "页,总" + page.total + "条记录");
        }


        /*<nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>*/
        function build_page_nav(result) {
            $("#page_nav_div").empty();

            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
            var prePageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append($("<span></span>").append("&laquo;")));
            if (result.extend.pageInfo.hasPreviousPage == false) {
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            } else {
                firstPageLi.click(function () {
                    toPage(1)
                })
                prePageLi.click(function () {
                    toPage(result.extend.pageInfo.pageNum - 1)
                })
            }

            var nextPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append($("<span></span>").append("&raquo;")));
            var lastPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("末页"));
            if (result.extend.pageInfo.hasNextPage == false) {
                lastPageLi.addClass("disabled");
                nextPageLi.addClass("disabled");
            } else {
                lastPageLi.click(function () {
                    toPage(result.extend.pageInfo.pages)
                })
                nextPageLi.click(function () {
                    toPage(result.extend.pageInfo.pageNum + 1)
                })
            }

            var navUl = $("<ul></ul>").addClass("pagination").append(firstPageLi).append(prePageLi);

            $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
                var numPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append(item));
                if (result.extend.pageInfo.pageNum == item) {
                    numPageLi.addClass("active");
                }
                numPageLi.click(function () {
                    toPage(item);
                })

                navUl.append(numPageLi);
            })

            navUl.append(nextPageLi).append(lastPageLi);

            $("<nav></nav>").append(navUl).appendTo("#page_nav_div");
        }
    </script>
</html>
