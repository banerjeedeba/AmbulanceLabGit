<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <div class="masthead" aria-hidden="false">
	<div class="mastdrawerheadtitle">
		<span class="col-xs-1"> <a href="javascript:void(0)"
			onclick="closedetailDrawer();"> <span
				class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
		</a>
		</span> <span class="col-xs-23">
			<h1 tabindex="0">List Client</h1>
		</span>
	</div>
</div> -->
<div class="drawerpad">

	<c:forEach items="${profileList}" var="profile">
		<div class="row listrowmeasurement" onclick="clientDetailsCall('${profile.profileid}');">
			<div class="col-xs-10">${profile.firstname} ${profile.lastname}</div>
			<div class="col-xs-2 addclientrow">
				<a href="javascript:void(0)"> <span
					class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
	</c:forEach>

</div>