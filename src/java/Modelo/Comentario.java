/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author artem
 */
public class Comentario {
    private String comentario;
    private int id;
    private String comentarista;
    private String comentariado;
    private String fecha;
    private int idR;
    public Comentario() {
    }

    public Comentario(String comentario, int id, String comentarista, String comentariado, String fecha) {
        this.comentario = comentario;
        this.id = id;
        this.comentarista = comentarista;
        this.comentariado = comentariado;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentarista() {
        return comentarista;
    }

    public void setComentarista(String comentarista) {
        this.comentarista = comentarista;
    }

    public String getComentariado() {
        return comentariado;
    }

    public void setComentariado(String comentariado) {
        this.comentariado = comentariado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    } 
}
