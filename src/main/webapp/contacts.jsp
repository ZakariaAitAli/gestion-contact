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


				<div class="card-header bg-primary text-white ">Gestion
                          de contacts </div>
				<div class="card-body">
		<form action="chercher.do" method="get">
		<label>Rechercher</label>
		<input type="text" name="motCle"/>
		<button type="submit" class="btn btn-primary">Chercher</button>
		</form>
	<table class="table table-striped">
		 <tr>
		<th>ID</th><th>NOM</th><th>PRENOM</th><th>NUMEROTELE </th>
		</tr> 
		 <c:forEach items="${model.contacts }" var="c">
		<tr>
		<td>${c.id }</td>
		<td>${c.nom }</td>
		<td>${c.prenom }</td>
		<td>${c.numeroTele }</td>
		<td><a onclick="return confirm('Etes-vous certain de supprimer?')" href="Supprime.do?id=${c.id}">Supprimer</a></td>
		<td><a href="Edit.do?id=${c.id}">Edit</a></td>
		</tr>
		</c:forEach> 
		</table>
			</div>
		</div>
		</div>
		</div>

</body>
</html>