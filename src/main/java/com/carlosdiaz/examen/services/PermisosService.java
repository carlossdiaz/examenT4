package com.carlosdiaz.examen.services;

import java.util.List;


import com.carlosdiaz.examen.model.Permiso;

public interface PermisosService {
    
    public List<Permiso> findAll();
    public Permiso find(int codigo);
    public void save(Permiso permiso);
    public void update(Permiso permiso);
    public void delete(int codigo);
}
