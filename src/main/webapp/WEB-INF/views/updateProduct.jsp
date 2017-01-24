<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="page-header">
        <h1>Update product</h1>

        <p>Update existing product</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/admin/product/updateProduct" method="post"
               commandName="product" enctype="multipart/form-data">
    <form:hidden path="pId" value="${product.pId}" />

    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="prodName" id="name" class="form-control" value="${product.prodName}" />
    </div>
    <div class="form-group">
        <label for="condition">Condition</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                         value="new" />New</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                         value="used" />Used</label>
    </div>

    <div class="form-group">
        <label for="details">Details</label>
        <form:textarea path="productDetails" id="details" class="form-control"  value="${product.productDetails}"/>
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <label class="checkbox-inline"><form:radiobutton path="productManufacturer" id="manufacturer"
                                                         value="dell" />Dell</label>
        <label class="checkbox-inline"><form:radiobutton path="productManufacturer" id="manufacturer"
                                                         value="xerox" />Xerox</label>
        <label class="checkbox-inline"><form:radiobutton path="productManufacturer" id="manufacturer"
                                                         value="hp" />HP</label>
    </div>

    <div class="form-group">
        <label for="category">Category</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="printer" />Printer</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="monitor" />Monitor</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="keyboard" />Keyboard</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="mouse" />Mouse</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="desktop" />Desktop</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="laptop" />Laptop</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="battery" />Battery</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="docking station" />Docking station</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="bags" />Bags</label>
        <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                         value="kvm" />KVM</label>
    </div>

    <div class="form-group">
        <label for="stock">Stock</label>
        <form:textarea path="unitCount" id="stock" class="form-control"  value="${product.unitCount}"/>
    </div>

    <div class="form-group">
        <label class="control-label" for="productImage">Upload image</label>
        <form:input id="productImage" path="prodImage" type="file" class="form:input-large" />
    </div>

    <br><br>
    <input type="submit" value="update" class="btn btn-default">
    <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>

    </form:form>
