package com.carlosdiaz.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlosdiaz.examen.model.Permiso;
import com.carlosdiaz.examen.services.PermisosService;

@Controller
@RequestMapping("/permisos")
public class PermisoController {
    @Autowired
    PermisosService permisosService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        List<Permiso> permisos = permisosService.findAll();
        ModelAndView modelAndView = new ModelAndView("permisos/list");
        modelAndView.addObject("permisos", permisos);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Permiso permiso = permisosService.find(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permiso", permiso);

        modelAndView.setViewName("permisos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Permiso permiso) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permiso", new Permiso());
        modelAndView.setViewName("permisos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Permiso permiso) {

        permisosService.save(permiso);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + permiso.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Permiso permiso) {

        permisosService.update(permiso);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + permiso.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        permisosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}