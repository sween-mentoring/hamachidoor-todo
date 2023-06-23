package com.example.todo.todo;

import java.util.HashMap;
import java.util.Map;

public class TodoMemoryRepository implements TodoRepository {
    private static long id;
    private static Map<Long, Todo> todos = new HashMap<>();

    @Override
    public Todo save(Todo todo) {
        Todo saved = new Todo(id++, todo.getTitle(), todo.getContent(), todo.getOwner());
        todos.put(saved.getId(), saved);
        return saved;
    }

    @Override
    public Todo findById(Long id) {
        return todos.get(id);
    }

    @Override
    public void deleteById(Long id) {
        todos.remove(id);
    }
}
