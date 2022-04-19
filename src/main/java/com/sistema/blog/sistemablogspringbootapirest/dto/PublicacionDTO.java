package com.sistema.blog.sistemablogspringbootapirest.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sistema.blog.sistemablogspringbootapirest.entidades.Comentario;

public class PublicacionDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicación debería tener al menos 2 caracteres")
    private String titulo;

    @NotEmpty
    @Size(min = 10, message = "La descripción de la publicación debería tener al menos 10 caracteres")
    private String descripcion;

    @NotEmpty(message = "No debe estar vacío")
    private String contenido;

    private Set<Comentario> comentarios;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Set<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public PublicacionDTO() {
        super();
    }

}
