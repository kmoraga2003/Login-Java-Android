package com.example.myapplication;

public class Usuario {

    private String nombreCompleto;
    private String rutUsuario;
    private String numeroTelefono;
    private String correoEmail;
    private String claveAcceso;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreCompleto, String rutUsuario, String numeroTelefono, String correoEmail, String claveAcceso, String tipoUsuario) {
        this.nombreCompleto = nombreCompleto;
        this.rutUsuario = rutUsuario;
        this.numeroTelefono = numeroTelefono;
        this.correoEmail = correoEmail;
        this.claveAcceso = claveAcceso;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoEmail() {
        return correoEmail;
    }

    public void setCorreoEmail(String correoEmail) {
        this.correoEmail = correoEmail;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
