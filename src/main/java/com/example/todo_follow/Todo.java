package com.example.todo_follow;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity @Getter @DynamicInsert
public class Todo {
    @Id @GeneratedValue
    private Long id;

    @Setter
    private String name;
    @ColumnDefault("false") @Setter
    private Boolean is_complete_todo;
    @CreationTimestamp
    private LocalDateTime createdTimeAt;
    @UpdateTimestamp
    private LocalDateTime updateTimeAt;

    public void change_complete() {
        this.is_complete_todo = !this.is_complete_todo;
    }
}
