package com.example.todo.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


public class TodoTest {
    private String title = "title";
    private String content = "content";
    private String owner = "owner";


    @Test
    @DisplayName("Todo 생성 테스트")
    public void create() {
        // given
        Todo todo = new Todo(title, content, owner);
        // when
        // then
        Assertions.assertThat(todo.getTitle()).isEqualTo(title);
        Assertions.assertThat(todo.getContent()).isEqualTo(content);
        Assertions.assertThat(todo.getOwner()).isEqualTo(owner);
        Assertions.assertThat(todo.getCreateAt()).isNotNull();
        Assertions.assertThat(todo.getUpdateAt()).isNotNull();
        Assertions.assertThat(todo.isComplete()).isEqualTo(false);
    }

    @Test
    @DisplayName("Todo 수정 테스트")
    public void modify() {
        // given
        Todo todo = new Todo(title, content, owner);
        Todo modifiedTodo = new Todo("modified title", "modified content", "modified owner");
        LocalDateTime todoCreateTime = todo.getCreateAt();
        // when
        todo.modify(modifiedTodo);
        // then
        Assertions.assertThat(todo.getTitle()).isEqualTo(modifiedTodo.getTitle());
        Assertions.assertThat(todo.getContent()).isEqualTo(modifiedTodo.getContent());
        Assertions.assertThat(todo.getOwner()).isEqualTo(modifiedTodo.getOwner());
        Assertions.assertThat(todo.getCreateAt()).isEqualTo(todoCreateTime);
    }
}
