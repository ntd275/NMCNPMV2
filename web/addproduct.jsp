<%-- 
    Document   : card-update-product
    Created on : Dec 8, 2019, 3:40:49 AM
    Author     : tungnk
--%>
<jsp:include page="banner-top.jsp"></jsp:include>
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="addproduct" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="txtNameProduct">Ten san pham:</label>
                    <input type="text" class="form-control" id="txtNameProduct" name="txtNameProduct">
                </div>
                <div class="form-group">
                    <label for="txtbrand">Thuong hieu:</label>
                    <input type="text" class="form-control" id="txtbrand" name="txtbrand">
                </div>
                <label>Loai:</label>
                <select name="txtcategory" class="custom-select">
                    <option selected>bottom</option>
                    <option value="L">top</option>
                    <option value="M">shoes</option>
                </select>
                <div class="form-group">
                    <label for="txtbrand">Gia tien:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtPrice">
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
                    <option selected>S</option>
                    <option value="L">L</option>
                    <option value="M">M</option>
                    <option value="XL">XL</option>
                    <option value="XXL">XXL</option>
                </select>

                <div class="form-group">
                    <label for="txtColor">Mau sac:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtColor">
                </div>
                <div class="form-group">
                    <label for="txtQuanlity">So luong:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtQuanlity">
                </div>
                <div class="form-group">
                    <label for="txtQuanlity">Mo ta:</label>
                    <input type="text" class="form-control" id="txtPrice" name="txtmota">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="submit" class="btn btn-primary">Cancel</button>

            </form>
        </div>
    </div>
</div>

