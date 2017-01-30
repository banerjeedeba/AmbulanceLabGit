<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>

<input type="hidden" value="${measurement.profileid}" autocomplete="off" id="measure-profileid" name="measure-profileid"/>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Neck</div>
	<div id="neck2" class="col-xs-4 ${not empty measurement.neck ? '':'hide'}">
		<a href="#" class="anchorblack" onclick="editmeasurement(this);return false;"
			data-detail="hgt" data-detail1="hgt1">
			<div class="col-xs-3 listrowvalue">${measurement.neck}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="neck1" class="col-xs-4 ${not empty measurement.neck ? 'hide':''}">
		<input type="text" class="measurementinput" value="${measurement.neck}" autocomplete="off" id="neck" name="neck"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Sleeve</div>
	<div id="sleeve2" class="col-xs-4 ${not empty measurement.sleeve ? '':'hide'}">
		<a href="#" class="anchorblack" onclick="editmeasurement(this);;return false;"
			data-detail="waist" data-detail1="sleeve1">
			<div class="col-xs-3 listrowvalue">${measurement.sleeve}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="sleeve1" class="col-xs-4 ${not empty measurement.sleeve ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.sleeve}" autocomplete="off" id="sleeve" name="sleeve"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Chest</div>
	<div id="chest2" class="col-xs-4 ${not empty measurement.chest ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="chest1">
			<div class="col-xs-3 listrowvalue">${measurement.chest}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="chest1" class="col-xs-4 ${not empty measurement.chest ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.chest}" autocomplete="off" id="chest" name="chest"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Waist</div>
	<div id="waist2" class="col-xs-4 ${not empty measurement.waist ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.waist}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="waist1" class="col-xs-4 ${not empty measurement.waist ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.waist}" autocomplete="off" id="waist" name="waist"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Shoe</div>
	<div id="shoe2" class="col-xs-4 ${not empty measurement.shoe ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="shoe1">
			<div class="col-xs-3 listrowvalue">${measurement.shoe}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="shoe1" class="col-xs-4 ${not empty measurement.shoe ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.shoe}" autocomplete="off" id="shoe" name="shoe"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Inseam</div>
	<div id="inseam2" class="col-xs-4 ${not empty measurement.inseam ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="waist" data-detail1="inseam1">
			<div class="col-xs-3 listrowvalue">${measurement.inseam}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="inseam1" class="col-xs-4 ${not empty measurement.inseam ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.inseam}" autocomplete="off" id="inseam" name="inseam"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Jacket</div>
	<div id="jacket2" class="col-xs-4 ${not empty measurement.jacket ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="jacket" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.jacket}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="jacket1" class="col-xs-4 ${not empty measurement.jacket ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.jacket}" autocomplete="off" id="jacket" name="jacket"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Shirt</div>
	<div id="shirt2" class="col-xs-4 ${not empty measurement.shirt ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="shirt" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.shirt}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="shirt1" class="col-xs-4 ${not empty measurement.shirt ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.shirt}" autocomplete="off" id="shirt" name="shirt"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Weight</div>
	<div id="weight2" class="col-xs-4 ${not empty measurement.weight ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="weight" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.weight}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="weight1" class="col-xs-4 ${not empty measurement.weight ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.weight}" autocomplete="off" id="weight" name="weight"/>
	</div>

</div>

<div class="row listrowmeasurement ">
	<div class="col-xs-8">Height</div>
	<div id="height2" class="col-xs-4 ${not empty measurement.height ? '':'hide'}">
		<a href="" class="anchorblack" onclick="editmeasurement(this);"
			data-detail="height" data-detail1="waist1">
			<div class="col-xs-3 listrowvalue">${measurement.height}</div>
			<div class="col-xs-1 measurementedit">

				<span class="glyphicon glyphicon-edit"></span>


			</div>
		</a>
	</div>
	<div id="height1" class="col-xs-4 ${not empty measurement.height ? 'hide':''}">
		<input type="text" class="measurementinput"  value="${measurement.height}" autocomplete="off" id="height" name="height"/>
	</div>

</div>

<div class="bottom-btn-container">
	<div class="col-xs-6">
		<button type="submit" class="btn btn-default  fashionbutton">Cancel</button>
	</div>
	<div class="col-xs-6">
		<button type="submit" class="btn btn-default fashionbutton" onclick="saveClientMeasurements();" >Save</button>
	</div>
</div>

</div>