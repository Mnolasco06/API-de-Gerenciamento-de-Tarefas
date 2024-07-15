package todolist.com.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.com.todolist.model.Tarefa;
import todolist.com.todolist.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaServico {

    private TarefaRepository tarefaRepository = null;

    @Autowired
    public TarefaServico() {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
}