package com.citas;

public class Administrador {

    private String usuario = "admin";
    private String password = "1234";

    public boolean login(String usuario, String password) {

        return this.usuario.equals(usuario)
                && this.password.equals(password);
    }
}
