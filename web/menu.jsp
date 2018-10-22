<%@ page import="model.User" %>
<%@ page import="model.UserInfo" %>
<%@ page import="model.RoleTypeEnum" %><%--
  Created by IntelliJ IDEA.
  User: xzin
  Date: 13/10/2018
  Time: 2:19 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Api - Menu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.3.3.7.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ng-table.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/medical-symbol-icon.png" type="image/x-icon" />
</head>
<body ng-app="app">

<%
    /**
     *
     *Keep the session,purge browser cache
     */


    if(session.getAttribute("userInfo") == null){
        response.sendRedirect("/login.jsp");
    }

    UserInfo userInfo = (UserInfo)  session.getAttribute("userInfo");
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");


%>


<div class="container-fluid" ng-controller="dashboardCtrl">

    <div class="row text-center">
        <h1 >Medical Api - Project 2018</h1>
        <hr>
        <div class="float-left col-lg-2 col-md-2 col-sm-2 col-xs-2">

            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Medicines</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse">
                        <div class="panel-body text-center">
                                <a class="clickable" ui-sref="medicineAll">View all medicines</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Active Substances</a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="clickable" ui-sref="activeSubstances">View all active substances</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Side Effects</a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="clickable" ui-sref="sideEffects">View all side effects</a>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default" ng-if="userRole!='VISITOR'">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">Doctors Section</a>
                        </h4>
                    </div>
                    <div id="collapseFive" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="clickable" ui-sref="medicineUpdate">Update Medicine</a>
                            <br>
                            <a class="clickable" ui-sref="medicineCreate">Create New Medicine</a>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default" ng-if="userRole=='ADMIN'">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix">Rest Api</a>
                        </h4>
                    </div>
                    <div id="collapseSix" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a class="clickable" ui-sref="apiDoc">Rest Api - Exposed End Points</a>
                        </div>
                    </div>
                </div>

            </div>



        </div>
        <!-- UI VIEW -->
        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8" ui-view>

            <h1>Welcome to Medical Api Project</h1>
            <hr>

            <div class="well">
                This Api has been designed and implemented with Rest architecture.
                Back End is decoupled from UI and their communication is based on consuming Resources upon requests on exposed End points.
                Session, UUID & Authentication mechanisms are also implemented , so that only logged-in users can hit consume the resources.
                Failing to authenticate user will lead to un-responded requests.
            </div>

        </div>



        <!-- RIGHT COLUMN -->
        <div class="align-content-lg-stretch col-lg-2 col-md-2 col-sm-2 col-xs-2">

            <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                           <a href="" data-toggle="modal" data-target="#myModal">Member Info</a>
                        </h4>
                    </div>

            </div>



            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">User Info</h4>
                        </div>
                        <div class="modal-body">
                            <p>First Name : <%=userInfo.getUser().getFirstName()%></p>
                            <p>Last Name : <%=userInfo.getUser().getLastName()%></p>
                            <p>Date of Birth : <%=userInfo.getUser().getDate()%></p>
                            <p>Telephone: <%=userInfo.getUser().getTelephone()%></p>
                            <p>Address : <%=userInfo.getUser().getAddress()%></p>
                            <hr>
                            <h4>User Role</h4>
                            <p id="userRole">Role : <%=userInfo.getRole()%></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseEight">About</a>
                    </h4>
                </div>
                <div id="collapseEight" class="panel-collapse collapse">
                    <div class="panel-body">
                        <a class="clickable" ui-sref="about">About this project</a>
                    </div>
                </div>
            </div>


            <form class="panel panel-heading bg-warning" action="LogoutServlet" method="post">
                <input class="panel-body" type="submit" value="Log out" ng-click="deleteData()">
            </form>


        </div>



    </div>



</div>

<script src="${pageContext.request.contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/bootstrap.3.3.7.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-resource.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ngStorage.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/lodash.3.10.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controllers/signupCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ng-table.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/dirPagination.js"></script>
</body>
</html>
