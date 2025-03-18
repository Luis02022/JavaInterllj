package com.senai.repository;

import com.senai.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}
