package com.senai.aula2.service;

import com.senai.aula2.model.Usuario;
import com.senai.aula2.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario){
        if (usuarioRepository.findbyEmail(usuario.getEmail()).isPresent()){
            throw new IllegalAccessException("Usuario Cadastrado");

        }
        return usuarioRepository.save(usuario);
    }



}
