<%-- 
    Document   : register
    Created on : Nov 24, 2019, 8:07:26 PM
    Author     : ntd27
--%>
<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="container">
        <div class="login">
            <form action="register" method="get">
            <%                    
                String error = (String) request.getAttribute("error");
                if (error != null) {
            %>
            <div style="color: red"><%= error%></div>
            <%
                }
            %>
            <div class="col-md-6 login-do">
                <div class="login-mail">
                    <input type="text" placeholder="Name" required="" name="name">
                    <i  class="glyphicon glyphicon-user"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Phone Number" required="" name="phone">
                    <i  class="glyphicon glyphicon-phone"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Address" required="" name="address">
                    <i  class="glyphicon glyphicon-home"></i>
                </div>
                <div class="login-mail">
                    <input type="text" placeholder="Email" required="" name="username">
                    <i  class="glyphicon glyphicon-envelope"></i>
                </div>
                <div class="login-mail">
                    <input type="password" placeholder="Password" required="" name="password">
                    <i class="glyphicon glyphicon-lock"></i>
                </div>

                <label class="hvr-skew-backward">
                    <input type="submit" value="Submit">
                </label>

            </div>
            <div class="col-md-6 login-right">
                <h3>Completely Free Account</h3>

                <p>Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio 
                    libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
                <a href="login" class="hvr-skew-backward">Login</a>

            </div>
            <div class="clearfix"> </div>
        </form>
    </div>
</div>
<jsp:include page="brand.jsp"></jsp:include>