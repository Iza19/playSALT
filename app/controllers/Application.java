package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void guardarUsuario(){

    }

    public static String tryToLogin (String email, String peanut) {
        User u = User.find("email", email).first();
        if(u == null) {
            return "{}";
        }
        if(u.compararPassword(peanut)){
            return User.serializador().serialize(u);
        };
        return "{}";
    }
}