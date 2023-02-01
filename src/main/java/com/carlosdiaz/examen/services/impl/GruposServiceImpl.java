package com.carlosdiaz.examen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdiaz.examen.model.Grupo;
import com.carlosdiaz.examen.repository.GrupoRepository;
import com.carlosdiaz.examen.services.GruposService;

@Service
public class GruposServiceImpl implements GruposService{

    @Autowired
    GrupoRepository grupoRepository;
    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo find(int codigo) {
        Optional<Grupo> findById = grupoRepository.findById(codigo);
        if(findById!= null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Grupo grupo) {
        grupoRepository.save(grupo);
        
    }

    @Override
    public void update(Grupo grupo) {
        grupoRepository.save(grupo);
        
    }

    @Override
    public void delete(int codigo) {
        grupoRepository.deleteById(codigo);
        
    }
    
}
