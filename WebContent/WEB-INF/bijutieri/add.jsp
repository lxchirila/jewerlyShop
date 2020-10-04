<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/common/head.jsp"/>  
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
   <jsp:include page="/WEB-INF/common/side-menu.jsp"/>
   <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Bijutieri</h1>
          </div>
          <div class="col-sm-6">
           
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Adaugare Bijutier</h3>         
        </div>
        <div class="card-body">
        <form:form action="creare-bijutier.htm" method="post" commandName="jeweler">   
			<div class="form-group">                
                <form:hidden path="id" readOnly="true" class="form-control"/>                
            </div>	
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="name" class="form-control"/>                
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="phone" class="form-control"/>                
                          
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" class="form-control"/>                
            </div>
            <div class="form-group">
                <label for="country">Country</label>
                <form:input path="country" class="form-control"/>                
            </div>
            
	<input class="btn btn-success" type="submit" value="Salveaza"/>
</form:form>
</div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>