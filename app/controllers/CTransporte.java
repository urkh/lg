package controllers;

import models.Transporte;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formTransporte;
import views.html.listaTransporte;

public class CTransporte extends Controller {


	public static Result Inicio = redirect("/transporte/lista");

	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaTransporte.render(Transporte.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Transporte> formRTransporte = form(Transporte.class);
		return ok(formTransporte.render(formRTransporte));
	}


	public static Result guardar(){
		
		Form<Transporte> formRTransporte = form(Transporte.class).bindFromRequest();
		formRTransporte.get().save();
		flash("exito", "Pago registrado exitosamente!");
		return Inicio;
		
	}


  
 
}