<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.time.LocalDateTime"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Book Quotes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
<%@ include file="./WEB-INF/ressources/css/myContacts.css"%></style>
</head>
<%
/*
ArrayList<contacts> contacts = new ArrayList<>();
quotes = (ArrayList<contacts>) request.getAttribute("contacts");
String email = (String) session.getAttribute("email");*/
%>
<body>


	<%@include file="navBar.jsp"%>

	
	<div class="container my-4">
		<div class="card mb-4">
			<div class="row no-gutters">
				<div class="col-md-4">
					 <img src=""
                        class="card-img" alt="IMAGE">
				</div>
				<div class="col-md-8">
					<div class="card-body">
					    <h5 class="card-title" id="contact"></h5>
                    
                        <p class="card-text"><small class="text-muted">Full Name : Mohamed  </small></p>
                        <p class="card-text"><small class="text-muted">UserName: Fatehi </small></p>
                        <p class="card-text"><small class="text-muted">Email :test@glail </small></p>
                        <p class="card-text"><small class="text-muted">PhoneNumber : 06776820<a href="profile?email=">></a></small></p>
						<br><a href="#" class="card-link edit-quote" data-toggle="modal"
							data-target="#editQuoteModal" data-quote-text=""
							data-first-name=">"
							data-last-name=""
							data-user-name=""
							data-email=""
							data-adresse=""
							data-birth-date=""
							data-idUser =""><i class="fas fa-edit"></i>
							Edit</a>
					</div>
					
				</div>

	
			</div>
	
		</div>
	
	</div>


	<div class="modal fade" id="editQuoteModal" tabindex="-1" role="dialog"
		aria-labelledby="editQuoteModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editQuoteModalLabel">Edit Contact</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="post" action="myContacts">
				<div class="modal-body">
					
						<div class="form-group">
							<label for="quoteText">FirstName</label>
							<textarea class="form-control" id="firstName" rows="3" placeholder ="" name="firstName"></textarea>
						</div>
						<div class="form-group">
							<label for="bookTitle">Last Name </label> 
							<input type="text" class="form-control" id="lastName" placeholder ="" name="lastName">
						</div>
						<div class="form-group">
							<label for="publishedYear">UserName </label>
							 <input type="text" class="form-control" id="userName" placeholder ="" name="UserName">
						</div>
						<div class="form-group">
							<label for="publishedYear">Email </label>
							 <input type="text" class="form-control" id="email" placeholder ="" name="email">
						</div>
						<div class="form-group">
							<label for="publishedYear">Adresse </label>
							 <input type="text" class="form-control" id="adresse" placeholder ="" name="adresse">
						</div>
						<div class="form-group">
							<label for="publishedYear">Date de naissance </label>
							 <input type="text" class="form-control" id="birthDate" placeholder ="" name="birthDate">
						</div>
						
						<div class="form-group">
							 <input type="hidden" class="form-control" id="idUser" value="" name="idUser">
							
						</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save changes</button>
				</div>
				</form>
			</div>
		</div>
		
	</div>

	
<script>
const editButtons = document.querySelectorAll('.edit-quote');
editButtons.forEach(button => {
  button.addEventListener('click', event => {
    const firstName = button.dataset.firstName;
    const lastName = button.dataset.lastName;
    const userName = button.dataset.userName;
    const email   = button.dataset.email ; 
    const adresse    = button.dataset.adresse ; 
    const phoneNumber   = button.dataset.phoneNumber ; 
    const dateNaissance   = button.dataset.dateNaissance;
    const idUser = button.dataset.idUser ; 
   
    document.querySelector('#firstName').placeholder = firstName;
    document.querySelector('#lastName').placeholder = lastName;
    document.querySelector('#userName').placeholder = userName;
    document.querySelector('#email').value = email;
    document.querySelector('#adresse').value = adresse;
    document.querySelector('#phoneNumber').value = phoneNumber;
    document.querySelector('#dateNaissace').value = dateNaissane;
    document.querySelector('#idUser').value = idUser;
  });
});

</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script>
		$('.favorite').on('click', function() {
			$(this).toggleClass('active');
		});
		// Get a reference to the edit button
		// Add a click event listener to the "Edit" button
	</script>
	
</body>
</html>
