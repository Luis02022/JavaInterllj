package com.senai.aula.repositoy;

import com.senai.aula.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository<U> extends JpaRepository<Usuario, Long> {

}
