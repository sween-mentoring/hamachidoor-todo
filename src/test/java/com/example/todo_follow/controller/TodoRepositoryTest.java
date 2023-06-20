package com.example.todo_follow.controller;

import com.example.todo_follow.Todo;
import com.example.todo_follow.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class TodoControllerTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public Todo create() {
        Todo todo = new Todo();
        todo.setName("스프링 시작하기");
        todoRepository.save(todo);

        Todo result = todoRepository.findById(todo.getId()).get();
        Assertions.assertThat(todo).isEqualTo(result);
        return todo;
    }



    @Test
    public void del_todos() {
        // TODO: 질문 - 이런 식으로 테스트 여러개를 엮어서 짜게 되면, delete와 create 둘 다 한번에 테스트를 진행하게 되는데 이렇게 짜도 되는가?
        // TODO: 질문 - 이렇게 짜면 create가 변경되면 delete도 변경되기 때문에 이렇게 짜면 안되는가?
        Todo todo = create();
        todoRepository.deleteById(todo.getId());

        Optional<Todo> result = todoRepository.findById(todo.getId());
        Assertions.assertThat(result).isEqualTo(Optional.empty());
    }
}
