package com.carlosdiaz.examen.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carlosdiaz.examen.model.Permiso;
import com.carlosdiaz.examen.model.Usuario;
import com.carlosdiaz.examen.services.GruposService;
import com.carlosdiaz.examen.services.PermisosService;
import com.carlosdiaz.examen.services.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    GruposService gruposService;

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    PermisosService permisosService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        List<Usuario> usuarios = usuariosService.findAll();
        ModelAndView modelAndView = new ModelAndView("usuarios/list");
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo, final Locale locale) {

        Usuario usuario = usuariosService.find(codigo);
        
        List<Permiso> permisos = permisosService.findAll();
        for(Permiso permiso : permisos){
            if(usuario.getPermisos().contains(permiso)){
                usuario.setTienePermiso(true);
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("permisos", permisos);

        modelAndView.setViewName("usuarios/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Usuario Usuario) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("usuarios/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Usuario usuario) {

        usuariosService.save(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario, @RequestParam(value="ck_permisos") int[] ck_permisos) {

        List<Permiso> permisos = usuario.getPermisos();
        if(permisos == null){
            permisos = new ArrayList<Permiso>();
        }

        for (int i : ck_permisos) {
            Permiso a = new Permiso(i);
            permisos.add(a);
        }

        usuario.setPermisos(permisos);

        usuariosService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        usuariosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}