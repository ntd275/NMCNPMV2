<%-- 
    Document   : checkout
    Created on : Nov 24, 2019, 8:01:20 PM
    Author     : ntd27
--%>
<%@page import="entity.*"%>
<jsp:include page="banner-top.jsp"></jsp:include>
    <script>$(document).ready(function (c) {
            $('.close1').on('click', function (c) {
                $('.cart-header').fadeOut('slow', function (c) {
                    $('.cart-header').remove();
                });
            });
        });
    </script>
    <script>$(document).ready(function (c) {
            $('.close2').on('click', function (c) {
                $('.cart-header1').fadeOut('slow', function (c) {
                    $('.cart-header1').remove();
                });
            });
        });
    </script>
    <script>$(document).ready(function (c) {
            $('.close3').on('click', function (c) {
                $('.cart-header2').fadeOut('slow', function (c) {
                    $('.cart-header2').remove();
                });
            });
        });
    </script>
<c:set var='view' value='/checkout' scope='session' />
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#checkoutForm").validate({
                rules: {
                    name: "required",
                    email: {
                        required: true,
                        email: true
                    },
                    phone: {
                        required: true, number: true,
                        minlength: 9
                    },
                    address: {
                        required: true
                    }
                }
            });
        });
</script>
<div id="container">
    <div class="container-fluid">
        <div class="page-header">
            <h1>Please confirm your order</h1>
        </div>
        <div class="row">
            <h3 style="margin-left: 14px; margin-bottom: 14px;"> Ship your order to&hellip;</h3>
            <div class="list-group">
                <div class="list-group-item">
                    <div class="list-group-item-heading">          
                        <div class="row">

                            <div class="col-xs-7">                      
                                <form role="form" id="checkoutForm" action="confirmation" method="post">
                                    <input type="hidden" name ="userpath" id="userpath" value="/purchase">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control form-control-large" id="name" name="name" placeholder="Enter name" value="<%=user.getTenKH() %>">
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="required">Email</label>
                                        <input type="text" class="form-control form-control-large" id="email" name="email" placeholder="Enter email" value="<%=user.getEmail() %>">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone" class="required">Phone</label>
                                        <input type="text" class="form-control form-control-large" id="phone" name="phone" placeholder="Enter phone number" value="<%=user.getSoDT() %>">
                                    </div>
                                    <div class="form-group">
                                        <label for="address" class="required">Address</label>
                                        <input type="text" class="form-control form-control-large" id="address" name="address" placeholder="Enter address" value="<%=user.getDiaChi() %>">
                                    </div>
                                    <div class="form-group">
                                        <input style="margin-top: 26px;height: 52px" value="Submit purchase" type="submit" class="btn btn-primary btn-lg btn-block">
                                    </div>
                                </form>
                            </div>
                            <div class="col-xs-5">
                                <div class="form-group" style="margin-top: 26px">
                                    <h3 style="font-weight: bold">Order Information</h3>
                                </div>
                                <div class="form-group">
                                    <p>
                                        <strong>Next-working day delivery is guaranteed</strong>
                                    </p></div>
                                <div class="form-group">
                                    <p>
                                        <strong>
                                            A
                                            <fmt:formatNumber type="currency" currencySymbol="&euro; "
                                                              value="${initParam.deliveryFee}"/>
                                            delivery surcharge is applied to all purchase orders
                                        </strong>
                                    </p></div>
                                <div style="height:39px;margin-top: 45px;">
                                    <div class="col-xs-6"><h3 style="font-weight: bold">Total</h3></div>
                                    <div class="col-xs-6" style="color: #F44336;font-size: 1.25em;font-weight: bold;"><fmt:formatNumber type="currency"
                                                      currencySymbol="&dollar; " value="${cart.subtotal}"/>
                                    </div>                        
                                </div>
                                <div style="height:39px">
                                    <div class="col-xs-6"><h3 style="font-weight: bold">Delivery Fee</h3></div>
                                    <div class="col-xs-6" style="color: #F44336;font-size: 1.25em;font-weight: bold;"><fmt:formatNumber type="currency"
                                                      currencySymbol="&dollar; " value="${initParam.deliveryFee}"/>
                                    </div>                        
                                </div>
                                <div>
                                    <div class="col-xs-6"><h3 style="font-weight: bold">Total Fee</h3></div>
                                    <div class="col-xs-6" style="color: #F44336;font-size: 1.25em;font-weight: bold;"><fmt:formatNumber type="currency"
                                                      currencySymbol="&dollar; " value="${cart.subtotal + initParam.deliveryFee}"/>
                                    </div>                        
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/bootstrap.min.js"></script>
    <jsp:include page="brand.jsp"></jsp:include>