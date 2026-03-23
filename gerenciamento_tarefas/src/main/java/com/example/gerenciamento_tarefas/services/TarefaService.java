package com.example.gerenciamento_tarefas.services;

import com.example.gerenciamento_tarefas.models.TarefaModel;
import com.example.gerenciamento_tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel salvar(TarefaModel tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<TarefaModel> listarTodos() {
        return tarefaRepository.findAll();
    }

    public TarefaModel buscarPorId(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public TarefaModel atualizar(Long id, TarefaModel tarefaAtualizada) {
        tarefaAtualizada.setId(id);
        return tarefaRepository.save(tarefaAtualizada);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
}