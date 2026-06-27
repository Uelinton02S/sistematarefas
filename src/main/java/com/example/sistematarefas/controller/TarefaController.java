package com.example.sistematarefas.controller;

import com.example.sistematarefas.model.Tarefa;
import com.example.sistematarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/tarefas")
    public String listar(Model model, Principal principal) {
        model.addAttribute("tarefas", tarefaService.listar());
        model.addAttribute("usuario", principal.getName());
        return "tarefas/index";
    }

    @GetMapping("/tarefas/nova")
    public String nova(Model model, Principal principal) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("usuario", principal.getName());
        return "tarefas/form";
    }

    @PostMapping("/tarefas")
    public String criar(@ModelAttribute Tarefa tarefa) {
        tarefaService.criar(tarefa);
        return "redirect:/tarefas";
    }

    @GetMapping("/tarefas/{id}/editar")
    public String editar(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("tarefa", tarefaService.buscarPorId(id));
        model.addAttribute("usuario", principal.getName());
        return "tarefas/form";
    }

    @PostMapping("/tarefas/{id}/editar")
    public String atualizar(@PathVariable Long id, @ModelAttribute Tarefa tarefa) {
        tarefaService.atualizar(id, tarefa);
        return "redirect:/tarefas";
    }

    @PostMapping("/tarefas/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return "redirect:/tarefas";
    }
}