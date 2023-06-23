package com.example.todo.todo;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Todo {
    private String title;
    private String content;
    private String owner;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Todo(String title, String content, String owner) {
        this.title = title;
        this.content = content;
        this.owner = owner;
        LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updateAt = now;
    }
}
