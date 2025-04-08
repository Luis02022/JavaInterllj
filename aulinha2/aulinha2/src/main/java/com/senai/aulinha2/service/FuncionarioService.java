package com.senai.aulinha2.service;


import com.senai.aulinha2.model.Funcionario;
import com.senai.aulinha2.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (this.funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Funcionario já cadastrado.");
        } else {
            return (Funcionario)this.funcionarioRepository.save(funcionario);
        }
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionarioAtualiza = (Funcionario)this.funcionarioRepository.findById(funcionario.getId()).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        funcionarioAtualiza.setNome(funcionario.getNome());
        funcionarioAtualiza.setEmail(funcionario.getEmail());
        return (Funcionario)this.funcionarioRepository.save(funcionarioAtualiza);
    }

    public void excluir(Long id) {
        Funcionario funcionario = (Funcionario)this.funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
        this.funcionarioRepository.deleteById(id);
    }
}