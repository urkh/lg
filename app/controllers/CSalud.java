package controllers;

import models.Salud;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formSalud;
import views.html.listaSalud;

public class CSalud extends Controller {



	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaSalud.render(Salud.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect(routes.CSalud.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Salud> formRSalud = form(Salud.class);
		return ok(formSalud.render(formRSalud));
	}


	public static Result guardar(){
		
		Form<Salud> formRSalud = form(Salud.class).bindFromRequest();
		formRSalud.get().save();
		flash("exito", "Solicitud registrada exitosamente!");
		return Inicio;
		
	}


  
 
}