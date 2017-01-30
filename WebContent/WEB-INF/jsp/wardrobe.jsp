<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="wf-loading">
<head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="initial-scale=1.0,user-scalable=0,width=device-width,height=device-height" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="format-detection" content="telephone=no" />
  <link rel="apple-touch-icon" href="resources/bmw/images/logo/wf_57px.png?v=0" />
  <link type="image/x-icon" rel="shortcut icon" href="" />
  <title>Fashion</title>
  <!--  <link rel="stylesheet" href="/Spring/Webcontent/resources/fsh/styles/bootstrap/bootstrap.css?v=0" /> -->
  <!-- <link rel="stylesheet" href="/Spring/Webcontent/resources/fsh/styles/app.css?v=0" /> -->
  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="css/thumbnail-gallery.css" rel="stylesheet">
  <spring:url value="/resources/fsh/styles/bootstrap/bootstrap.css?v=0" var="bootstrapCss" />
  <spring:url value="/resources/fsh/styles/app.css?v=0" var="apppCss" />

  
  <link href="${bootstrapCss}" rel="stylesheet" />
  <link href="${apppCss}" rel="stylesheet" />

  
  <!-- use the font -->
  <style>
    body {
      font-family: 'Roboto', sans-serif;
      font-size: 15px;
	  
    }
  </style>
  <!-- <style id="antiClickjack">body{display:none !important;}</style>
  <script type="text/javascript" aria-hidden="true">
    if (self === top) {
       var antiClickjack = document.getElementById("antiClickjack");
       antiClickjack.parentNode.removeChild(antiClickjack);
    } else {
       top.location = self.location;
    }
  </script> -->
  <script type="text/javascript" aria-hidden="true" src="resources/fsh/scripts/require-setup.dev.js?v=0"></script> 
   <script type="text/javascript" aria-hidden="true" src="resources/fsh/scripts/require/require.js?v=0"></script>
 
  
<script type="text/javascript" aria-hidden="true">
  require(['jquery','bootstrap','app'], function($) {
    $(document).ready(function () {
    	$('.showchevron').click(function(){
    		$('.mastdrawerheadtitle').removeClass('hide');
    	});
  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      hamburger_cross();      
    });

	
	
    function hamburger_cross() {

      if (isClosed == true) {          
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      } else {   
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }
  }
  
  $('[data-toggle="offcanvas"]').click(function () {
        $('#wrapper').toggleClass('toggled');
  });  
  
  $('#item1').click(function () {
	$('#item2').removeClass('buttonselected');
	$('#item1').addClass('buttonselected');
	
	
  });
   $('#item2').click(function () {
	$('#item1').removeClass('buttonselected');
	$('#item2').addClass('buttonselected');
  });
  $('#addClientData').click(function(){
 $('.hamburger').click();
	$('#measurementdrawer').removeClass('out');
	setTimeout(function(){
        $('#measurementdrawer').addClass('in');
      }, 1);
  });
  
  $('#listClient').click(function(){
 $('.hamburger').click();
	$('#listclientdrawer').removeClass('out');
	setTimeout(function(){
        $('#listclientdrawer').addClass('in');
      }, 1);
  });
  
  
  
});

  });
</script>
</head>                                      
<body class="page-loading bodyimage">
<div class="loading-icon hide">
<div class="loading-icon1"></div>
	<img src="resources/fsh/images/loading.gif" class=".img-responsive loadingimage" width="100" height="100"/>
</div>
<div class="background-image">
<img src="resources/fsh/images/unnamed.jpg" class=".img-responsive" alt="" >
</div>
<header>
  <div class="masthead" aria-hidden="false">
    <div class="mastheadtitle">
     <div class="mastdrawerheadtitle hide">
  <span class="col-xs-1">
	<a href="wardrobe.do" >
		<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
	</a>
  </span>
  </div>
      <div class="clientimage">
	<img src="resources/fsh/images/Capture1.PNG" class=".img-responsive" alt="" width="80" height="53">
	</div>
    </div>
  </div>
</header>
<div class="content" aria-hidden="true">
<div>
<div>
      
      <div class="col-xs-12">
        <input type="text" class="form-control searchinput" id="searchinput" placeholder="ENTER CLIENT NAME TO SEARCH">
        <span class="glyphicon glyphicon-search form-control-feedback searchicon"></span>
      </div>
    </div>
