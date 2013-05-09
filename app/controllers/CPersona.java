package controllers;

import models.Persona;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formPersona;

public class CPersona extends Controller {


	public static Result Inicio = redirect(routes.CPersona.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Persona> formRPersona = form(Persona.class);
		return ok(formPersona.render(formRPersona));
	}


	public static Result guardar(){
		
		Form<Persona> formRPersona = form(Persona.class).bindFromRequest();
		
		if (formRPersona.hasErrors()) {
			return badRequest(formPersona.render(formRPersona));
		}
		
		formRPersona.get().save();
		flash("exito", "El Ciudadano <b>" + formRPersona.get().nombre + " " + formRPersona.get().apellido +"</b> fue registrado exitosamente!");
		return Inicio;
		
	}
  
 
}