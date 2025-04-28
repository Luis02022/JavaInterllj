package com.senai.aula2.controller;

import com.senai.aula2.model.Usuario;
import com.senai.aula2.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity

}
