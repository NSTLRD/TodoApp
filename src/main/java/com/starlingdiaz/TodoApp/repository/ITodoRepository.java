package com.starlingdiaz.TodoApp.repository;

import com.starlingdiaz.TodoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {

}
