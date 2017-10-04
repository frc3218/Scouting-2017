<?php
require_once("core/sync/sync.php");

	function test($json)
	{
			$x = json_decode($json, true);
			$y = array(
				"3218" => array
				(
					"shotAccuracy" => "low",
					"climbed" => "true",
					"overallScore" => "50",
					"topScore" => "4",
					"bottomScore" => "5",
					"gearsDelivered" => "1",
					"penalties" => "1",
					"strategy" => "Cool strategy!",
					"specialty" => array("topScore", "bottomScore")
				)
			);
			
			$z = json_encode($y);
			
			echo($y["3218"]);
			
	}
	
	$data = array
	(
		"1111" => array
		(
			"teamNumber" => "3218",
			"shotAccuracy" => "low",
			"climbed" => "true",
			"overallScore" => "50",
			"topScore" => "4",
			"bottomScore" => "5",
			"gearsDelivered" => "1",
			"penalties" => "1",
			"strategy" => "Cool strategy!",
			"specialty" => array("topScore", "bottomScore")
		),
	);
	
	$u = file_get_contents("db/masterlist.json");
	$t = json_decode($u, true);
	$p = json_decode(json_encode($data), true);
	PushMatch($p, $t);
?>