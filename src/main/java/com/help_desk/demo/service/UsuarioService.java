package com.help_desk.demo.service;

import com.help_desk.demo.entities.Atendente;
import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.exception.UsuarioException;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario findById(Long id) throws UsuarioException {
        Usuario resultado =  usuarioRepositorio.findById(id).orElse(null);
        if (resultado == null) {
            throw new UsuarioException("Usuário Nao encontrado");
        }
        return resultado;
    }

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario save(Usuario usuario)  {
        Usuario resultado = usuarioRepositorio.save(usuario);
        return  resultado;
    }

}
