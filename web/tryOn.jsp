<%-- 
    Document   : tryOn
    Created on : Dec 7, 2019, 6:34:43 PM
    Author     : thuan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%    session.setAttribute("view", "/tryOn");
%>
<jsp:include page="banner-top.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
    <ul class="nav navbar-nav nav_1">

        <li><a style="margin-left: 30px; color: #fff; margin-top: 20px;" class="btn btn-primary btn-block" href="<c:url value='category?TryClothes'/>">Back</a></li>

    </ul>
</div>
<div>              
    <%String link = (String) session.getAttribute("link");%>
    <a><img src= <%=link%>>
    </a>    
</div>  
<jsp:include page="brand.jsp"></jsp:include>