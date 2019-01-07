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
					<h4>Address Detail</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->

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
				<a href="${flowExecutionUrl}&_eventId_success"
					class="btn btn-primary">Confirm</a>
			</div>
		</div>

	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>