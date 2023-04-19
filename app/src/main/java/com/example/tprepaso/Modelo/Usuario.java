package com.example.tprepaso.Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String mail, password;


    public Usuario() {
    }

    public Usuario(String mail, String password) {

        this.mail = mail;
        this.password = password;
    }


    public String getmail() {
        return mail;
    }

    public void setmail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}