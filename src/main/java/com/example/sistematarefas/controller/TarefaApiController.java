package com.example.sistematarefas.controller;

import com.example.sistematarefas.model.Tarefa;
import com.example.sistematarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaApiController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tarefaService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("mensagem", "Tarefa não encontrada"));
        }
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Tarefa tarefa) {
        Tarefa criada = tarefaService.criar(tarefa);
        return ResponseEntity.status(201).body(Map.of("mensagem", "Tarefa criada!", "id", criada.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(Map.of("mensagem", "Tarefa atualizada!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Tarefa excluída com sucesso!"));
    }
}