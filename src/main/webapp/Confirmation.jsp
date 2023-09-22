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


				<div class="card-header bg-primary text-white ">
                      Confirmation </div>
				<div class="card-body">
		
		          <div class="from-group">
	               	<label >ID:</label>
		            <label >${contact.id}</label>
	             </div>
		 <div class="from-group">
	               	<label >Nom:</label>
		            <label >${contact.nom}</label>
	             </div>
	              <div class="from-group">
	               	<label >Prenom:</label>
		            <label >${contact.prenom}</label>
	             </div>
			 <div class="from-group">
	               	<label >Numero Telephone:</label>
		            <label >${contact.numeroTele}</label>
	             </div>
		</div>
		</div>
		</div>

</body>
</html>