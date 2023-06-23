package com.example.todo.todo;

public interface TodoRepository {
    public Todo save(Todo todo);
    public Todo findById(Long id);
}
