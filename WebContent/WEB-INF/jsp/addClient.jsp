<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="clientimage">
</div>
<form class="form-group fashionform" modelAttribute="profile">
	<div class="form-group" style="padding-top:10px;">
		<input type="text" class="form-control fashionforminput"
			id="firstname" name="firstname" placeholder="FIRST NAME" value = "${profile.firstname}" autocomplete="off">
	</div>
	<div class="form-group">
		<input type="text" class="form-control fashionforminput" id="lastname"
			name="lastname" placeholder="LAST NAME" autocomplete="off" value = "${profile.lastname}">
	</div>
	<div class="form-group">
		<input type="text" class="form-control fashionforminput" id="address"
			placeholder="ADDRESS" value = "${profile.address}">
	</div>
	<div class="form-group">
		<input type="text" class="form-control fashionforminput" id="contactNo" name="contactNo"
			placeholder="PHONE #" value = "${profile.contactNo}">
	</div>
	<div class="form-group">
		<input type="text" class="form-control fashionforminput" id="ccNumber" name="ccNumber"
			placeholder="CREDIT CARD#" value = "${profile.ccNumber}">
	</div>
	<div class="form-group">
		<input type="text" class="form-control fashionforminput" id="email" name="email"
			placeholder="EMAIL" value = "${profile.email}">
	</div>
</form>
<div class=" form-group row listrow">
	<div class="col-xs-10">MEASUREMENTS</div>

	<div class="col-xs-2 addclientrow">
		<a href="#" onclick="getMeasurementDetails();"> <span
			class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
		</a>
	</div>
</div>

<div class="form-group row listrow">
	<div class="col-xs-10">NOTES</div>

	<div class="col-xs-2 addclientrow">
		<a href="#" onclick="getNotesDetails();"> <span
			class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
		</a>
	</div>
</div>

<c:if test="${  empty profile.profileid}">
<div class="form-group row listrow">
	<div class="col-xs-10">Wardrobe</div>

	<div class="col-xs-2 addclientrow">
		<a href="#" onclick="getWardrobeDetails();"> <span
			class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
		</a>
	</div>
</div>
</c:if>


<div class="bottom-btn-container">
	<div class="col-xs-6">
		<button type="submit" class="btn btn-default  fashionbutton">Cancel</button>
	</div>
	<div class="col-xs-6">
		<button type="submit" class="btn btn-default fashionbutton" onclick="saveClient();">Save</button>
	</div>
</div>