package todolist.com.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import todolist.com.todolist.model.Tarefa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaControlador {

    private Map<Long, Tarefa> tarefaRepository = new HashMap<>();
    private long currentId = 1;

    @Operation(summary = "Criar uma nova tarefa")
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setId(currentId++);
        tarefaRepository.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    @Operation(summary = "Obter uma tarefa pelo ID")
    @GetMapping("/{id}")
    public Tarefa obterTarefa(@PathVariable Long id) {
        return tarefaRepository.get(id);
    }

    @Operation(summary = "Obter todas as tarefas")
    @GetMapping
    public Collection<Tarefa> obterTodasTarefas() {
        return tarefaRepository.values();
    }

    @Operation(summary = "Atualizar uma tarefa pelo ID")
    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        if (tarefaRepository.containsKey(id)) {
            tarefa.setId(id);
            tarefaRepository.put(id, tarefa);
            return tarefa;
        } else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }

    @Operation(summary = "Deletar uma tarefa pelo ID")
    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaRepository.remove(id);
    }
}
