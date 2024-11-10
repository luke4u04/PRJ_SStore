<%-- 
    Document   : LeftDashBoard
    Created on : Oct 31, 2023, 12:13:15 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">


    <div class="list-group list-group-flush bg-light sticky-top pl-0 pt-5 mt-3">
        <c:if test="${sessionScope.ac.isAdmin==1}">
            <a
                href="dashBoard"
                class="list-group-item bg-light list-group-item-action py-3 ripple "
                aria-current="true"
                >
                <i class="fas fa-tachometer-alt fa-fw me-3"></i
                > <span>Main dashboard</span>
            </a>
        </c:if>


        <c:if test="${sessionScope.ac.isAdmin==1}">
            <a
                href="manageraccount"
                class="list-group-item bg-light list-group-item-action py-3 ripple"
                ><i class="fas fa-user-circle fa-fw me-3"></i><span>Manager Account</span></a
            >
        </c:if>

        <c:if test="${sessionScope.ac.isAdmin==1}">

            <a
                href="manageproduct"
                class="list-group-item bg-light list-group-item-action py-3 ripple"
                ><i class="fas fa-book fa-fw me-3"></i
                ><span>Manager Product</span></a
            >

        </c:if>

        <c:if test="${sessionScope.ac.isAdmin==1}">
            <a
                href="managerInvoiceDB"
                class="list-group-item bg-light list-group-item-action py-3 ripple"
                >
                <i class="fas fa-file-invoice fa-fw me-3"></i><span>Manager Invoice</span>
            </a>
        </c:if>

    </div>

</div>
