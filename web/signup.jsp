<%--
  Created by IntelliJ IDEA.
  User: xzin
  Date: 13/10/2018
  Time: 9:37 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Api - Sign up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.3.3.7.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ng-table.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/unipi.ico" type="image/x-icon" />
</head>
<body ng-app="app">



<div class="container-fluid" ng-controller="signupCtrl">
    <div class="row text-center">
        <h1>{{title}}</h1>
        <hr>
        <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3">
<form action="SignupServlet" method="post">

    <div class="form-group form-control-lg">
        <label>First Name : </label>
        <input class="form-control"
               type="text"
               name="firstNameIn"
               pattern="[A-Za-z]+"
               required="required"
               title="Please use only letters">
    </div>

    <div class="form-group form-control-lg">
        <label>Last Name : </label>
        <input class="form-control"
               type="text"
               name="lastNameIn"
               pattern="[A-Za-z]+"
               required="required"
               title="Please use only letters">
    </div>

    <div class="form-group form-control-lg">
        <label>Email : </label>
        <input class="form-control"
               type="email"
               name="emailIn"
               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
               required="required"
               title="Please use only email format  : 'xxx@yyy.zzz'">
    </div>

    <div class="form-group form-control-lg">
        <label>Password : </label>
        <input class="form-control"
               type="password"
               name="passwordIn"
               pattern="(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}"
               required="required"
               title="Please use at least one number, one uppercase letter and one special character, min length :8, max length : 20">
    </div>

    <div class="form-group form-control-lg">
        <label>Date of Birth : </label>
        <input type="date"
               class="form-control"
               required="required"
               min="1900-01-01"
               max="2017-31-12"
               name="dateIn">
    </div>

    <div class="form-group form-control-lg">
        <label>Telephone : </label>
        <input class="form-control"
               type="number"
               required="required"
               name="telephoneIn">
    </div>

    <div class="form-group form-control-lg">
        <label>Address : </label>
        <textarea class="form-control"
                  rows="5"
                  id="comment"
                  type="textarea"
                  required="required"
                  name="addressIn"></textarea>
    </div>

    <div class="form-group form-control-lg">
        <label>Role : </label>
        <select class="form-control"
                name="roleIn"
                ng-model="roleIn"
                required>
            <option value="">Select Role</option>
            <option ng-repeat="item in roles"
                    value="{{item.id}}"
            selected="{{item.role}}">{{item.role}}</option>
        </select>
    </div>

    <!-- TODO: lose this elements -->
    <% if(request.getParameter("userInfo")==null && request.getAttribute("signupStatus")!=null){

    %>
    <div class="well text-warning" ng-model="signupStatus"><%out.print(request.getAttribute("signupStatus"));
    %>
    </div>
    <%


        }%>

    <a class="btn btn-primary" href="login.jsp">Back</a>
    <button class="btn btn-primary" type="submit" ng-click="createItem()">Create User</button>
    <!--<button class="btn btn-primary" type="submit" ng-click="updateItem()">Update User</button>-->
    <button class="btn btn-primary" type="reset">Reset</button>
</form>

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
<script src="${pageContext.request.contextPath}/resources/js/controllers/signupCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ng-table.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/dirPagination.js"></script>
</body>
</html>
