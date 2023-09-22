<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>AddContacts</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>   <%@include file="./WEB-INF/ressources/css/addContact.css"%> </style>
</head>

<%

  String success =  (String)request.getParameter("success");
%>


<body>
<%@include file="navBar.jsp"%>
   
    <div class="container my-4">
        <h2 style ="position : relative ; top : 20px; left :150px;">Add a Contact</h2>
        <br>
        <%
        if (success != null) {
	 %>
           <script> 
                            Swal.fire({
                            icon: 'success',
                            title: 'Success...',
                            text: 'Quote bien saisie!',
                            confirmButtonText: 'OK',
                            allowOutsideClick: false // disable clicking outside of the alert to close it
                            }).then((result) => {
                          
                            });
                        </script>
                    
    <% 

        }    
  %>
 
		<div class="card mb-4">
			<div class="row no-gutters">
              <div class="col-md-8">
                <div class="card-body">
				        <form method="post" action="addContact">
				            <div class="form-group">
				                <label for="firstName"> First Name:</label>
				                <input type="text" class="form-control" id="bookName" name="firstName">
				            </div>
				          

				            <div class="form-group">
				                <label for="lastName">Last Name:</label>
				                <input type="text" class="form-control" id="lastName" name="lastName">
				            </div>
				            <div class="form-group">
				                <label for="userName">UserName</label>
				                <input type="text" class="form-control resize-none" id="quote" name="userName">
				            </div>
				
				  			<div class="form-group">
				                <label for="lastName">Email:</label>
				                <input type="text" class="form-control" id="lastName" name="email">
				            </div>
				              <div class="form-group">
				                <label for="lastName">Adresse:</label>
				                <input type="text" class="form-control" id="lastName" name="adresse">
				            </div>
				              <div class="form-group">
				                <label for="lastName">Phone Number</label>
				                <input type="text" class="form-control" id="lastName" name="phoneNumber">
				            </div>
				              <div class="form-group">
				                <label for="lastName">Date de naissance:</label>
				                <input type="date" class="form-control" id="lastName" name="birthDate">
				            </div>
				            <div class="d-flex justify-content-center">
				                <button type="submit" class="btn btn-primary mx-3">Register</button>
				                <button type="reset" class="btn btn-secondary mx-3">Clear</button>
				            </div>
				        </form>
    </div>
     </div>
      </div>
       </div>
     </div>
     

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        $('.favorite').on('click', function () {
            $(this).toggleClass('active');
        });
    </script>
</body>

</html>