</div>

<div>


<div id="measurementdrawer" class="drawer fromright out">

   <!--  <div class="masthead" aria-hidden="false">
	
	
    <div class="mastdrawerheadtitle">
  <span class="col-xs-1">
	<a href="#" onclick="closeDrawer();return false;">
		<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
	</a>
  </span>
  <span class="col-xs-23">
      <h1 tabindex="0">Add Client</h1>
  </span>
    </div>
	
  </div> -->
  <div class="drawerpad" id="addclientdrawer">
  
  
</div>
  </div>
  
  <div id="notesdrawer" class="drawer fromright out">

    <!-- <div class="masthead" aria-hidden="false">
	
	
    <div class="mastdrawerheadtitle">
  <span class="col-xs-1">
	<a href="#" onclick="closenotesDrawer();return false;">
		<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
	</a>
  </span>
  <span class="col-xs-23">
      <h1 tabindex="0">Add Notes</h1>
  </span>
    </div>
	
  </div> -->
  <div class="drawerpadnotes">
  
  <div class="form-group">
    <textarea class="form-control" rows="26" id="comment"></textarea>
</div>
  
 <div class="bottom-btn-container">
<div class="col-xs-6">
<button type="submit" class="btn btn-default  fashionbutton">Cancel</button>
</div>
<div class="col-xs-6">
<button type="submit" class="btn btn-default fashionbutton">Save</button>
</div>
</div>
</div>
  </div>
  
<div id="listclientdrawer" class="drawer fromright out">
    
</div>


<div id="clientdetaildrawer" class="drawer fromright out">
    
</div>

<div id="listmeasurementdrawer" class="drawer fromright out">
    <!-- <div class="masthead" aria-hidden="false">	
		<div class="mastdrawerheadtitle">
		  <span class="col-xs-1">
			<a href="#" onclick="closeMeasurementDetails();return false;">
				<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
			</a>
		  </span>
		  <span class="col-xs-21">
			  <h1 tabindex="0">Measurement</h1>
		  </span>
		</div>
	</div> -->
	<div class="drawerpad" id="clientmeasurement">
	
</div>
</div>

<div id="listwardrobedrawer" class="drawer fromright out">
    <!-- <div class="masthead" aria-hidden="false">	
		<div class="mastdrawerheadtitle">
		  <span class="col-xs-1">
			<a href="#" onclick="closeWardrobeDetails();return false;">
				<span class="glyphicon glyphicon-menu-left fshglyphicon-chevron-left"></span>
			</a>
		  </span>
		  <span class="col-xs-21">
			  <h1 tabindex="0">Wardrobe</h1>
		  </span>
		</div>
	</div> -->
	<div class="drawerpad">
	<div class="btn-group btn-group-justified itemoutfit">
	  <div class="btn-group">
		<button id ="item1" type="button" class="btn fashion-btn-primary buttonselected">Items</button>
	  </div>
	  <div class="btn-group">
		<button id="item2" type="button" class="btn fashion-btn-secondary">Outfits</button>
	 </div>
 
</div>

<div class="col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="resources/fsh/images/add.jpg" alt="">
                </a>
            </div>
            <div class="col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="resources/fsh/images/add.jpg" alt="">
                </a>
            </div>
            <div class="col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="resources/fsh/images/add.jpg" alt="">
                </a>
            </div>
 
  
  </div>
</div>

	   

</body>
<div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#" onclick="return false;">
                       My Profile
                    </a>
                </li>
                <li>
                    <a href="wardrobe.do">Home</a>
                </li>
                <li>
                    <a href="#" id="addClientData" class="showchevron" onclick="addClient();return false;">Add Client</a>
                </li>
                <li>
                    <a href="#" onclick="listClient();return false;" class="showchevron" id="listClient">List Client</a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">PlaceHolder <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header"></li>
                    <li><a href="#">PlaceHolder 1</a></li>
                    <li><a href="#">PlaceHolder 2</a></li>
                  </ul>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button btn-group-sm" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
            
        </div>
        <!-- /#page-content-wrapper -->

    </div>
</html>
