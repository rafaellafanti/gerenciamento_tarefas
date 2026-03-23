package com.example.gerenciamento_tarefas.controllers;

import com.example.gerenciamento_tarefas.models.TarefaModel;
import com.example.gerenciamento_tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criar(@RequestBody TarefaModel tarefa) {
        TarefaModel nova = tarefaService.salvar(tarefa);
        URI uri = URI.create("/tarefas/" + nova.getId());
        return ResponseEntity.created(uri).body(nova);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listar() {
        return ResponseEntity.ok(tarefaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscar(@PathVariable Long id) {
        TarefaModel tarefa = tarefaService.buscarPorId(id);

        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizar(@PathVariable Long id,
                                                 @RequestBody TarefaModel tarefa) {
        TarefaModel atualizada = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}