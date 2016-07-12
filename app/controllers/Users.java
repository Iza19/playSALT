package controllers;

import  models.User;
/**
 * Created by iza on 7/11/16.
 */
public class Users extends CRUD {


    public static void create(){
        System.out.println("hihi ");
        User user = params.get("object", User.class);
        System.out.println("object.email = " + user.email);
        user.encriptarPassword();
        System.out.println("user.peanut = " + user.peanut);
        user.save();
    }



}
