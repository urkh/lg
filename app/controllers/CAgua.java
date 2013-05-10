package controllers;

import models.Agua;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formAgua;

public class CAgua extends Controller {


	public static Result Inicio = redirect(routes.CAgua.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Agua> formRAgua = form(Agua.class);
		return ok(formAgua.render(formRAgua));
	}


	public static Result guardar(){
		
		Form<Agua> formRAgua = form(Agua.class).bindFromRequest();
		formRAgua.get().save();
		flash("exito", "Pago registrado exitosamente!");
		return Inicio;
		
	}
  
 
}