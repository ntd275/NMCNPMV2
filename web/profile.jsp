<%-- 
    Document   : register
    Created on : Nov 24, 2019, 8:07:26 PM
    Author     : ntd27
--%>
<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="container">
        <div class="login">
            <form action="register" method="get">
            <div class="col-md-6 login-do">
                <div class="login-mail">
                    <input type="text" placeholder="Name" required="" name="name" value="<%= user.getTenKH() %>">
                    <i  class="glyphicon glyphicon-user"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Phone Number" required="" name="phone"value="<%= user.getSoDT() %>">
                    <i  class="glyphicon glyphicon-phone"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Address" required="" name="address"value="<%= user.getDiaChi() %>">
                    <i  class="glyphicon glyphicon-home"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Email" required="" name="username"value="<%= user.getEmail() %>">
                    <i  class="glyphicon glyphicon-envelope"></i>
                </div>

            </div>
            <div class="clearfix"> </div>
        </form>
    </div>
</div>
<jsp:include page="brand.jsp"></jsp:include>