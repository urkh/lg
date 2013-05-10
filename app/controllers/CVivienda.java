package controllers;

import models.Vivienda;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formVivienda;

public class CVivienda extends Controller {


	public static Result Inicio = redirect(routes.CVivienda.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Vivienda> formRVivienda = form(Vivienda.class);
		return ok(formVivienda.render(formRVivienda));
	}


	public static Result guardar(){
		
		Form<Vivienda> formRVivienda = form(Vivienda.class).bindFromRequest();
		formRVivienda.get().save();
		flash("exito", "Solicitud registrada exitosamente!");
		return Inicio;
		
	}
  
 
}