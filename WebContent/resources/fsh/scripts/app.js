function closeDrawer() {
$('#measurementdrawer').removeClass('in');
  setTimeout(function(){
  
       $('#measurementdrawer').addClass('out');
	   
   }, 200);
   
  };
  
  
  function closedetailDrawer() {

  setTimeout(function(){
       $('#listclientdrawer').removeClass('in');
   }, 5);
  };
  
  function getClientDetails() {
  $('#clientdetaildrawer').removeClass('out');
	setTimeout(function(){
        $('#clientdetaildrawer').addClass('in');
      }, 1);
  };
  
  function clientDetailsCall(profileid) {
		var params = "profileid=" + profileid;
		var parameter = buildParamsObject(params);
		$.ajax({
			url : "profileDetails.do",
			type : 'post',
			data : parameter,
			success : function(result) {
				$('#clientdetaildrawer').html(result);
				getClientDetails();
				closeDrawer();
			}
		});
	};
  
  function closeclientdetailDrawer(){
	  $('#clientdetaildrawer').removeClass('in');
  setTimeout(function(){
       $('#clientdetaildrawer').addClass('out');
   }, 5);
  };
  
  function getMeasurementDetails(){
	  var params = "profileid=0";//+$('#profileid').val();
	  
	  
	  var parameter=buildParamsObject(params);

	  $.ajax({
		  url: "addMeasurement.do", 
		  type: 'POST',
		  data: parameter,
		  success: function(result){
			  debugger;
		  $('#clientmeasurement').html('');
		  $('#clientmeasurement').html(result);
		  $('#listmeasurementdrawer').removeClass('out');
			setTimeout(function(){
		        $('#listmeasurementdrawer').addClass('in');
		      }, 1);
	    }});  
	  
  
  
  };
  
    function closeMeasurementDetails(){
	
  $('#listmeasurementdrawer').removeClass('in');
  setTimeout(function(){
  
       $('#listmeasurementdrawer').addClass('out');
	   
   }, 300);
  };
  
  function getWardrobeDetails(){
	$('#listwardrobedrawer').removeClass('out');
	setTimeout(function(){
        $('#listwardrobedrawer').addClass('in');
      }, 1);
  }
  
  function closeWardrobeDetails(){
  setTimeout(function(){
       $('#listwardrobedrawer').removeClass('in');
   }, 5);
  };
  
  function getNotesDetails(){
	$('#notesdrawer').removeClass('out');
	setTimeout(function(){
        $('#notesdrawer').addClass('in');
      }, 1);
  };
  
  function closenotesDrawer(){
  setTimeout(function(){
       $('#notesdrawer').removeClass('in');
   }, 5);
  };
  
  function editmeasurement(ref){
  var detail = $(ref).data('detail');
  var detail1 = $(ref).data('detail1');
  $('#'+detail).addClass('hide');
  $('#'+detail1).removeClass('hide');
  };
  

function addClient() {
	$.ajax({
		url : "addClient.do",
		success : function(result) {
			$('#addclientdrawer').html(result);
		}
	});
};

function listClient() {
	$.ajax({
		url : "listClient.do",
		success : function(result) {
			$('#listclientdrawer').html(result);
		}
	});
};

function saveClient() {
	var params = "firstname=" + $('#firstname').val() + "&lastname="
			+ $('#lastname').val() + "&address=" + $('#address').val()
			+ "&contactNo=" + $('#contactNo').val() + "&ccNumber="
			+ $('#ccNumber').val() + "&email=" + $('#email').val();
	var parameter = buildParamsObject(params);
	$.ajax({
		url : "profileData.do",
		type : 'post',
		data : parameter,
		success : function(result) {
			$('#clientdetaildrawer').html(result);
			getClientDetails();
			closeDrawer();
		}
	});
};

function buildParamsObject(str) {
	var paramObj = {};

	var params = str.split('&');
	for (var i = 0; i < params.length; i++) {
		var keyval = params[i].split('=');
		paramObj[keyval[0]] = decodeURI(keyval[1]);
	}
	return paramObj;
};