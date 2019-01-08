<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row" style="margin-top: 1%;">
		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Detail</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<div class="text-center">
						<h4>${registerModel.user.firstName}
							${registerModel.user.lastName}</h4>
						<h5>Email: ${registerModel.user.email}</h5>
						<h5>Contact Number: ${registerModel.user.contactNumber}</h5>
						<h5>Role: ${registerModel.user.role}</h5>
					</div>
				</div>
				<div class="panel-footer" align="center">
					<!-- form elements -->
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Edit</a>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<div class="text-center">
						<h4>${registerModel.billing.addressLineOne}</h4>
						<h4>${registerModel.billing.addressLineTwo}</h4>
						<h5>${registerModel.billing.city}-
							${registerModel.billing.postalCode}</h5>
						<h5>${registerModel.billing.state}-
							${registerModel.billing.country}</h5>

					</div>
				</div>
				<div class="panel-footer" align="center">
					<!-- form elements -->
					<a href="${flowExecutionUrl}&_eventId_billing"
						class="btn btn-primary">Edit</a>
				</div>
			</div>
		</div>

		<!-- to provide the confirm button after the displaying the detail -->
		<div class="col-sm-4 offset-sm-4">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-primary">Confirm</a>
			</div>
		</div>

	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>