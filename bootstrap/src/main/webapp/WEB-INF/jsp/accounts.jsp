<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Accounts Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-account">New Account</a></li>
					<li><a href="all-accounts">All Account</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Account Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_ACCOUNTS'}">
			<div class="container text-center" id="accountsDiv">
				<h3>My Accounts</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Surname</th>
								<th>email</th>
								<th>phone</th>
								<th>Password</th>
								
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="account" items="${accounts}">
									<tr>
										<td>${account.id}</td>
										<td>${account.name}</td>
										<td>${account.surname}</td>
										<td>${account.email}</td>
										<td>${account.phone}</td>
										<td>${account.password}</td>
										
								
										
										<td>
											<a href="update-account?id=${account.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-account?id=${account.id}">
												<span class="glyphicon glyphicon-trash"></span>
											</a>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Account</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-account">
					<input type="hidden" name="id" value="${account.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Name:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="name" value="${account.name}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Surname:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="surname" value="${account.surname }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Email:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="email" value="${account.email }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Phone:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="phone" value="${account.phone }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Password:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="password" value="${account.password }" />
							</div>
						</div>
					
						
	
						
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
						
				</form>
			</div>
		
		</c:when>
		
		
		
	</c:choose>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	

</body>
</html>