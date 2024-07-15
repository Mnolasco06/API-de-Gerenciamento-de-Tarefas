package todolist.com.todolist.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import todolist.com.todolist.model.Tarefa;
import todolist.com.todolist.service.TarefaServico;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {






}

