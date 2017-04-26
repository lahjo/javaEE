<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a>Henkilölista</a></li>
        <li><a>Asetukset</a></li>
      </ul><br>
    </div>

    <div class="col-sm-9">
      <h4><small>Henkilölista</small></h4>
      <hr>
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nimi</th>
		        <th>Henkilötunnus</th>
		        <th>puhelinnumero</th>
		        <th>työsuhde alkanut</th>
		        <th>Tilinumero</th>
		        <th>veronumero</th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    <c:forEach var="henkiloListaus" items="${henkiloListaus}">
				<tr>
			        <td>${henkiloListaus.etunimi} ${henkiloListaus.sukunimi} </td>
			        <td>${henkiloListaus.henkilotunnus}</td>
			        <td>${henkiloListaus.puhelinnumero}</td>
			        <td>${henkiloListaus.tyosuhdealkanut}</td>
			        <td>${henkiloListaus.tilinumero}</td>
			        <td>${henkiloListaus.veronumero}</td>
			     </tr>
			</c:forEach>
		      
		    </tbody>
		  </table>
    </div>
  </div>
</div>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
