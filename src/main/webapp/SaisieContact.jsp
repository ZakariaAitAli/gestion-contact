<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Contacts</title>
<meta charset="utf-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
<%@include file="header.jsp" %>
<p></p>
	<div class="container">
		<div class="col-md-6 col-xs-12 col-sm-6 offset-md-3">
			<div class="card border-primary">


				<div class="card-header bg-primary text-white ">Saisie de 
                      contacts    </div>
				<div class="card-body">
		<form action="SaveContact.do" method="post">
		<div class="from-group">
		<label class="control-label">Nom</label>
		<input type="text" name="nom" class="form-control"/>
		<span></span>
			</div>
			<div class="from-group">
		<label class="control-label">Prenom</label>
		<input type="text" name="prenom" class="form-control"/>
		<span></span>
			</div>
			<div class="from-group">
		<label class="control-label">Numero de Telephone</label>
		<input type="text" name="numeroTele" class="form-control"/>
		<span></span>
			</div>
			<div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
		</div>
		</div>

</body>
</html>