package com.carlosdiaz.examen.services;

import java.util.List;


import com.carlosdiaz.examen.model.Usuario;

public interface UsuariosService {
    
    public List<Usuario> findAll();
    public Usuario find(int codigo);
    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int codigo);
}
