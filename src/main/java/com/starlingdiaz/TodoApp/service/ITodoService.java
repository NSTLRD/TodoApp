package com.starlingdiaz.TodoApp.service;

import com.starlingdiaz.TodoApp.dto.TodoDto;

import java.util.List;

public interface ITodoService {

    //method to add a todo
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodoById(Long id);

    //we use List interface to return all the data
    List<TodoDto> getAllTodos();
    TodoDto updateTodo(TodoDto todoDto,Long id);

    void deleteTodo(Long id);
    TodoDto completeTodo (Long id);
    TodoDto inCompleteTodo (Long id);
}
