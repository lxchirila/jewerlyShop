<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/WEB-INF/common/head.jsp"/>  
</head>
<body class="accent-olive hold-transition sidebar-mini"><!-- Site wrapper -->
<div class="wrapper">
   <jsp:include page="/WEB-INF/common/side-menu.jsp"/>
 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Products</h1>
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
          <h3 class="card-title">Products</h3>         
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
              <thead>
                  <tr>
                     <th style="width: 1%">
                          Id
                      </th>
                      <th style="width: 20%">
                          Description
                      </th>
                      <th style="width: 30%">
                          Price
                      </th>
                      <th>
                          Stock
                      </th>
                      <th style="width: 8%" class="text-center">
                          
                         </th>
                  </tr>
              </thead>
              <tbody>
              <c:forEach var="p" items="${model.product}">
				<tr>
				    <td><c:out value="${p.id}"/></td>
				    <td><c:out value="${p.description}"/></td>
				  	 <td><c:out value="${p.price}"/></td>
				    <td><c:out value="${p.stock}"/></td>				    
					<td class="d-flex">
						<a class="btn bg-dark btn-sm mr-2 d-flex align-items-center" href="<c:url value='/editare-produs.htm?id=${p.id}'/>">
							<i class="fas fa-pencil-alt mr-2"> </i> Edit
						</a> 
						<a class="btn btn-danger btn-sm d-flex align-items-center" href="<c:url value='/stergere-produs.htm?id=${p.id}'/>">
							<i class="far fa-trash-alt mr-2"> </i> Delete
						</a>
					</td>				    				    
				</tr>    
				</c:forEach>                  
              </tbody>
          </table>
           
        </div>
        
        <!-- /.card-body -->
      </div>
      <a class="btn btn-danger btn-sm" href="<c:url value='/adaugare-produs.htm'/>">
               <i class="fas fa-trash">
               </i>
               Add Product
           </a>
      <!-- /.card -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>
