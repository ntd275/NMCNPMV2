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

<script>
            function goBack() {
                window.history.back();
            }
</script>
<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
    <ul class="nav navbar-nav nav_1">

        <button class="btn btn-primary" onclick="goBack()" style="margin-left:20px;margin-top:20px; ">Back</button>

    </ul>
</div>
<div>              
    <%String link = (String) session.getAttribute("link");%>
    <a><img src= <%=link%>>
    </a>    
</div>  
<jsp:include page="brand.jsp"></jsp:include>