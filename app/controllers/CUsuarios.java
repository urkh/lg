package controllers;

import models.Usuarios;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formUsuarios;
import views.html.listaUsuarios;

public class CUsuarios extends Controller {


	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaUsuarios.render(Usuarios.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect("/usuarios/lista");

	public static Result index() {
		return Inicio;
	}



	public static Result editar(Long id){
		Form<Usuarios> formRUsuarios = form(Usuarios.class).fill(Usuarios.buscar.byId(id));
		return ok(formUsuarios.render(formRUsuarios));
	}

	public static Result actualizar(){
		Form<Usuarios> formRUsuarios = form(Usuarios.class).bindFromRequest();

		String ids = formRUsuarios.field("id").value();

		Long id = Long.parseLong(ids);
		formRUsuarios.get().update(id);
		flash("exito", "Usuario actualizado con exito");
		return Inicio;
	}


	public static Result nuevo() {
		Form<Usuarios> formRUsuarios = form(Usuarios.class);
		return ok(formUsuarios.render(formRUsuarios));
	}


	public static Result guardar(){
		
		Form<Usuarios> formRUsuarios = form(Usuarios.class).bindFromRequest();
		formRUsuarios.get().save();
		flash("exito", "Usuario registrado exitosamente!");
		return Inicio;
		
	}


  
 
}