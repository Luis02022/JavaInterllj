package com.senai.aulinha.service;

import com.senai.aulinha.model.Funcionario;
import com.senai.aulinha.model.Endereco;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Service;
import com.senai.aulinha.repository.FuncionarioRepository;


import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Funcionario já cadastrado.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualiza = funcionarioRepository.findById(funcionario.getId()).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionarioAtualiza.setNome(funcionario.getNome());
        funcionarioAtualiza.setEmail(funcionario.getEmail());

        return funcionarioRepository.save(funcionarioAtualiza);
    }

    public void excluir(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("Funcionário não encontrado")));
        funcionarioRepository.deleteById(id);
    }
}
