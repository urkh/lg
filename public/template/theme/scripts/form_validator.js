$.validator.setDefaults(
{
//	submitHandler: function() { alert("submitted!"); },
	showErrors: function(map, list) 
	{
		this.currentElements.parents('label:first, .controls:first').find('.error').remove();
		this.currentElements.parents('.control-group:first').removeClass('error');
		
		$.each(list, function(index, error) 
		{
			var ee = $(error.element);
			var eep = ee.parents('label:first').length ? ee.parents('label:first') : ee.parents('.controls:first');
			
			ee.parents('.control-group:first').addClass('error');
			eep.find('.error').remove();
			eep.append('<p class="error help-block"><span class="label label-important">' + error.message + '</span></p>');
		});
		//refreshScrollers();
	}
});

$(function()
{
	// validate signup form on keyup and submit
	$("#validarForm").validate({
		rules: {

			estado: "required",
			norte: "required",
			sur: "required",
			credito: "required",
			este: "required",
			oeste: "required",
			fundo: "required",
			nombre: "required",
			apellido: "required",
			requerido: "required",
			direccion: "required",
			fechaNac: "required",
			fecha: "required",
			fechaPago: "required",
			fechaSol: "required",
			gradoInstruccion: "required",
			estadoCivil: "required",
			medicamentos: "required",
			tipoVivienda: "required",
			solicitud: "required",
			sexo: "required",
			enfermedad: "required",
			mesCorrespondiente: "required",
			estudiante: "required",
			denunciado: "required",
			denuncia: "required",

			tPantalon: "required",
			tZapatos: "required",
			tFranelas: "required",
			tipoAyuda: "required",

			cedula: {
				number:true,
				required: true,
				minlength: 6,
				maxlength: 8
			},

			telefono: {
				number:true,
				minlength: 11,
				maxlength: 11
			},

			ingresoMensual: {
				number:true,
				required: true
			},

			monto: {
				number:true,
				required: true
			},


			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			topic: {
				required: "#newsletter:checked",
				minlength: 2
			},
			agree: "required"
		},
		messages: {
			


			estado: "Este campo es obligatorio",
			norte: "Este campo es obligatorio",
			sur: "Este campo es obligatorio",
			este: "Este campo es obligatorio",
			oeste: "Este campo es obligatorio",
			fundo: "Este campo es obligatorio",
			credito: "Este campo es obligatorio",

			denunciado: "Este campo es obligatorio",
			denuncia: "Este campo es obligatorio",
			solicitud: "Este campo es obligatorio",
			nombre: "Este campo es obligatorio",
			apellido: "Este campo es obligatorio",
			direccion: "Este campo es obligatorio",
			fechaNac: "Este campo es obligatorio",
			mesCorrespondiente: "Este campo es obligatorio",
			fechaPago: "Este campo es obligatorio",
			fecha: "Este campo es obligatorio",
			fechaSol: "Este campo es obligatorio",
			sexo: "Este campo es obligatorio",
			medicamentos: "Este campo es obligatorio",
			enfermedad: "Este campo es obligatorio",
			tipoAyuda: "Este campo es obligatorio",
			
			gradoInstruccion: "Este campo es obligatorio",
			tipoVivienda: "Este campo es obligatorio",
			estadoCivil: "Este campo es obligatorio",
			estudiante: "Este campo es obligatorio",

			tZapatos: "Este campo es obligatorio",
			tFranelas: "Este campo es obligatorio",
			tPantalon: "Este campo es obligatorio",

			ingresoMensual:{ 
				number: "Debe ingresar solo numeros",
				required: "Este campo es obligatorio"
			},


			monto:{ 
				number: "Debe ingresar solo numeros",
				required: "Este campo es obligatorio"
			},



			cedula: {
				number: "Debe ingresar solo numeros",
				required: "Debe ingresar una cedula",
				minlength: "Minimo 6 caracteres",
				maxlength: "Maximo 8 caracteres"
			},

			telefono: {
				number: "Debe ingresar solo numeros",
				minlength: "Minimo 11 caracteres",
				maxlength: "Maximo 11 caracteres"
			},



			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy"
		}
	});


	//code to hide topic selection, disable for demo
	var newsletter = $("#newsletter");
	// newsletter topics are optional, hide at first
	var inital = newsletter.is(":checked");
	var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
	var topicInputs = topics.find("input").attr("disabled", !inital);
	// show when newsletter is checked
	newsletter.click(function() {
		topics[this.checked ? "removeClass" : "addClass"]("gray");
		topicInputs.attr("disabled", !this.checked);
	});
});