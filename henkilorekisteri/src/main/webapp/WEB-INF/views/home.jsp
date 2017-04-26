<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<%@ page session="false" %>
<html>
<head>
	<title>Henkilörekisteri</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/layouts/home.css" />	

	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a>Henkilölista</a></li>
        <li><a href="asetukset/">Asetukset</a></li>
      </ul><br>
    </div>

    <div class="col-sm-10">
      <h4><small>Henkilölista</small></h4>
      
      	  <table class="table">
		    <tbody>
				<tr>
			        <td>  
					  <a href="lisaaHenkilo/" class="btn" role="button"><i class="fa fa-user-plus" id="faIcon"></i></a>
			        </td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td>
			        </td>
			        <td>
			            <form method="POST" class="search-form">
			                <div class="form-group has-feedback">
			            		<label for="search" class="sr-only">Search</label>
			            		<input type="text" class="form-control" name="name" placeholder="Etsi nimellä">
			              		<span class="glyphicon glyphicon-search form-control-feedback"></span>
			            	</div>
			            </form>
			        </td>
			     </tr>
		    </tbody>
		  </table>
      
		  <table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nimi</th>
		        <th>Henkilötunnus</th>
		        <th>Puhelinnumero</th>
		        <th>Sähköposti</th>
		        <th>Työsuhde alkanut</th>
		        <th>Tilinumero</th>
		        <th>Veronumero</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    <c:forEach var="henkiloListaus" items="${henkiloListaus}">
				<tr>
			        <td>${henkiloListaus.etunimi} ${henkiloListaus.sukunimi} </td>
			        <td>${henkiloListaus.henkilotunnus}</td>
			        <td>${henkiloListaus.puhelinnumero}</td>
			        <td>${henkiloListaus.sahkoposti}</td>
			        <td>${henkiloListaus.tyosuhdealkanut}</td>
			        <td>${henkiloListaus.tilinumero}</td>
			        <td>${henkiloListaus.veronumero}</td>
			        <td><a href="muokkaaHenkilo/${henkiloListaus.henkilotunnus}"><span class="glyphicon glyphicon-edit" id="faIcon"></span></a></td>
			     </tr>
			</c:forEach>
		      
		    </tbody>
		  </table>
    </div>
  </div>
</div>
</body>
</html>
