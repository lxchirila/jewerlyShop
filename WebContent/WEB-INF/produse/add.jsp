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
            <h1>Produse</h1>
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
          <h3 class="card-title">Adaugare Produs</h3>         
        </div>
        <div class="card-body">
        <form:form action="creare-produs.htm" method="post" commandName="product">   
			<div class="form-group">                
                <form:hidden path="id" readOnly="true" class="form-control"/>                
            </div>	
            <div class="form-group">
                <label for="description">Description</label>
                <form:input path="description" class="form-control"/>                
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <form:input path="price" class="form-control"/>                
                          
            </div>
            <div class="form-group">
                <label for="stock">Stock</label>
                <form:input path="stock" class="form-control"/>                
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