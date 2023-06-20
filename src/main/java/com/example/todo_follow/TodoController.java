package com.example.todo_follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Long create(@RequestBody Todo todo) {
        todo = todoRepository.save(todo);
        return todo.getId();
    }

    @GetMapping
    public List<Todo> get_todos() {
        return todoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String del_todos(@PathVariable("id") Long id) {
        // TODO: 예외처리하는 법 알아보기
        todoRepository.deleteById(id);
        return "삭제가 완료되었습니다.";
    }

    @PatchMapping("/{id}")
    public Todo complete_todo(@PathVariable("id") Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            Todo find_todo = todo.get();
            find_todo.setIs_complete_todo(!find_todo.getIs_complete_todo());
            return todoRepository.save(find_todo);
        }
        return null;
    }

    @PutMapping("/{id}")
    public Todo modify_todo(@PathVariable("id") Long id, @RequestBody Todo todoBody) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (!todo.isPresent()) {
            return null;
        }
        Todo find_todo = todo.get();
        find_todo.setName(todoBody.getName());
        find_todo.setIs_complete_todo(todoBody.getIs_complete_todo());
        return todoRepository.save(find_todo);
    }
}
