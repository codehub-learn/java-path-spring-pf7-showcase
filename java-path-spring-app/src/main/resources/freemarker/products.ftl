<!DOCTYPE html>
<html>
<head>
	<title>Our Products</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>#</th>
					<th>Serial</th>
					<th>Name</th>
					<th>Price</th>
					<th>Category</th>
				</tr>
				</thead>
				<tbody>
				<#list products as product>
					<tr>
						<th>${product?counter}</th>
						<td>${product.serial}</td>
						<td>${product.name}</td>
						<#-- "&euro;" = € but for HTML, so that browsers can read it properly -->
						<td>${product.price}&euro;</td>
						<td>${product.category.description}</td>
					</tr>
				</#list>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>
