package com.senai.service;

import com.senai.model.Usuario;
import com.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public void deletarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Atualizar
    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
