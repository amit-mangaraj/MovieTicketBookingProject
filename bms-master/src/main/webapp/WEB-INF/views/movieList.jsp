
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="playerform.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/ui-darkness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
<!-- 	<style>
	.header{
	text-align:center;
	
	margin: 5px 600px 0 700px;
	background-color:#1e9aca;
	border: solid;
	
}

.footer{
	text-align:center;
	padding: 20px;
	margin: 5px 600px 0 700px;
	background-color:#1e9aca;
	border: solid;
	
}
.f{
	text-align:center;
	margin: 5px 600px 0 700px;
	background-color:#87CEEB;
	border:solid;
	padding-right: 0px;
	
}

.t {
	margin-left: auto;
	
	
  }

td{
	text-align: left;
}
		
	</style> -->
	<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}
table {
  border-collapse: collapse;
  width: 100%;
}
tr:hover {background-color: lightblue;}
tr th{background-color: orange;}
tr td a button:hover{background-color: lightgreen;}
 tr td a .delete:hover{
background-color: red;
}
th, td {
  padding: 15px;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#" style="color: red">BookMyMovie</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown link
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/demoproject"
        user="root" password="admin"
    />

<sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM movie;
    </sql:query>
​

	<form action="addbook" method="POST">
	
	<table border="1" cellpadding="10">
        <thead>
            <tr>
               
                <th>Movie ID</th>
                <th>Cast</th>
                <th>Movie Name</th>
                <th>Date</th>
                <th>Ticket Price</th>
                <th>click</th>
                
                 
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="user" items="${listUsers.rows}">
                <tr>
                 <td><c:out value="${user.movie_id }" /></td>
                  <td><c:out value="${user.cast}" /></td>
                   <td><c:out value="${user.movie_name}" /></td>
                    <td><c:out value="${user.release_date}" /></td>
                     <td><c:out value="${user.price}" /></td>
                    
                    <td>
                   <%-- <a th:href="@{'/Book/' + ${user.movie_id}}">Book Now</a> --%> 
                   <input type="submit" value="Book"><br><br>
                </td>
                </tr>
            </c:forEach>
            <%-- <tr th:each="Movie : ${list}">
                <td th:text="${Movie.MovieId}"></td>
                <td th:text="${Movie.cast}"></td>
                <td th:text="${Movie.movieName}"></td>
                <td th:text="${Movie.releaseDate}"></td>
             
            </tr> --%>
        </tbody>
    </table>
	</form>
	
	 
</body>
</html>




