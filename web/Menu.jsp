
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->

<style>
    .img-fluid{
        width: 750px;
        height: 320px;

    }

    .jumbotron{
        height: 400px;
        margin-top: 55px;
    }
    .navbar-header img{
        width: 30%;

    }
</style>
<nav class="navbar navbar-expand-md navbar-dark bg-danger fixed-top">
    <div class="container">
        <div class="navbar-header col-md-3">
            <a class="navbar-brand" href="home"><img src="img/logo.png"> </a>
        </div>
        <div class="col-md-6">
            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div  class="input-group input-group-sm">
                    <input style="padding-right: 300px;" value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>

            </form>
        </div>


        <div class="navbar-nav col-md-3">
            <div class="nav-item">
                <a class="btn btn-success btn-sm ml-3" style="margin-right: 10px" href="managercart">
                    <i class="fa fa-shopping-cart"></i> <span style="font-size: 18.5px;">Cart</span>
                    <b><span id="amountCart" class="badge badge-light" style="color:black; font-size: 12px;"></span></b>
                </a>
            </div>
            <div class="dropdown nav-item">
                <button id="account-dropdown" class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" >
                    Account
                </button>

                <ul class="dropdown-menu" aria-labelledby="account-dropdown">
                    <c:if test="${sessionScope.ac!=null}">
                        <li><a class="dropdown-item" href="#">${sessionScope.ac.user}</a></li>
                        </c:if>

                    <c:if test="${sessionScope.ac==null}">
                        <li><a class="dropdown-item" href="Login.jsp">Login</a></li>
                        </c:if>
                        
                        <c:if test="${sessionScope.ac.isAdmin==0}">
                        <li><a class="dropdown-item" href="ChangePass.jsp">Change Password</a></li>
                        </c:if>

                    <c:if test="${sessionScope.ac!=null}">
                        <li><a class="dropdown-item" href="myOrder">My Orders</a></li>
                        </c:if>

                    
                    <c:if test="${sessionScope.ac.isAdmin==1}">
                        <li><a class="dropdown-item" href="dashBoard">DashBoard Admin</a></li>
                        </c:if>

                    <c:if test="${sessionScope.ac!=null}">
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                        </c:if>

                </ul>
            </div>
        </div>


    </div>
</nav>

