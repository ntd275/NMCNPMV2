<%-- 
    Document   : checkout
    Created on : Nov 24, 2019, 8:01:20 PM
    Author     : ntd27
--%>
<%@page import="java.util.List"%>
<%@page import="entity.*"%>

<%    
    session.setAttribute("view", "/detailorder");
    List<DonHang> orders =(List<DonHang>) request.getAttribute("orders");
%>

<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="check-out">
        <div class="container">

            <div class="bs-example4" data-example-id="simple-responsive-table">
                <div class="table-responsive">
                    <table class="table-heading simpleCart_shelfItem">
                        <tr>
                            <th class="table-grid">Item</th>

                            <th>Prices</th>
                            <th >Quantity </th>
                            <th> Subtotal</th>
                        </tr>
                    <%
                            for (DonHang order : orders) {
                    %>
                    <tr class="cart-header">

                        <td class="ring-in"><a href="product?<%= order.getSanPham().getIdsp() %>" class="at-in"><img src="<%= order.getSanPham().getAnhDaiDien() %>" class="img-responsive" alt=""></a>
                            <div class="sed">
                                <h5><a href="product?<%= order.getSanPham().getIdsp()%>"> <%= order.getSanPham().getTenSanPham()%> </a></h5>
                                <p><%= order.getSanPham().getMoTa() %> </p>

                            </div>
                            <div class="clearfix"> </div>
                        </td>
                        <td>$<%= order.getSanPham().getGiaTien()%></td>
                        <td>
                            <form action="update" method="get">
                                    <input type="text" name="num" value="<%= order.getSoLuongSP() %>" style="width: 50%; text-align: center" >
                                    <input type="text" name="id" value="<%=order.getSanPham().getIdsp()%>" hidden>
                            </form>
                        </td>
                        <td class="item_price">$<%=order.getSoLuongSP()*order.getSanPham().getGiaTien() %></td>
    
                    </tr>
                    <%
                            }
                    %>
                </table>
            </div>
            </div>
    </div>
</div>

<jsp:include page="brand.jsp"></jsp:include>