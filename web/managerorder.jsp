<%-- 
    Document   : managerorder
    Created on : Dec 9, 2019, 6:55:20 AM
    Author     : ntd27
--%>
<%@page import="java.util.List"%>
<%@page import="entity.*"%>
<%    
    session.setAttribute("view", "/managerorder");
%>

<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="check-out">
        <div class="container">

            <div class="bs-example4" data-example-id="simple-responsive-table">
                <div class="table-responsive">
                    <table class="table-heading simpleCart_shelfItem">
                        <tr>
                            <th class="table-grid">Ma GD</th>
                            <th>IDKH</th>
                            <th>Dia Chi Nhan Hang </th>
                            <th>Tong Thanh Toan</th>
                            <th>Email</th>
                            <th>So Dien Thoai</th>
                            <th>Trang Thai</th>
                            <th></th>
                            <th></th>
                        </tr>
                    <%
                        List<DonHang> orders = (List<DonHang>) session.getAttribute("ordered");
                        for (DonHang order : orders) {
                    %>
                    <tr class="cart-header">
                        <td><%=order.getDonHangPK().getMaGiaoDich()%></td>
                        <td><%=order.getGiaoDich().getIdkh().getIdkh()%></td>
                        <td><%=order.getGiaoDich().getDiaChiNhanHang()%></td>
                        <td><%=order.getGiaoDich().getTongThanhToan()%></td>
                        <td><%=order.getGiaoDich().getIdkh().getEmail()%></td>
                        <td><%=order.getGiaoDich().getIdkh().getSoDT()%></td>
                        <td><%=order.getTrangThai()%> </td>
                        <%
                            if (order.getTrangThai().equals("Dang giao")) {
                        %>
                        <td><a class="btn btn-primary" href="giaohang?idsp=<%=order.getSanPham().getIdsp()%>&magd=<%=order.getGiaoDich().getMaGiaoDich()%>">Giao Hang</a></td>
                        <%
                        } else {
                        %>
                        <td></td>
                        <%
                            }
                        %>
                        <td><a class="btn btn-primary" href="deleteorder?idsp=<%=order.getSanPham().getIdsp()%>&magd=<%=order.getGiaoDich().getMaGiaoDich()%>">Xoa</a> </td>
                        <td> <a href="detailorder?idgd=<%=order.getDonHangPK().getMaGiaoDich()%>">Detail</a></td>
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