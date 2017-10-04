<?php
require_once("core/db/db.php");
session_start();

header("access-control-allow-origin: http://www.monixgameware.com");

if(isset($_POST["submit"]))
{
	if(isset($_POST["teamNumber"], $_POST["teamName"], $_POST["accuracy"], $_POST["climb"], $_POST["overallScore"], $_POST["topScore"], $_POST["bottomScore"], $_POST["gears"], $_POST["penalties"]))
	{
		$teamNumber = $_POST["teamNumber"];
		$teamName = $_POST["teamName"];
		$accuracy = $_POST["accuracy"];
		$climb = $_POST["climb"];
		$overallScore = $_POST["overallScore"];
		$topScore = $_POST["topScore"];
		$bottomScore = $_POST["bottomScore"];
		$gears = $_POST["gears"];
		$penalties = $_POST["penalties"];
		if(isset($_POST["strategy"])) $strategy = $_POST["strategy"];
		if(isset($_POST["specialty"])) $specialty = $_POST["specialty"];
		
		if(!TeamExists($teamNumber))
		{
			CreateTeam($teamNumber, $teamName);
		}
		
		NewMatch($teamNumber, $accuracy, $climb, $overallScore, $topScore, $bottomScore, $gears, $penalties, $strategy, $specialty);
		
		$_SESSION["notify"] = "Match data has been recorded";
		
	}
	else
	{
		$_SESSION["error"] = "Please input a value for all fields marked by a '*'";
	}
}

?>

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Panther Scouting</title>
		<link rel="stylesheet" href="assets/css/main.css">
		<script type="text/javascript" src="assets/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript"src="assets/js/db.js"></script>
	</head>
	
	<?php
		if(isset($_SESSION["error"]))
		{
			echo
			("
				<div id='messagebox'>
					<p class='messagecontent'>ERROR: " . $_SESSION['error'] . ". </p>
				</div>
			");
			
			unset($_SESSION["error"]);
		}
		
		if(isset($_SESSION["notify"]))
		{
			echo
			("
				<div id='messagebox' style='background-color: #3c9958; border: 1px solid #277b40'>
					<p class='messagecontent'>NOTICE: " . $_SESSION['notify'] . ". </p>
				</div>
           	");
			
			unset($_SESSION["notify"]);
		}
	?>
	
	<div class="container">  
	  <form id="match"  method="POST">
		<h3>New Match</h3>
		<h4>Submit data about a match.</h4>
		
		<p>Team Number *</p>
		<fieldset>
			<input type="number" name="teamNumber" id="teamNumber" min="0" max="65535" pattern="[0-9]" tabindex="1" required autofocus>
		</fieldset>
		
		<p>Team Name *</p>
		<fieldset>
			<input type="text" name="teamName" id="teamName" tabindex="2" required>
		</fieldset>
		
		<p>Shot Accuracy *</p>
		<fieldset>
			<select name="accuracy" tabindex="3" required>
				<option value="noShoot">Didn't Shoot</option>
				<option value="low">Low</option>
				<option value="medium">Medium</option>
				<option value="high">High</option>
			</select>
		</fieldset>
		
		<p>Climbing *</p>
		<fieldset>
			<p class="inlinetext">
			<input type="radio" name="climb" value="true" tabindex="4" required> Climbed<br>
			<input type="radio" name="climb" value="false" tabindex="5" required> Didn't Climb
			</p>
		</fieldset>
		
		<p>Overall Score *</p>
		<fieldset>
			<input type="number" value="0" name="overallScore" min="0" max="65535" pattern="[0-9]" tabindex="6" required>
		</fieldset>
		
		<p>Top Boiler Score *</p>
		<fieldset>
			<input type="number" value="0" name="topScore" min="0" max="65535" pattern="[0-9]" tabindex="7" required>
		</fieldset>
		
		<p>Bottom Boiler Score *</p>
		<fieldset>
			<input type="number" value="0" name="bottomScore" min="0" max="65535" pattern="[0-9]" tabindex="8" required>
		</fieldset>
		
		<p>Gears Delivered *</p>
		<fieldset>
			<input type="number" value="0" name="gears" min="0" max="65535" pattern="[0-9]" tabindex="9" required>
		</fieldset>
		
		<p>Penalties *</p>
		<fieldset>
			<input type="number" value="0" name="penalties" min="0" max="65535" pattern="[0-9]" tabindex="10" required>
		</fieldset>
		
		<p>Strategy</p>
		<fieldset>
			<textarea name="strategy" tabindex="11"></textarea>
		</fieldset>
		
		<p>Specialties</p>
		<fieldset>
			<p class="inlinetext">
				<input type="checkbox" name="specialty[]" value="shootTop"> Shooting Top Boiler<br>
				<input type="checkbox" name="specialty[]" value="shootBottom"> Shooting Bottom Boiler<br>
				<input type="checkbox" name="specialty[]" value="deliverGears"> Delivering Gears<br>
				<input type="checkbox" name="specialty[]" value="climbing"> Climbing<br>
			</p>
		</fieldset>
		
		<fieldset>
		  <button name="submit" type="submit" id="contact-submit" data-submit="Submitting..." tabindex="13">Submit Match Data</button>
		</fieldset>
	  </form>
	</div>
</html>