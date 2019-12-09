<%-- 
    Document   : comfirmation
    Created on : Dec 6, 2019, 11:33:06 PM
    Author     : minhh
--%>
<%@page import="entity.GiaoDich"%>
<%@page import="entity.DonHang"%>
<%@page import="java.util.List"%>
<%@page import="entity.SanPham"%>
<c:set var='view' value='/checkout' scope='session' />
<jsp:include page="banner-top.jsp"></jsp:include>
    <div id="container" style="margin-top: -20px; margin-left: 18px">
        <div class="page-header">
            <h1 style="margin-bottom: 20px; font-family: 'Ubuntu-Regular';">Confirmation</h1>
            <div class="form-group" style="font-weight: bold">
                Your order has been successfully processed and will be delivery within 24 hours.
            </div>
            <div class="form-group">
                if you have any query concerning your order, feel free to <span><a href="contact">contact us.</a></span>
            </div>
            <div class="form-group">
                Thank you for your shopping at <span><a href="index.jsp">Shopin!</a></span> See you soon!
            </div>
        </div>
        <div class="row" style="border-bottom: 1px solid #eee; padding-bottom: 16px">
            <div class="col-xs-8" style="border-right: 1px solid #eee;">
                <div class="table-responsive">
                    <h1 style="margin-bottom: 20px; font-family: 'Ubuntu-Regular';">Order Summary</h1>
                    <table class="table-heading simpleCart_shelfItem">
                        <tr>
                            <th class="table-grid">Item</th>

                            <th>Prices</th>
                            <th >Quantity </th>
                            <th> Subtotal</th>
                        </tr>
                    <%                        int i = 0;
                        List<SanPham> products = (List<SanPham>) request.getAttribute("products");
                        List<DonHang> orderedproducts = (List<DonHang>) request.getAttribute("orderedProducts");
                        for (SanPham product : products) {
                            int quantity = orderedproducts.get(i).getSoLuongSP();
                            int price = product.getGiaTien();
                            double subtotal = quantity * price;
                            i++;
                    %>
                    <tr class="cart-header">

                        <td class="ring-in"><a href="product?<%= product.getIdsp()%>" class="at-in"><img src="<%= product.getAnhDaiDien()%>" class="img-responsive" alt=""></a>
                            <div class="sed">
                                <h5><a href="product?<%= product.getIdsp()%>"> <%= product.getTenSanPham()%> </a></h5>
                                <p><%= product.getMoTa()%> </p>

                            </div>
                            <div class="clearfix"> </div>
                        </td>
                        <td>$<%= price%></td>
                        <td><%= quantity%></td>
                        <td class="item_price">$<%= subtotal%></td>
                    </tr>
                    <%
                        }
                    %>
                    <%
                        {
                            GiaoDich order = (GiaoDich) request.getAttribute("orderRecord");
                            double ordertotal = order.getTongThanhToan();
                    %>
                    <tr class="cart-header">

                        <td style="color:#000">Delivery Fee</td>
                        <td></td>
                        <td></td>
                        <td class="item_price" style="color:#000">$${initParam.deliveryFee}</td>
                    </tr>
                    <tr class="cart-header">

                        <td style="font-weight:bold; color:#000; font-size:24px; padding-top: 24px">Total</td>
                        <td></td>
                        <td></td>
                        <td class="item_price" style="font-weight: bold; color:#000; font-size:24px; padding-top: 24px">$<%=ordertotal%></td>
                    </tr>              
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        <div class="col-xs-4">
            <h1 style="margin-bottom: 20px;font-family: 'Ubuntu-Regular';">Delivery Address</h1>
            <%
                {
                    String name = request.getParameter("name");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
            %>
            <div class="form-group" style="font-weight:bold;margin-top: 36px">
                <%= name%>
            </div>
            <div class="form-group" style="font-weight:bold" >
                <%= address%>
            </div>
            <div style="border-top: 1px solid #ddd; border-bottom: none; margin-bottom: 15px"></div>
            <div class="form-group" style="font-weight:bold">
                Email: <%= email%>
            </div>
            <div class="form-group" style="font-weight:bold">
                Telephone number: <%= phone%>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<jsp:include page="brand.jsp"></jsp:include>
