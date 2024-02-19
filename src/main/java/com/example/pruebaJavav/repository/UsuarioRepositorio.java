package com.example.pruebaJavav.repository;

import com.example.pruebaJavav.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity,Long> {
}
