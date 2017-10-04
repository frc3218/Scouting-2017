$(document).ready(function()
{
	changeTimer = false;

    $("#teamNumber").on("input", function()
    {       if(changeTimer !== false) clearTimeout(changeTimer);
	
			changeTimer = setTimeout(function()
			{
				var textboxvalue = $('input[name=teamNumber]').val();

				$.ajax(
				{
					type: "GET",
					url: 'http://monixgameware.com/scout/core/db/db.php',
					data: {command: "GetTeamName",
					arg: textboxvalue},
					
					success: function(result)
					{
						$("#teamName").val(result);
					}
				});
			
			changeTimer = false;
			}, 1000)
    });
})