<?php
function GetMasterList()
{
	$master = file_get_contents($_SERVER["DOCUMENT_ROOT"] . "/scout/db/masterlist.json");
	return $master;
}

if($_POST["key"] == "panth3r")
{
	echo(GetMasterList());
}
?>
