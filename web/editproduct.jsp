<%-- 
    Document   : card-update-product
    Created on : Dec 8, 2019, 3:40:49 AM
    Author     : tungnk
--%>

<%@page import="java.util.List"%>
<%@page import="entity.SanPham"%>
<%
    SanPham p =(SanPham)session.getAttribute("product");
%>
<jsp:include page="banner-top.jsp"></jsp:include>
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="updateproduct" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="txtNameProduct">Ten san pham:</label>
                    <input type="text" class="form-control" id="txtNameProduct" name="txtNameProduct" value="<%=p.getTenSanPham() %>">
                </div>
                <div class="form-group">
                    <label for="txtbrand">Thuong hieu:</label>
                    <input type="text" class="form-control" id="txtbrand" name="txtbrand" value="<%= p.getThuongHieu() %>">
                </div>
                <label>Loai:</label>
                <select name="txtcategory" class="custom-select">
                    <option <% if(p.getLoai().equals("bottom")) { %> selected <% } %> ) value="bottom">bottom</option>
                    <option <% if(p.getLoai().equals("top")) { %> selected <% } %>value="top">top</option>
                    <option <% if(p.getLoai().equals("shoes")) { %> selected <% } %>value="shoes">shoes</option>
                </select>
                <div class="form-group">
                    <label for="txtbrand">Gia tien:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtPrice" value="<%= p.getGiaTien()%>">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Anh dai dien</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="AnhDaiDien">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Anh 1</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="Anh1">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Anh 2</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="Anh2">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Anh 3</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="Anh3">
                </div>
                <label>Kich thuoc:</label>
                <select name="size" class="custom-select">
                    <option <% if(p.getSize().equals("S")) { %> selected <% } %> value="S">S</option>
                    <option <% if(p.getSize().equals("L")) { %> selected <% } %> value="L">L</option>
                    <option <% if(p.getSize().equals("M")) { %> selected <% } %> value="M">M</option>
                    <option <% if(p.getSize().equals("XL")) { %> selected <% } %> value="XL">XL</option>
                    <option <% if(p.getSize().equals("XXL")) { %> selected <% } %> value="XXL">XXL</option>
                </select>

                <div class="form-group">
                    <label for="txtColor">Mau sac:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtColor" value="<%= p.getMauSac() %>">
                </div>
                <div class="form-group">
                    <label for="txtQuanlity">So luong:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtQuanlity" value="<%= p.getSoLuong()%>">
                </div>
                <div class="form-group">
                    <label for="txtQuanlity">Mo ta:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtmota" value="<%=p.getMoTa()%>">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="submit" class="btn btn-primary">Cancel</button>

            </form>
        </div>
    </div>
</div>

