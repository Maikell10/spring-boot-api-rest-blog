package com.sistema.blog.sistemablogspringbootapirest.repositorio;

import com.sistema.blog.sistemablogspringbootapirest.entidades.Publicacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
    
}
