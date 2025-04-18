package com.senai.aulinha2.repository;

import com.senai.aulinha2.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
}