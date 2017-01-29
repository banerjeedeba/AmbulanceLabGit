<!DOCTYPE html>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifications</title>
<link rel="stylesheet" type="text/css" href="welcome.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jQuery.AjaxFileUpload.js"></script>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<script type="text/javascript" src="js/materialize.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        var url = '<%= blobstoreService.createUploadUrl("/AddUser") %>';
	        /* reader.onload = function (e) {
	            $('#blah').attr('src', e.target.result);
	        } */

	        reader.readAsDataURL(input.files[0]);
	        
	        var fd = new FormData($('#imgupload')[0]);    
		    /* fd.append( 'myFile', input.files[0] );
		    fd.append('profileId', 1); */

		     $.ajax({
		      url: url,
		      data: fd,
		      processData: false,
		      contentType: false,
		      cache: false,
		      type: 'POST',
		      success: function(data){
		        alert("ok");
		      }
		    });
	    }
	};

	$("#myFileUpload").change(function(){
	    readURL(this);
	    //$('#imgupload').submit();
	    
	});
	
	$("#addUser").click(function(event){
		$("#errordiv").hide();
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		var url='<%= blobstoreService.createUploadUrl("/AddUser") %>?firstname='+firstname +'&lastname='+lastname;
		$.ajax({url: url,
   	   		type: 'POST',
   	   		success: function(data){
   	   			alert(data);
   	   			
	   	    },
   	    	error: function(xhr,status,error){
   	    		alert("error..."+error+"--"+status);
   	    		$("#errordiv").html("Some error in the server!!");
   	    		$("#errordiv").show();
   	    	}
   	   	});
	});
	
    $("#loginBtn, #refreshBtn").click(function(event){
	
    	//alert("hiii");
    	$("#errordiv").hide();
		var user = $("#Username").val();
		var pass = $("#Password").val();
       	//var url="http://localhost:8080/AmbulanceLabs/rest/notifications?userName="+user +"&password="+pass;
       	var url="http://carmgt-1239.appspot.com/rest/notifications?userName="+user +"&password="+pass;
       	
   	   	$.ajax({url: url,
   	   		data: {
   	      		format: 'json'
   	   		},
   	   		
   	   		type: 'POST',
   	   		success: function(data){
	   	   		
   	   			$("#div1").html(" ");
   	   			var rowCount = 0;
   	   			$.each(data,function(key,value){
   	   				if(value.error != undefined){
	   	   				$("#errordiv").html(value.error);
	   	   	    		$("#errordiv").show();
	   	   	    		rowCount++;
	   	   	    		return;
   	   				}else{
   	   				
   	   					$(".form-signin").addClass("hidden");
   	   					$(".preview__actions_btn").removeClass("hidden");
   	   				
						if(value.nPackage!="test"){
							var tempdiv = $("#temp").html();
							$("#div1").append(tempdiv);
							
							$("#div1 .temprow").attr('id', 'row'+rowCount);
							$("#div1 #row"+rowCount).removeClass("temprow");
							$("#div1 #row"+rowCount+" .notyApp").html(value.nTitle);
							var title = value.nPackage;
							if(value.nTicker !="null"){
								title = title+", "+ value.nTicker;
							}
							$("#div1 #row"+rowCount+" .notyTitle").html(title);
							$("#div1 #row"+rowCount+" .notyText").html(value.nText);
							
							rowCount++;
							
						}
   	   					
   	   				}
   	   	    		
   	   			});
   	   			if(rowCount==0){
	   	   			var tempdiv = $("#temp").html();
					$("#div1").append(tempdiv);
					
					$("#div1 .temprow").attr('id', 'row'+rowCount);
					$("#div1 #row"+rowCount).removeClass("temprow");
					$("#div1 #row"+rowCount+" .notyTitle").html("No notification available!!");
   	   			}
   	   			
	   	        
	   	    },
   	    	error: function(xhr,status,error){
   	    		alert("error..."+error+"--"+status);
   	    		$("#errordiv").html("Some error in the server!!");
   	    		$("#errordiv").show();
   	    	}
   	   	});
   	 
		
    });
    
    $("#logoutBtn").click(function(event){
    	$("#Username").val("");
		$("#Password").val("");
		$("#div1").html(" ");
		$(".form-signin").removeClass("hidden");
		$(".preview__actions_btn").addClass("hidden");
    });
    
    /* $("#uploadBtn").click(function(event){
    	var input = document.getElementById('uploadBtn');
    	var file = input.files[0];
    	this
    }); */
    
    $("#uploadBtn").ajaxfileupload({
		  'action' : 'UploadImage',
		  'onComplete' : function(response) {
		      $('#upload').hide();
		      $('#message').show();
		                        
		      var statusVal = JSON.stringify(response.status);

		     if(statusVal == "false")
		     {
		     $("#message").html("<font color='red'>"+JSON.stringify(response.message)+"</font>");
		     }  
		     if(statusVal == undefined)
		     {
		     $("#message").html("<font color='green'>Your file has been uploaded!</font>");
		     }                  
		},
		'onStart' : function() {
		        $('#upload').show();
		        $('#message').hide();
		}
		});
    
    
 });
</script>
</head>
<body>
<div class="preview__header">

  <div class="preview__envato-logo">
    <h4 class="form-signin-heading">Upload Image!!</h3>
  </div>

</div>
<div class = "container">
	<div class="wrapper">
		<div name="Login_Form" class="form-signin" >       
		    <h3 class="form-signin-heading">Upload Image!!</h3>
			  <hr class="colorgraph"><br>
			    		  
			  <div id="errordiv" class="alert alert-danger" style="display:none;"></div>
			  <div id="upload" style="display: none;">Uploading..</div>
        	  <div id="message"></div>
        	  <form action="<%= blobstoreService.createUploadUrl("/AddUser") %>" id="imgupload" method="post" enctype="multipart/form-data">
        	  <input type="text" class="form-control" id="firstname" name="firstname" placeholder="First Name" required="" autofocus="" />
			  <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Last Name" required=""/>     
			  <input class="btn btn-lg btn-primary btn-block"  name="myFile" id="myFileUpload" value="Select" type="file" accept="image/*;capture=camera">
			  <!-- <input class="btn btn-lg btn-primary btn-block" id="uploadBtn" name="uploadBtn" type="file" accept="image/*;capture=camera"> -->
			  <!-- <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" >AddUser</button> -->
			  </form>
			  <div> 
			  <br>
				  <form action="ViewUsers" method="post">
				  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" id="View" >View</button>
				  </form>
			  </div>
			  <br>
			  <form action="DeleteAll" method="post">
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Delete" id="deletAll" >Delete All</button>
			  </form>
			  <br/>
			  	<iframe src="https://calendar.google.com/calendar/htmlembed?src=%23contacts%40group.v.calendar.google.com&ctz=America/New_York" style="border: 0" width="228" height="300" frameborder="0" scrolling="no"></iframe>
		</div>
		<div id="div1">			
		</div>
	</div>
</div>
<div id="temp" class="hidden">
	<div class="row temprow">
        <div class="col s12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text hoverable">
              <span class="card-title notyApp"></span>
              <p class="notyTitle"></p>
              <p class="notyText"></p>
            </div>
          </div>
        </div>
      </div>
</div>
</body>
</html>