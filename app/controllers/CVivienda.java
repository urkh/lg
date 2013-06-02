package controllers;

import models.Vivienda;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formVivienda;
import views.html.listaVivienda;

public class CVivienda extends Controller {


	public static Result Inicio = redirect("/vivienda/lista");

	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaVivienda.render(Vivienda.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}

	public static Result index() {
		return Inicio;
	}

		public static Result editar(Long id){
		Form<Vivienda> formRVivienda = form(Vivienda.class).fill(Vivienda.buscar.byId(id));
		return ok(formVivienda.render(formRVivienda));
	}

	public static Result actualizar(){
		Form<Vivienda> formRVivienda = form(Vivienda.class).bindFromRequest();

		String ids = formRVivienda.field("id").value();

		Long id = Long.parseLong(ids);
		formRVivienda.get().update(id);
		flash("exito", "Solicitud actualizada con exito");
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