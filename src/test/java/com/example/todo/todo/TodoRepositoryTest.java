package com.example.todo.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodoRepositoryTest {
    private TodoRepository todoRepository;

    private String title = "title";
    private String content = "content";
    private String owner = "owner";

    @BeforeEach
    public void initRepository() {
        todoRepository = new TodoMemoryRepository();
    }

    @Test
    @DisplayName("Todo 삽입 테스트")
    public void save() {
        // given
        Todo todo = new Todo(title, content, owner);
        // when
        Todo savedTodo = todoRepository.save(todo);
        Todo savedTwiceTodo = todoRepository.save(todo);
        // then
        Assertions.assertThat(savedTodo.getId()).isNotNull();
        Assertions.assertThat(savedTodo.getId() + 1).isEqualTo(savedTwiceTodo.getId());
    }
}
