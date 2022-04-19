package com.sistema.blog.sistemablogspringbootapirest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ComentarioDTO {

    private long id;

    @NotEmpty(message = "El nombre no debe ser vacío o nulo")
    private String nombre;

    @NotEmpty(message = "El email no debe ser vacío o nulo")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, message = "El cuerpo del comentario debe tener al menos 10 caracteres")
    private String cuerpo;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public ComentarioDTO() {
        super();
    }

}
