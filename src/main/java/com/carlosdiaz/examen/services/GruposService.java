package com.carlosdiaz.examen.services;

import java.util.List;

import com.carlosdiaz.examen.model.Grupo;

public interface GruposService {
    
    public List<Grupo> findAll();
    public Grupo find(int codigo);
    public void save(Grupo grupo);
    public void update(Grupo grupo);
    public void delete(int codigo);
}
