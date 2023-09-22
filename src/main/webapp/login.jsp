<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Connexion</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Square+Peg&display=swap" rel="stylesheet">
</head>
<body>
 <nav>
 <h2 class="logo">Gestion De Contacts</h2>
 </nav>

    <div class="container">
        <form method="post" action="loginServlet">
          
            <div class="txt-field">
                <input type="email" name="email" class="txt-css" required>
                <label>Email</label>
            </div>

            <div class="txt-field">
                <input type="password" name="password" class="txt-css" required>
                <label>Mot de passe</label>
            </div>
            <div>
                <input class="login-btn" type="submit" value="connexion ">
            </div>

            <div class="P1">
                <p>Vous n'avez pas un compte? <a href="servlets/signupServlet" class="sign-in"> S'inscrire </a> </p>
            </div>

        </form>
    </div>

</body>
</html>
<style>
body {
  margin: 0;
  padding: 0;
  background-color: white;
  box-sizing: border-box;
font-family: 'Poppins', sans-serif;
}

span {
  color:blue;


}

.logo {
  float: left;
  color: blue;
  margin-left: 50px;
  margin-top: 20px;
  font-family: 'Square Peg', cursive;
  letter-spacing: 1px;
  font-size:28px;
  transition: tranform .2s linear ;

}
.logo:hover {
transform: scale(1.2);
}

.title {
  text-align: center;
  font-size: 40px;
  position: absolute;
  top: 50px;
  left: 470px;
  transform: translate(-20px , -50px);
  font-family: 'Kanit', sans-serif;



}


.container {
  width: 500px;
  height: 400px;
  background-color: white;
  position: absolute;
  top: 30%;
  left: 30%;
}

.container form {
  padding: 10px 80px;
  box-sizing: border-box;
}

.container form .txt-field {
  margin: 25px 0px  ;
  position: relative;
}

.txt-field .txt-css {
  width: 100%;
  height: 50px;
  border-color: white;
  border-width: 2px;
  outline: none;
  background-color: white;
  transition: .5s;
  color : black;
  padding: 10px 0 0 5px;



}

input[value="Log in"] {
  font-size: 20px;
  font-family: 'poppins';
  font-weight: bold;
}


.txt-field label {
  position: absolute;
  top: 50%;
  left: 6px;
  color: black;
  transform: translateY(-50%);
  pointer-events: none;
  transition: top .4s;
  opacity: 0.7;

}

.txt-field input:focus~label,
.txt-field input:valid~label {
  top: 15px;
  color: blue;
  font-weight: lighter;
  opacity : 100%;
  font-size:17px;

}

.txt-field input:focus {
opacity: 100%;
  border : 2px solid blue;
}

.login-btn {
  width: 100%;
  height: 50px;
  background-color: #171E25;
  margin: 10px 0 0 0px;
  border-radius: 200px;
  border-color: white;
  transition: .2s linear;
  cursor: pointer;
  color: white;
  border-width: 0.1px;
  outline: none;
}

.login-btn:hover {

  transform: scale(1.1);
  border: 2px solid blue;
  color : blue;

}

.P1 {
  margin: 20px;

}

.P1 p {
  color: black;
}

.P1 p  .sign-in  {
  color: blue;
  text-decoration: none;
  font-size : 16px ;
  font-weight: lighter;



}
.P1 p .sign-in:hover {

color : blue;
}
</style>