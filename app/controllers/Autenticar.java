package controllers;



import models.Usuarios;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

public class Autenticar extends Controller {


    public static Result Inicio = redirect("/inicio");
  

    public static Result validar() {


        Form<Usuarios> formU = form(Usuarios.class).bindFromRequest();
        String usuario = formU.field("usuario").value();
        String contrasena = formU.field("contrasena").value();

    
        if(Usuarios.validar(usuario, contrasena)==null){

        	flash("error", "Usuario o contrasena invalida!");
            
            return redirect("/");
            
        }else{
            
            Form<Usuarios> formUs = form(Usuarios.class).fill(Usuarios.buscar.where().eq("usuario", usuario).eq("contrasena", contrasena).findUnique());
            session("usuario", formUs.get().usuario);
            session("tipo", formUs.get().tipo);

            return Inicio;
    
        }
    }


    public static Result login() {
        Form<Usuarios> formU = form(Usuarios.class).bindFromRequest();
        return ok(login.render(formU));
    }


    public static Result logout() {
        session().clear();
        flash("success", "te has desconectado");
        return redirect(routes.Autenticar.login());
    }
  
}