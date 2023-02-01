package com.carlosdiaz.examen.controllers;

import java.util.List;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlosdiaz.examen.model.Grupo;
import com.carlosdiaz.examen.model.Usuario;
import com.carlosdiaz.examen.services.GruposService;

@Controller
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    GruposService gruposService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        List<Grupo> grupos = gruposService.findAll();
        ModelAndView modelAndView = new ModelAndView("grupos/list");
        modelAndView.addObject("grupos", grupos);
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo, final Locale locale) {

        Grupo grupo = gruposService.find(codigo);
        List<Usuario> usuarios = grupo.getUsuarios();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", grupo);
        modelAndView.addObject("usuarios", usuarios);

        modelAndView.setViewName("grupos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Grupo grupo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", new Grupo());
        modelAndView.setViewName("grupos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Grupo grupo) {

        gruposService.save(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Grupo grupo) {

        gruposService.update(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        gruposService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}
