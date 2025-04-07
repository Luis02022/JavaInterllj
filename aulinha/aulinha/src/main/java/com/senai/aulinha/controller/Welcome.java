package com.senai.aulinha.controller;

import com.senai.aulinha.model.Funcionario;
import com.senai.aulinha.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Welcome {
    private FuncionarioService funcionarioService;


    public Welcome(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public String welcome(){
        return "Bem vindo!!";
    }

    @GetMapping
     public List<Funcionario> listarTodos(){
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of()"mensagem", "Usuario cadastrado com sucesso.");
    }

    @PutMapping
    public ResponseEntity<String>

}
