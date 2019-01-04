<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row" style="margin-top: 2%;">
		<div class="offset-md-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<sf:form class="form-horizontal" modelAttribute="product">
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Product Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Products Name" path="name"
										id="name" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Brand Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Brand Name" path="brand"
										id="brand" class="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Product Description:</label>
								<div class="col-md-8">
									<sf:textarea rows="4" cols="50" path="description"
										id="description" class="form-control"
										placeholder="Product Description"></sf:textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Unit Price:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Unit Price &#8377;"
										path="unitPrice" id="unitPrice" class="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Quantity Available:</label>
								<div class="col-md-8">
									<sf:input type="number" placeholder="Unit Price &#8377;"
										path="quantity" id="quantity" class="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Select Category:</label>
								<div class="col-md-8">
									<sf:select class="custom-select" path="categoryId"
										id="categoryId" items="${categories}" itemLabel="name"
										itemValue="id" />

								</div>
							</div>
						</div>
						<div class="row">
							<div class="offset-md-4 col-md-10">
								<input type="submit" value="Submit" id="submit"
									class="btn btn-primary" />
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>