<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row" style="margin-top: 1%;">
		<div class="col-md-6 offset-md-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Address</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<sf:form class="form-horizontal" id="billingForm" method="POST"
						modelAttribute="billing">
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="addressLineOne">Address
									Line One:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="AddressLineOne"
										path="addressLineOne" id="addressOne" class="form-control" />

								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="addressLineTwo">Address
									Line Two:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Last Name"
										path="addressLineTwo" id="addressLineTwo" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="city">City:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="City" path="city" id="city"
										class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="postalCode">Postal Code:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Postal Code"
										path="postalCode" id="postalCode" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="state">State:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="State" path="state"
										id="state" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="country">Country:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Country" path="country"
										id="country" class="form-control" />

								</div>
							</div>
						</div>
						<div class="offset-md-4 col-md-10">
							<button type="submit" value="Submit" id="submit"
								name="_eventId_personal" class="btn btn-primary">

								<span class="glyphicon glyphicon-chevron-left"></span> Previous
								- Personal
							</button>

							<!-- submit button to moving confirm -->
							<button type="submit" value="Submit" id="submit"
								name="_eventId_confirm" class="btn btn-primary">

								Next - Confirm<span class="glyphicon glyphicon-chevron-right"></span>
							</button>
						</div>
					</sf:form>
				</div>

			</div>
		</div>
	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>
