package com.example.todo.todo;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Todo {
    private Long id;
    private String title;
    private String content;
    private String owner;
    private boolean isComplete;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Todo(Long id, String title, String content, String owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.isComplete = false;
        LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updateAt = now;
    }

    public Todo(String title, String content, String owner) {
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.isComplete = false;
        LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updateAt = now;
    }

    public void modify(Todo modifiedTodo) {
        this.title = modifiedTodo.getTitle();
        this.content = modifiedTodo.getContent();
        this.owner = modifiedTodo.getOwner();
        this.updateAt = LocalDateTime.now();
    }
}
