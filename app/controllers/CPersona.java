package controllers;

import models.Persona;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.db.DB;
import play.libs.Json;

import views.html.formPersona;
import views.html.listaPersona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CPersona extends Controller {


	public static Result Inicio = redirect(routes.CPersona.nuevo());

	public static Result index() {
		return Inicio;
	}

	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaPersona.render(Persona.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result nuevo() {
		Form<Persona> formRPersona = form(Persona.class);
		return ok(formPersona.render(formRPersona));
	}


	public static Result guardar(){
		
		Form<Persona> formRPersona = form(Persona.class).bindFromRequest();

		formRPersona.get().save();
		flash("exito", "El Ciudadano  " + formRPersona.get().nombre + "   " + formRPersona.get().apellido +"  fue registrado exitosamente!");
		return Inicio;
		
	}



	public static Result buscarCedula() {
		Map<String,String[]> queryParameters = request().queryString();

		String cedulaRe = queryParameters.get("busqueda")[0];
		Connection con = DB.getConnection();
		Status resp = null;

		try{
			PreparedStatement pstm = con.prepareStatement("SELECT id, cedula, nombre, apellido FROM persona WHERE cedula='" + cedulaRe + "' ");

			ResultSet res = pstm.executeQuery();

			if (res.next()){

				String idPersona = res.getString("id");
				String cedula = res.getString("cedula");
				String nombre = res.getString("nombre");
				String apellido = res.getString("apellido");

				Map<String,String> d = new HashMap<String,String>();


				d.put("persona.id",idPersona);
				d.put("cedula",cedula);
				d.put("nombre",nombre);
				d.put("apellido",apellido);


				resp=ok(Json.toJson(d));

			}else{

				resp=badRequest("Cedula no encontrada");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return resp;

	}
  
 
}