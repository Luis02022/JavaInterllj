package com.senai.aulinha2.controller;

import com.senai.aulinha2.model.Funcionario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.aulinha2.service.FuncionarioService;

import  java.util.List;
import  java.util.Map;

@RestController
@RequestMapping (name = "tab_funcionario")
public class Welcome {
    private FuncionarioService funcionarioService;

    public Welcome(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/bemvindo")
    public String welcome(){
        return "Bem vindo Luis!!";
    }


    @GetMapping("/lista")
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                 .body(Map.of("message", "Funcionario cadastrado com sucesso!!"));
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário Cadastrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body("Funcionário excluido co sucesso!");
    }


}
