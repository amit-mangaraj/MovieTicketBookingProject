
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
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="playerform.css">
     <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/ui-darkness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
         <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
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

  body {
        text-align: center;
        padding: 40px 0;
        background: #EBF0F5;
      }
        h1 {
          color: #88B04B;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-weight: 900;
          font-size: 40px;
          margin-bottom: 10px;
        }
        p {
          color: #404F5E;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-size:20px;
          margin: 0;
        }
      i {
        color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
        
      }
      .card {
        background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
        margin-bottom=2rem;
      }
</style>
</head>
<body>
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
       <li class="nav-item">
       <form action="invalidate" method="post">
			<input type="submit" value="Destroy Session" />
		</form>
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
  <div class="card">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
       <i class="checkmark">✓</i>
      </div>
        <h1>Success</h1> 
        <p>We received your purchase request;<br/> we'll be in touch shortly!</p>
</div>
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/demoproject"
        user="root" password="admin"
    />

<sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM checkout ORDER BY checkid DESC LIMIT 1;
    </sql:query>
​
	
	<form action="addcheck" method="POST">
	
	<table border="1" cellpadding="10">
        <thead>
            <tr>
               
                <th>Check ID</th>
                <th>Address</th>
                <th>City</th>
                <th>Email</th>
                <th>Paid By</th>
                <th>Amount Paid</th>
                
                 
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="user" items="${listUsers.rows}">
                <tr>
                 <td><c:out value="${user.checkid }" /></td>
                  <td><c:out value="${user.address}" /></td>
                   <td><c:out value="${user.city}" /></td>
                    <td><c:out value="${user.email}" /></td>
                     <td><c:out value="${user.fullname}" /></td>
                     <td><c:out value="${user.total}" /></td>
                    <td>
                   <%-- <a th:href="@{'/Book/' + ${user.movie_id}}">Book Now</a> --%> 
                   <!-- <input type="submit" value="Book"><br><br> -->
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




