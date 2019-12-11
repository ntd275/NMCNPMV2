<%-- 
    Document   : product
    Created on : Nov 24, 2019, 8:03:46 PM
    Author     : ntd27
--%>


<%@page import="java.util.List"%>
<%@page import="entity.SanPham"%>
<%    
    session.setAttribute("view", "/category?cat="+(String)request.getAttribute("cat")+"&page="+(String)request.getParameter("page"));
%>
<jsp:include page="banner-top.jsp"></jsp:include>
    <div class="product">
        <div class="container">
            <div class="col-sm">
                <div class="mid-popular">
                <%if (session.getAttribute("try").equals("false")) {%>    
                <% List<SanPham> categoryProducts = (List<SanPham>) session.getAttribute("categoryProducts");
                    int index = 0;
                    for (SanPham product : categoryProducts) {
                        index++;
                        if (index % 3 == 0) {
                %>
                <div class ="row">
                    <%
                        }

                    %>

                    <div class="col-md-4 item-grid1">
                        <div class=" mid-pop">
                            <div class="pro-img">
                                <img src="<%=product.getAnhDaiDien()%>" class="img-responsive" alt="">
                                <div class="zoom-icon ">
                                    <a class="picture" href="<%=product.getAnhDaiDien()%>" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                    <a href="product?<%=product.getIdsp()%>"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                                </div>
                            </div>
                            <div class="mid-1">
                                <div class="women">
                                    <div class="women-top">
                                        <span><%=product.getLoai()%></span>
                                        <h6><a href="product?<%=product.getIdsp()%>"><%=product.getTenSanPham()%></a></h6>
                                    </div>
                                    <div class="img item_add">
                                        <a href="addToCart?id=<%=product.getIdsp()%>"><img src="images/ca.png" alt=""></a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="mid-2">
                                    <p ><em class="item_price">$<%=product.getGiaTien()%></em></p>
                                    <div class="block">
                                        <div class="starbox small ghosting"> </div>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <%
                        if (index % 3 == 0) {
                    %>
                </div class ="row">
                <%
                        }
                    }
                } else {

                    List<SanPham> categoryProducts = (List<SanPham>) session.getAttribute("categoryProducts");
                    int index = 0;
                    for (SanPham product : categoryProducts) {
                        index++;
                        if (index % 3 == 0) {
                %>
                <div class ="row">
                    <%
                        }

                    %>

                    <div class="col-md-4 item-grid1">
                        <div class=" mid-pop">
                            <div class="pro-img">
                                <img src="<%=product.getAnhDaiDien()%>" class="img-responsive" alt="">
                                <div class="zoom-icon ">
                                    <a class="picture" href="<%=product.getAnhDaiDien()%>" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                    <a href="product?<%=product.getIdsp()%>"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                                </div>
                            </div>
                            <div class="mid-1">
                                <div class="women">
                                    <div class="women-top">
                                        <span>${product.getLoai()}</span>
                                        <h6><a href="product?<%=product.getIdsp()%>"><%=product.getTenSanPham()%></a></h6>
                                    </div>
                                    <div class="img item_add">
                                        <a  href="tryOn?<%=product.getIdsp()%>"><img src="images/try.png" alt=""></a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="mid-2">
                                    <p ><em class="item_price">$<%=product.getGiaTien()%></em></p>
                                    <div class="block">
                                        <div class="starbox small ghos ting"> </div>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <%
                        if (index % 3 == 0) {
                    %>
                </div class ="row">
                <%
                            }
                        }
                    }
                %>
                <div class="clearfix"></div>
            </div>
            <%
                int pagenumber = -1;
                pagenumber = (Integer) request.getAttribute("page");
                int numberpage = (Integer) request.getAttribute("numberpage");
                String catid = (String) request.getAttribute("cat");
                if ((pagenumber >= 1) && (pagenumber <= numberpage)) {
            %>     
            <div> <nav aria-label="Page navigation" >
                    <ul class="pagination" style="    position: absolute;left: 50%; transform: translateX(-50%);">
                        <%
                            if (pagenumber > 1) {
                        %>
                        <li class="page-item ">
                            <a class="page-link" href="category?cat=<%= catid%>&page=1"><<</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link"  href="category?cat=<%= catid%>&page=<%= pagenumber - 1%>"><</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="category?cat=<%= catid%>&page=<%= pagenumber - 1%>"><%= pagenumber - 1%></a>
                        </li>
                        <%
                            }
                        %>
                        <li class="page-item  active">
                            <a class="page-link"><%= pagenumber%><span class="sr-only">(current)</span></a>
                        </li>
                        <%
                            if (pagenumber < numberpage) {
                        %>
                        <li class="page-item">
                            <a class="page-link" href="category?cat=<%= catid%>&page=<%= pagenumber + 1%>"><%= pagenumber + 1%></a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link"  href="category?cat=<%= catid%>&page=<%= pagenumber + 1%>">></a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="category?cat=<%= catid%>&page=<%= numberpage%>">>></a>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </nav>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="container">
            <jsp:include page="brand.jsp"></jsp:include>
        </div>
        <script src="js/jquery.chocolat.js"></script>
        <link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
        <!--light-box-files -->
        <script type="text/javascript" charset="utf-8">
            $(function () {
                $('a.picture').Chocolat();
            });
            $('.pagination li').click(function () {
                $(this).addClass('active').siblings().removeClass('active');
            });
        </script>

    </div>
