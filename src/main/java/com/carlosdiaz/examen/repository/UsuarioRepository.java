package com.carlosdiaz.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosdiaz.examen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}