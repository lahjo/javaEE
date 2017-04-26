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
        <li><a href="/henkilorekisteri/">Henkilölista</a></li>
        <li><a href="/henkilorekisteri/asetukset/">Asetukset</a></li>
      </ul><br>
    </div>

    <div class="col-sm-10">
      <h4><small>Lisää uusi henkilö</small></h4>
      <hr>
       	 	 	 	
      <!--  -->
	          <div class="panel panel-info">
	            <div class="panel-heading">
	              <h3 class="panel-title">Uusi henkilö</h3>
	            </div>
	            <form method="POST">
	            <div class="panel-body">
	              <div class="row">
	                <div class=" col-md-9 col-lg-9 "> 
	                  <table class="table table-user-information">
	                    <tbody>
	                      <tr>
	                        <td>Etunimi</td>
	                        <td><input class="form-control" name="etunimi" placeholder="Etunimi" type="text" required="required"></td>
	                      </tr>
	                      <tr>
	                        <td>Sukunimi:</td>
	                        <td><input class="form-control" name="sukunimi" placeholder="Sukunimi" type="text" required="required"></td>
	                      </tr>
	                      <tr>
	                        <td>Henkilötunnus</td>
	                        <td><input class="form-control" name="henkilotunnus" placeholder="Henkilötunnus" type="text" required="required"></td>
	                      </tr>
	                   
	                         <tr>
	                             <tr>
	                        <td>työsuhde alkanut</td>
	                        <td>
	                        <div class="input-group">
					        <div class="input-group-addon">
					         <i class="fa fa-calendar">
					         </i>
					        </div>
					        <input class="form-control" id="date" name="tyosuhdealkanut" placeholder="VVVV-KK-PP" type="text" required="required">
					       </div>
	                        </td>
	                      </tr>
	                        <tr>
	                        <td>Tilinumero</td>
	                        <td><input class="form-control" name="tilinumero" placeholder="Tilinumero" type="text" required="required"></td>
	                      </tr>
	                      <tr>
	                        <td>veronumero</td>
	                        <td><input class="form-control" name="veronumero" placeholder="Veronumero" type="text" required="required"></td>
	                      </tr>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
	            </div>
	                 <div class="panel-footer">
                 		<button type="submit" class="btn btn-success">
						   <span class="glyphicon glyphicon-ok"></span>
						</button>
                    </div>
                </form>
	            
	          </div>
      <!--  -->
      
    </div>
  </div>
</div>
</body>
</html>
