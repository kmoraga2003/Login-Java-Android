package com.example.myapplication;

public class Tarea {

    private String tituloTarea;
    private String categoriaTarea;
    private boolean esUrgente;
    private int prioridadTarea;
    private boolean estaCompletada;

    public Tarea() {
    }

    public Tarea(String tituloTarea, String categoriaTarea, boolean esUrgente, int prioridadTarea, boolean estaCompletada) {
        this.tituloTarea = tituloTarea;
        this.categoriaTarea = categoriaTarea;
        this.esUrgente = esUrgente;
        this.prioridadTarea = prioridadTarea;
        this.estaCompletada = estaCompletada;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public String getCategoriaTarea() {
        return categoriaTarea;
    }

    public void setCategoriaTarea(String categoriaTarea) {
        this.categoriaTarea = categoriaTarea;
    }

    public boolean isEsUrgente() {
        return esUrgente;
    }

    public void setEsUrgente(boolean esUrgente) {
        this.esUrgente = esUrgente;
    }

    public int getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(int prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }

    public boolean isEstaCompletada() {
        return estaCompletada;
    }

    public void setEstaCompletada(boolean estaCompletada) {
        this.estaCompletada = estaCompletada;
    }
}
