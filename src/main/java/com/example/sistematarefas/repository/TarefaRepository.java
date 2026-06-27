package com.example.sistematarefas.repository;

import com.example.sistematarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAllByOrderByCriadoEmDesc();
}