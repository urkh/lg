$(document).ready(function() {

$('#buscarCedula').click(function(){
var cedula = $("#cedula").val();
        $.getJSON('/buscarCedula?busqueda='+cedula, function(data) {
         for (var i in data) {
         $('input[name="'+i+'"]').val(data[i]);
            }
        }).error(function(data) {
            window.alert('Error: ' + data.responseText);
        });
});



$('#buscarCedulaH').click(function(){

	var cedula = $("#cedula").val();


	$.getJSON('/buscarCedulaH?busqueda='+cedula, function(data){
		var toAppend = "<option></option>";
  		for(var i = 0; i < data.length; i++){
      		toAppend += '<option value = \"' + data[i].idHijo + '\">' + data[i].nombre +"  "+ data[i].apellido + '</option>';
  		}

  		
  		$("#hijos").empty();
  		$("#hijos").html(toAppend);
	}, "json").error(function(data) {
        window.alert('Error: ' + data.responseText);
    });;


});


  
    
}); 
