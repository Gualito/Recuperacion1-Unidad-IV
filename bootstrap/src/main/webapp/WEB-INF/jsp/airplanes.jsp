<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Airplane Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-airplane">New Airplane</a></li>
					<li><a href="all-airplanes">All Airplanes</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Airplane Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_AIRPLANES'}">
			<div class="container text-center" id="aiprlanesDiv">
				<h3>My airplanes</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Color</th>
								<th>fly Date</th>
								<th>active</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="ariplane" items="${airplanes}">
									<tr>
										<td>${airplane.id}</td>
										<td>${airplane.name}</td>
										<td>${airplane.color}</td>
										<td>
											<fmt:formatDate pattern="dd-MM-yyyy" value="${aiplane.flydate}"/>
										</td>
										<td>${airplane.active==true?"YES":"NO"}</td>
										
										<td>
											<a href="update-airplane?id=${airplane.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-airplane?id=${airplane.id}">
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
				<h3>Manage Airplane</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-airplane">
					<input type="hidden" name="id" value="${airplane.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Name:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="name" value="${airplane.name }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Color:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="color" value="${airplane.color }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Active:</label>
							<div class="col-sm-7">
								<input type="radio" class="col-sm-1" name="active" value="true"/>
								<div class="col-sm-1">YES</div>
									<input type="radio" class="col-sm-1" name="active" value="false"checked="checked"/>
								<div class="col-sm-1">No</div>
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