<%-- 
    Document   : comfirmation
    Created on : Dec 6, 2019, 11:33:06 PM
    Author     : minhh
--%>
<div id="container">
    <div class="one">
        <div class="heading_bg">
            <h2>Confirmation</h2>
        </div>
        <p id="confirmationText">
            <strong><fmt:message key="successMessage" /></strong>
            <br />
            <br />
        <fmt:message key="confirmationNumberMessage"/>
        <strong>${orderRecord.confirmationNumber}</strong>
        <br>
        <fmt:message key="contactMessage"/>
        <br><br>
        <fmt:message key="thankYouMessage"/>
        </p>
    </div>
    <div class="two-third">
        <div class="heading_bg">
            <h3><fmt:message key="orderSummary"/></h3>
        </div>
        <table>
            <th><fmt:message key="product"/></th>
            <th><fmt:message key="quantity"/></th>
            <th><fmt:message key="price"/></th>
            <c:forEach var="orderedProduct" items="${orderedProducts}"
                       varStatus="iter">
                <tr>
                    <td>
                        ${products[iter.index].name}
                    </td>
                    <td>
                        ${orderedProduct.quantity}
                    </td>
                    <td>
                <fmt:formatNumber type="currency"
                                  currencySymbol="&dollar; "
                                  value="${products[iter.index].price
                                           * orderedProduct.quantity}"/>
                </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"><strong><fmt:message
                            key="surcharge"/>:</strong></td>
                <td>
            <fmt:formatNumber type="currency"
                              currencySymbol="&euro; "
                              value="${initParam.deliveryFee}"/></td>
            </tr>
            <tr>
                <td colspan="2"><strong><fmt:message
                            key="total"/>:</strong></td>
                <td>
            <fmt:formatNumber type="currency"
                              currencySymbol="&euro; "
                              value="${orderRecord.amount}"/></td>
            </tr>
            <tr>
                <td colspan="3"><strong><fmt:message
                            key="dateProcessed"/>:</strong>
                        ${orderRecord.dateCreated}
            </tr>
        </table>
    </div>
    <div class="sidebar_right">
        <div class="heading_bg">
            <h3><fmt:message key="deliveryAddress" /></h3>
        </div>
        <table>
            <tr>
                <td colspan="3">
                    ${customer.name}
                    <br>
                    ${customer.address}
                    <br>
            <fmt:message key="city"/> ${customer.cityRegion}
            <br>
            <hr>
            <strong><fmt:message key="email"/>:</strong>
            ${customer.email}
            <br>
            <strong><fmt:message key="phone"/>:</strong>
            ${customer.phone}
            </td>
            </tr>
        </table>
    </div>
    <div style="clear:both; height: 40px"></div>
</div>
