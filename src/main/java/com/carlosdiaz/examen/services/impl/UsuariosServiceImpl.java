package com.carlosdiaz.examen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdiaz.examen.model.Usuario;
import com.carlosdiaz.examen.repository.UsuarioRepository;
import com.carlosdiaz.examen.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    UsuarioRepository repository;
    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario find(int codigo) {
        Optional<Usuario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
        
    }

    @Override
    public void update(Usuario usuario) {
        repository.save(usuario);
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
        
    }
    
}
