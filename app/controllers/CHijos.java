package controllers;

import models.Hijos;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.db.DB;
import play.libs.Json;

import views.html.formHijos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CHijos extends Controller {


	public static Result Inicio = redirect("/ciudadanos/lista");

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Hijos> formRHijos = form(Hijos.class);
		return ok(formHijos.render(formRHijos));
	}


	public static Result guardar(){
		
		Form<Hijos> formRHijos = form(Hijos.class).bindFromRequest();

		formRHijos.get().save();
		flash("exito", formRHijos.get().nombreH + "   " + formRHijos.get().apellidoH +"  fue registrado exitosamente!");
		return Inicio;
		
	}



	public static Result buscarCedula() {
		Map<String,String[]> queryParameters = request().queryString();

		String cedulaRe = queryParameters.get("busqueda")[0];
		Connection con = DB.getConnection();
		Status resp = null;

		try{
			PreparedStatement pstm = con.prepareStatement("SELECT id FROM persona WHERE cedula='" + cedulaRe + "' ");

			ResultSet res = pstm.executeQuery();

			if (res.next()){

				Long idPersona = res.getLong("id");
							
				try{
					PreparedStatement pstm2 = con.prepareStatement("SELECT id, cedula_h, nombre_h, apellido_h FROM hijos WHERE persona_id='" + idPersona + "' ");
					ResultSet res2 = pstm2.executeQuery();				
			        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
					String idHijo;
					String cedula;
					String nombre;
					String apellido;

					while(res2.next()){

						idHijo = res2.getString("id");
						cedula = res2.getString("cedula_h");
						nombre = res2.getString("nombre_h");
						apellido = res2.getString("apellido_h");
											
			            Map<String, Object> item = new HashMap<String, Object>();
			            item.put("idHijo", idHijo);
			            item.put("cedula", cedula);
			            item.put("nombre", nombre);
			            item.put("apellido", apellido);
			            
			            results.add(item);

					}	
					
			        return ok(Json.toJson(results));
					

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}else{

				resp=badRequest("Cedula no encontrada");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		


		return resp;

	}
  
 
}