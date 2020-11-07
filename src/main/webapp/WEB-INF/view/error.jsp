<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>${errorCode}</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Fredoka+One" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Raleway:400,700" rel="stylesheet">

	<!-- Custom CSS styling -->
	<style>
		* {
		  -webkit-box-sizing: border-box;
          box-sizing: border-box;
		}

		body {
		  padding: 0;
		  margin: 0;
		}

		#notfound {
		  position: relative;
		  height: 100vh;
		}

		#notfound .notfound {
		  position: absolute;
		  left: 50%;
		  top: 50%;
		  -webkit-transform: translate(-50%, -50%);
			  -ms-transform: translate(-50%, -50%);
				  transform: translate(-50%, -50%);
		}

		.notfound {
		  max-width: 710px;
		  width: 100%;
		  text-align: center;
		  padding: 0px 15px;
		  line-height: 1.4;
		}

		.notfound .notfound-404 {
		  height: 200px;
		  line-height: 200px;
		}

		.notfound .notfound-404 h1 {
		  font-family: 'Fredoka One', cursive;
		  font-size: 168px;
		  margin: 0px;
		  color: #103160;
		  text-transform: uppercase;
		}

		.notfound h2 {
		  font-family: 'Raleway', sans-serif;
		  font-size: 22px;
		  font-weight: 400;
		  color: #103160;
		  margin: 0;
		}
		
		.notfound a {
		  font-family: 'Raleway', sans-serif;
		  display: inline-block;
		  font-weight: 700;
		  border-radius: 15px;
		  text-decoration: none;
		  color: #39b1cb;
		}

		.notfound a>.arrow {
		  position: relative;
		  top: -2px;
		  border: solid #39b1cb;
		  border-width: 0 3px 3px 0;
		  display: inline-block;
		  padding: 3px;
		  -webkit-transform: rotate(135deg);
			  -ms-transform: rotate(135deg);
				  transform: rotate(135deg);
		}

		@media only screen and (max-width: 767px) {
		  .notfound .notfound-404 {
			height: 122px;
			line-height: 122px;
		  }
		  .notfound .notfound-404 h1 {
			font-size: 122px;
		  }
		}
	</style>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>${errorCode}</h1>
			</div>
			<h2>${errorMessage}</h2>
			<a href="${pageContext.request.contextPath}" ><span class="arrow"></span>Return To Homepage</a>
		</div>
	</div>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
