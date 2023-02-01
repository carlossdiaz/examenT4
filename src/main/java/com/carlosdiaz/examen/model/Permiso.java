package com.carlosdiaz.examen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Permiso")
public class Permiso {
    @Id
    @GeneratedValue
    int codigo;
    String descripcion;
    public Permiso() {
    }
    
    public Permiso(int codigo) {
        this.codigo = codigo;
    }

    @ManyToMany
    @JoinTable(
        name = "permiso_usuario"
        , joinColumns = {
            @JoinColumn(name="permiso_codigo")
        }
        , inverseJoinColumns = {
            @JoinColumn(name = "usuario_codigo")
        }
    )
    private List<Usuario> usuarios;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permiso other = (Permiso) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    

}
