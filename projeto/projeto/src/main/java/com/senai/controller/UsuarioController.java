package com.senai.controller;

import com.senai.model.Usuario;
import com.senai.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(usuario);

    }

    @GetMapping("/buscar")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestBody String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarUsuarioPorId(@RequestBody Long id) {
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }


}
