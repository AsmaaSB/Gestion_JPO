/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class User {
    private String login;
    private String password;
   
   public User(String login, String password){
       this.login = login;
       this.password = password;
   }
   
   public String getLogin(){
       return login;
   }
   
   public String getPassword(){
       return password;
   }
}
