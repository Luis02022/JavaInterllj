package com.example.senai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.senai.model.Usuario;
import com.example.senai.service.UsuarioService;

import jakarta.validation.Valid;

@CrossOrigin(origins =  "*" )// Aceita a conexão de aplicações externas.
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> ListarTodos(){
        return usuarioService.ListarTodos();
    } 


    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Usuario salvo com sucesso"));
    }
}
