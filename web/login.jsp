<%--
  Created by IntelliJ IDEA.
  User: xzin
  Date: 13/10/2018
  Time: 12:50 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title class="text-center">Medical Api - Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.3.3.7.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/font-awesome.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/unipi.ico" type="image/x-icon" />
</head>
<body ng-app="app">




<div class="container-fluid" ng-controller="loginCtrl">
    <h1 class="text-center">{{title}}</h1>
    <hr>
    <div class="row text-center">
        <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3">

            <form action="LoginServlet" method="post">

                <div class="form-group">
                    <label>Email :</label>
                    <input type="email"
                           class="form-control"
                           ng-model="email"
                           name="user"
                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
                           required="required"
                           title="Please use only email format  : 'xxx@yyy.zzz'">
                </div>

                <div class="form-group">
                    <label>Password :</label>
                    <input class="form-control"
                           type="password"
                           name="password"
                           ng-model="password"
                           pattern="(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}"
                           required="required"
                           title="Please use at least one number, one uppercase letter and one special character, min length :8, max length : 20"
                    >
                </div>

                <input class="btn btn-primary" type="submit" value="Submit" ng-click="storeData()"/>
            </form>

            <% if(request.getParameter("userInfo")==null && request.getAttribute("loginStatus")!=null){

            %>
            <div class="well text-warning" ng-model="loginStatus"><%out.print(request.getAttribute("loginStatus"));
            %>
            </div>
            <%


                }%>
            <hr>
            <div class="well"><i class="fa fa-pencil fa-lg"></i> Not registered? <a class="" href="signup.jsp">Sign up here!</a></div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/lodash.3.10.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/bootstrap.3.3.7.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-resource.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ngStorage.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controllers/loginCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ng-table.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-ui-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/dirPagination.js"></script>
</body>
</html>
