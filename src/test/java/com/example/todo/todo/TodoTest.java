package com.example.todo.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TodoTest {
    private String title = "title";
    private String content = "content";
    private String owner = "owner";


    @Test
    @DisplayName("Todo 생성 테스트")
    public void create() {
        Todo todo = new Todo(title, content, owner);
        Assertions.assertThat(todo.getTitle()).isEqualTo(title);
        Assertions.assertThat(todo.getContent()).isEqualTo(content);
        Assertions.assertThat(todo.getOwner()).isEqualTo(owner);
        Assertions.assertThat(todo.getCreateAt()).isNotNull();
        Assertions.assertThat(todo.getUpdateAt()).isNotNull();
    }
}
