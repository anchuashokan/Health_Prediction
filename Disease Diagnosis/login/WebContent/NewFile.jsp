<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    </head>
<body>
    
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
    $("#btnAdd").bind("click", function () {
        var div = $("<div />");
        div.html(GetDynamicTextBox(""));
        $("#TextBoxContainer").append(div);
    });
    $("#btnGet").bind("click", function () {
       // var values = "";
        $("input[name=DynamicTextBox]").each(function () {
           values += $(this).val() + " ";
        	 // var option=document.createElement("option");
             //option.text= $(this).val();
             //option.prop("selected",true);
           // document.getElementById('txt1').add(option);
            
        });
       alert(values);
      
        document.getElementById('txt1').value=values;
    });
    $("body").on("click", ".remove", function () {
        $(this).closest("div").remove();
    });
});
function GetDynamicTextBox(value) {
    return '<input name = "DynamicTextBox" type="text" value = "' + value + '" />&nbsp;' +
            '<input type="button" value="Remove" class="remove" />'
}
submitForm()
{
	document.forms["myform"].submit();
	}
</script>
   <form  id="myform" action="demo" method="post">
 <input id="btnAdd" type="button" value="Add" />
<br />
<br />
<div id="TextBoxContainer">
    <!--Textboxes will be added here -->
</div>
<br />
<input id="btnGet" type="button" value="Get Values" onClick="submitForm()" />
 <input type="text" id="txt1" name="txtname" >
 <!--  <input type="submit" id="btnGet" name="Find Disease" value="Submit">-->
 
</form>
</body>
</html>
