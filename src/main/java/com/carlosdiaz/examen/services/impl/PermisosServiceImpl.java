package com.carlosdiaz.examen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdiaz.examen.model.Permiso;
import com.carlosdiaz.examen.repository.PermisoRepository;
import com.carlosdiaz.examen.services.PermisosService;

@Service
public class PermisosServiceImpl implements PermisosService {

    @Autowired
    PermisoRepository permisoRepository;

    @Override
    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Permiso find(int codigo) {
        Optional<Permiso> findById = permisoRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void save(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public void update(Permiso permiso) {

        permisoRepository.save(permiso);
        
    }

    @Override
    public void delete(int codigo) {
        permisoRepository.deleteById(codigo);
    }
    
}
