package com.sistema.blog.sistemablogspringbootapirest.repositorio;

import java.util.Optional;

import com.sistema.blog.sistemablogspringbootapirest.entidades.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByNombre(String nombre);
}
