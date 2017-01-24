<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<div class="container">
  <div class="page-header">
    <h1>All deskside locations</h1>
  </div>
  <table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
      <th>Site</th>
      <th>View stock</th>
    </tr>
    </thead>
    <c:forEach items="${siteList}" var="siteList">
      <tr>
        <td>${siteList.siteName}</td>
        <td><a href="<spring:url value="/admin/siteList/siteStock/${siteList.siteName}" />"><span class="glyphicon glyphicon-circle-arrow-right"></span></a> </td>
      </tr>
    </c:forEach>
  </table>
</div>

<hr>

<%@include file="template/footer.jsp"%>

