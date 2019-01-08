<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row" style="margin-top: 1%;">
		<div class="col-md-6 offset-md-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<sf:form class="form-horizontal" id="registerForm" method="POST"
						modelAttribute="user">
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">First Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="First Name" path="firstName"
										id="firstName" class="form-control" />

								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Last Name:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Last Name" path="lastName"
										id="lastName" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Email:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Email" path="email"
										id="email" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Contact Number:</label>
								<div class="col-md-8">
									<sf:input type="text" placeholder="Contact Number"
										path="contactNumber" id="contactNumber" class="form-control" />

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Password:</label>
								<div class="col-md-8">
									<sf:input type="password" placeholder="Password"
										path="password" id="password" class="form-control" />

								</div>
							</div>
						</div>

						<!-- radio button using bootstrap class of radio-inline -->
						<div class="form-group">
							<div class="row">
								<label class="col-md-4" for="name">Select Role:</label>
								<div class="col-md-8">
									<label class="radio-inline"> <sf:radiobutton
											path="role" value="USER" checked="checked" />User
									</label> <label class="radio-inline"> <sf:radiobutton
											path="role" value="USER" />Supplier
									</label>
								</div>
							</div>
						</div>
						<div class="offset-md-4 col-md-10">
							<button type="submit" value="Submit" id="submit"
								name="_eventId_billing" class="btn btn-primary">
								Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
							</button>
						</div>
					</sf:form>
				</div>

			</div>
		</div>
	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>
