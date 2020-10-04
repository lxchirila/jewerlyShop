
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Sidebar Container -->
<aside
	class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="<c:url value='index.html' />" class="brand-link d-flex justify-content-start align-items-center"> 
		<img src="https://static.vecteezy.com/system/resources/previews/001/198/389/non_2x/diamond-logo-png.png" class="img-fluid" alt="Responsive image">
		<h1>Jewelry Shop</h1>
	</a>
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item has-treeview"><a
					href="<c:url value='/lista-bijutieri.htm'/>" class="nav-link">
						<i class="fas fa-shekel-sign"></i>
						<p>
							Jewelers
						</p>
				</a></li>
				<li class="nav-item has-treeview"><a
					href="<c:url value='/lista-produse.htm'/>" class="nav-link"> <i
						class="nav-icon fas fa-balance-scale"></i>
						<p>
							Products
						</p>
				</a></li>
				<li class="nav-item has-treeview"><a
					href="<c:url value='/lista-review.htm'/>" class="nav-link"> <i
						class="nav-icon far fa-comments"></i>
						<p>
							Reviews
						</p>
				</a></li>

			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
