<%-- 
    Document   : single
    Created on : Nov 24, 2019, 8:08:38 PM
    Author     : ntd27
--%>
<%@page import="java.util.List"%>
<%@page import="entity.SanPham"%>
<%@page import="entity.LinkAnh"%>
<%    session.setAttribute("view", "/preview");
    SanPham p = (SanPham) session.getAttribute("product");
    LinkAnh pd = (LinkAnh) session.getAttribute("images");
%>
<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="single">
        <div class="container">
            <div class="col-md">
                <div class="col-md-5 grid">		
                    <div class="flexslider">
                        <ul class="slides">
                            <li data-thumb="<%= pd.getAnh1()%>">
                            <div class="thumb-image"> <img src="<%= pd.getAnh1()%>" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="<%= pd.getAnh2()%>">
                            <div class="thumb-image"> <img src="<%= pd.getAnh2()%>" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="<%= pd.getAnh3()%>">
                            <div class="thumb-image"> <img src="<%= pd.getAnh3()%>" data-imagezoom="true" class="img-responsive"> </div>
                        </li> 
                    </ul>
                </div>
            </div>	
            <div class="col-md-7 single-top-in">
                <div class="span_2_of_a1 simpleCart_shelfItem">
                    <h3><%= p.getTenSanPham()%></h3>
                    <p class="in-para"> There are many variations of passages of Lorem Ipsum.</p>
                    <div class="price_single">
                        <span class="reducedfrom item_price">$<%= p.getGiaTien()%></span>

                        <div class="clearfix"></div>
                    </div>


                    <div class="quantity"> 
                        <div class="quantity-select">                           
                            <div class="entry value-minus">&nbsp;</div>
                            <div class="entry value"><span>1</span></div>
                            <div class="entry value-plus active">&nbsp;</div>
                        </div>
                    </div>
                    <!--quantity-->
                    <script>
                        $('.value-plus').on('click', function () {
                            var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) + 1;
                            divUpd.text(newVal);
                        });

                        $('.value-minus').on('click', function () {
                            var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) - 1;
                            if (newVal >= 1)
                                divUpd.text(newVal);
                        });
                    </script>
                    <!--quantity-->

                    <a href="#" class="add-to item_add hvr-skew-backward">Add to cart</a>
                    <div class="clearfix"> </div>
                </div>

            </div>
            <div class="clearfix"> </div>
            <!---->
            <div class="tab-head">
                <nav class="nav-sidebar">
                    <ul class="nav tabs">
                        <li class="active"><a href="#tab1" data-toggle="tab">Product Description</a></li>
                        <li class=""><a href="#tab2" data-toggle="tab">Brand</a></li> 
                        <li class=""><a href="#tab3" data-toggle="tab">Category</a></li>  
                    </ul>
                </nav>
                <div class="tab-content one">
                    <div class="tab-pane active text-style" id="tab1">
                        <div class="facts">
                            <p ><%=p.getMoTa()%></p>        
                        </div>

                    </div>
                    <div class="tab-pane text-style" id="tab2">

                        <div class="facts">
                            <p ><%=p.getThuongHieu()%></p>        
                        </div>

                    </div>
                    <div class="tab-pane text-style" id="tab3">

                        <div class="facts">
                            <div class="facts">
                                <p ><%=p.getLoai()%></p>        
                            </div>
                        </div>	

                    </div>

                </div>
                <div class="clearfix"></div>
            </div>
            <!---->	
        </div>
        <!----->

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <div class="row"> 
            <div align="center">
                <button class="btn btn-primary" onclick="goBack()">Cancel</button>
                <a href="<%if("1".equals((String)request.getAttribute("update"))){%>updateproducttodb<% }else{ %>addproducttodb<%}%>" class="btn btn-primary">Save</a>
            </div>
            <div>
                <div class="clearfix"></div>
            </div>
            <jsp:include page="brand.jsp"></jsp:include>
        </div>
        <script src="js/imagezoom.js"></script>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script defer src="js/jquery.flexslider.js"></script>
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

        <script>
            // Can also be used with $(document).ready()
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide",
                    controlNav: "thumbnails"
                });
            });
        </script>