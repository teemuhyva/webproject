<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>

<div class="container-wrapper">
  <div class="container">
    <div id="login-box">

      <h2>Login with username and password</h2>

      <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
        <div class="form-group">
          <label for="username">User: </label>
          <input type="text" id="username" name="username" class="form-control" />
        </div>
        <div class="form-group">
          <label for="password">Password: </label>
          <input type="password" id="password" name="password" class="form-control" />
        </div>

        <input type="submit" value="Login" class="btn btn-default">
        <input type="hidden" name="${_csrf.parameter}" value="${_csrf.token}" />
      </form>
    </div>
  </div>
</div>

<%@include file="template/footer.jsp"%>