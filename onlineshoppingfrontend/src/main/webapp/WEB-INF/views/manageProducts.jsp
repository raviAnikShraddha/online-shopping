<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row" style="margin-top: 2%;">

		<c:if test="${not empty message}">
			<div class="col-md-12" id="alert">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="col-md-12" id="alert">
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msg}
				</div>
			</div>
		</c:if>



		<div class="offset-md-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Product Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Products Name" path="name"
										id="name" class="form-control" />
									<sf:errors path="name" element="em" cssClass="help-block"></sf:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Brand Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Brand Name" path="brand"
										id="brand" class="form-control" />
									<sf:errors path="brand" element="em" cssClass="help-block"></sf:errors>
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
									<sf:errors path="description" element="em"
										cssClass="help-block"></sf:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Enter Unit Price:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Unit Price &#8377;"
										path="unitPrice" id="unitPrice" class="form-control" />
									<sf:errors path="unitPrice" element="em" cssClass="help-block"></sf:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Quantity Available:</label>
								<div class="col-md-8">
									<sf:input type="number" placeholder="Quantity" path="quantity"
										id="quantity" class="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="file">Select an Image:</label>
								<div class="col-md-8 upload-btn-wrapper">
									<button class="btn1">Upload a file</button>
									<sf:input type="file" path="file" id="file"
										class="form-control" />
									<sf:errors path="file" element="em" cssClass="help-block"></sf:errors>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Select Category:</label>
								<div class="col-md-8">
									<sf:select class="form-control" path="categoryId"
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


	<div class="row">
		<div class="col-md-12">
			<h3>Available Products</h3>
			<hr />
		</div>

		<div class="col-md-12">
			<div style="overflow: auto;">
				<!-- product table foe Admin -->
				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Unit Price</th>
							<th>Quantity</th>

							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>

			</div>
		</div>

	</div>

</div>