<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row listrowmeasurement ">
	<div class="col-xs-8">HEIGHT</div>
	<div id="hgt" class="col-xs-4 ${not empty measurement.height ? '':'hide'}">
		<a href="#" class="anchorblack" onclick="editmeasurement(this);return false;"
			data-detail="hgt" data-detail1="hgt1">
			<div class="col-xs-3 listrowvalue">${measurement.height}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="hgt1" class="col-xs-4 ${not empty measurement.height ? 'hide':''}">
		<input type="text" class="measurementinput" value="${measurement.height}" autocomplete="off" id="height" name="height"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">INSEAM</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.inseam ? '':'hide'}">
		<a href="#" class="anchorblack" onclick="editmeasurement(this);;return false;"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.inseam}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.inseam ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.inseam}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">SHOE</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.shoe ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.shoe}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.shoe ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.shoe}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">WAIST</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.waist ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.waist}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.waist ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.waist}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">NECK</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.neck ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.neck}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.neck ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.neck}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">JACKET</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.jacket ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.jacket}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.jacket ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.jacket}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">SHIRT</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.shirt ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.shirt}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.shirt ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.shirt}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">WEIGHT</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.weight ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.weight}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.weight ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.weight}" autocomplete="off" id="height" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">SLEEVE</div>
	<div id="waist" class="col-xs-4 ${not empty measurement.sleeve ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.sleeve}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.sleeve ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.sleeve}" autocomplete="off" id="height" name="waist"/>
	</div>

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