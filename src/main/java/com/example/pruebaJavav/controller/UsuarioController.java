package com.example.pruebaJavav.controller;
import com.example.pruebaJavav.entity.UsuarioEntity;
import com.example.pruebaJavav.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioEntity findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PostMapping
    public UsuarioEntity create(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioEntity update(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        if (!usuarioService.findById(id).isPresent()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}