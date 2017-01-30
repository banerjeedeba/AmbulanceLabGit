<%@page import="com.style.web.response.Profile"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	Profile profile = (Profile)request.getAttribute("profile");
%>
<script type="text/javascript" aria-hidden="true">
  require(['jquery','bootstrap','app'], function($) {
    $(document).ready(function () {
function readURL(input) {
	$('.loading-icon').removeClass('hide');
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        var url = '<%= blobstoreService.createUploadUrl("/addClientPic.do") %>';
	        reader.onload = function (e) {
	            $('#blah').attr('src', e.target.result);
	        }

	        reader.readAsDataURL(input.files[0]);
	        
	        var fd = new FormData($('#imgupload')[0]);    
		    

		     $.ajax({
		      url: url,
		      data: fd,
		      processData: false,
		      contentType: false,
		      cache: false,
		      type: 'POST',
		      success: function(data){
		    	  $('.loading-icon').addClass('hide');
		      }
		    });
	    }
	};

	$("#imgInp").change(function(){
	    readURL(this);
	    //$('#imgupload').submit();
	    
	});
    });
  });
  </script>
<!-- <div class="masthead" aria-hidden="false">	
		<div class="mastdrawerheadtitle">
		  <span class="col-xs-1">
			<a href="#" onclick="closeclientdetailDrawer();return false;">
				<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
			</a>
		  </span>
		  <span class="col-xs-23">
			  <h1 tabindex="0">Client Detail</h1>
		  </span>
		</div>
	</div> -->
	 <div class="drawerpad">
	<div class="clientimage">
	<span> <label> 
	<form action="<%= blobstoreService.createUploadUrl("/addClientPic.do") %>" id="imgupload" enctype="multipart/form-data" method="post" >
	<input type="file" name="myFile" id="imgInp"> <img
			id="blah" src="${not empty profile.blobKey?profile.blobKey:'resources/fsh/images/addpic.PNG'}" class="img-circle .img-responsive" alt=""
			width="100" height="100">
	<input type="hidden" id="profileId" name="profileId" value="<%=profile.getProfileid()%>"/>
	</form>
	</label>
	</span>
	</div>
	<ul class="list-group">
    <li class="list-group-item listrowmeasurementdetail">
    <span class="col-xs-6">FIRST NAME</span>
		<span class="key hideoverflow">${not empty profile.firstname?profile.firstname:'NA'}</span>
		
	</li>
    <li class="list-group-item listrowmeasurementdetail">
    <span class="col-xs-6">LAST NAME</span>
	<span class="key hideoverflow">${not empty profile.lastname?profile.lastname:'NA'}</span>
		
	</li>
    <li class="list-group-item listrowmeasurementdetail">
    <span class="col-xs-6">ADDRESS</span>
	<span class="key hideoverflow">${not empty profile.address?profile.address:'NA'}</span>
	</li>
    <li class="list-group-item listrowmeasurementdetail">
    <span class="col-xs-6">CONTACT #</span>
	<span class="key hideoverflow">${not empty profile.contactNo?profile.contactNo:'NA'}</span>
	</li>
	<li class="list-group-item listrowmeasurementdetail">
	<span class="col-xs-6">EMAIL</span>
	<span class="key hideoverflow">${not empty profile.email?profile.email:'NA'}</span>
	</li>
	
	</ul>
	<div class="form-group row listrow">
	  <div class="col-xs-10">
	  Measurement
	  </div>
	  
	  <div class="col-xs-2 addclientrow">
	  <a href="#" onclick="getMeasurementDetails('${profile.profileid}');return false;">
	   <span class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
	   </a>
	  </div>
	  </div>
	  
	  <div class="form-group row listrow">
	  <div class="col-xs-10">
	  Wardrobe
	  </div>
	  
	  <div class="col-xs-2 addclientrow">
	  <a href="#" onclick="getWardrobeDetails();return false;">
	   <span class="glyphicon glyphicon-menu-right fshglyphicon-chevron-right"></span>
	   </a>
	  </div>
	  </div>
	  
	  <!--<div class="btn-group btn-group-justified">
  <div class="btn-group">
    <button id ="item1" type="button" class="btn fashion-btn-primary buttonselected">Items</button>
  </div>
  <div class="btn-group">
    <button id="item2" type="button" class="btn fashion-btn-secondary">Outfits</button>
  </div>
 
</div>  -->
 </div> 