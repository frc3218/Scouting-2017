<?php
header("access-control-allow-origin: http://www.monixgameware.com");

require_once("config.php");

// SYNC METHODS //
function GetMasterList()
{
	$json = file_get_contents(GetDBDir() . "masterlist.json");
	return(json_decode($json, true));
}

function TeamInMaster($number)
{
	$master = GetMasterList();
	
	if(isset($master[0][$number]))
	{
		return(true);
	}
	else
	{
		return(false);
	}
}

function Locked()
{
	return(file_exists("lock.dat"));
}

function Lock()
{
	$f = fopen("lock.dat", "w");
	fclose($f);
}

function Unlock()
{
	unlink("lock.dat");
}
// SYNC METHODS //

function TeamExists($number) 
{
	return(file_exists(GetDBDir() . $number . "/team.json"));
}

function GetTeamName($number)
{
	$file = file_get_contents(GetDBDir() . $number . "/team.json");
	$data = json_decode($file, true);
	
	return($data["team"]["name"]);
}

function CreateTeam($number, $name)
{
	mkdir(GetDBDir() . $number);
	
	$data = array
	(
		"team" => array("number" => $number, "name" => $name)
	);
	
	$json = json_encode($data);
	
	file_put_contents(GetDBDir() . $number . "/team.json", $json);
	
}

function NewMatch($teamNumber, $accuracy, $climbed, $overallScore, $topScore, $bottomScore, $gears, $penalties, $strategy, $specialty)
{
	$match = array
	(
		"shotAccuracy" => $accuracy,
		"climbed" => $climbed,
		"overallScore" => $overallScore,
		"topScore" => $topScore,
		"bottomScore" => $bottomScore,
		"gearsDelivered" => $gears,
		"penalties" => $penalties,
		"strategy" => (isset($strategy) ? $strategy : ""),
		"specialty" => (isset($specialty) ? $specialty : array(null))
	);
	
	while(Locked())
	{
		sleep(1.5);
	}
	
	if(!TeamInMaster($teamNumber))
	{
		$teamArray = array($teamNumber => array());
		$master = GetMasterList();
		
		$master[0][$teamNumber] = array();
		
		foreach($match as $key => $value)
		{
			$master[0][$teamNumber][0][$key] = $value;
		}
		
		$data = json_encode($master);
		
		Lock();
		file_put_contents(GetDBDir() . "masterlist.json", $data);
		Unlock();
	}
	else
	{
		$master = GetMasterList();
		$count = count($master[0][$teamNumber]);
		
		foreach($match as $key => $value)
		{
			$master[0][$teamNumber][$count][$key] = $value;
		}
		
		$data = json_encode($master);
	
		Lock();
		file_put_contents(GetDBDir() . "masterlist.json", $data);
		Unlock();
	}
}

// Operations for interacting with the file database via HTTP POST/GET
if(isset($_GET))
{
	$cmd = $_GET["command"];
	$arg = $_GET["arg"];
	
	switch($cmd)
	{
		case "GetTeamName":
			if(TeamExists($arg))
			{
				echo(GetTeamName($arg));
			}
		break;
	}
}
?>