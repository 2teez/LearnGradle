package com.practice.todo.repository;

import com.practice.todo.model.ToDoItem;
import java.util.List;

public interface ToDoRepository {
    List<ToDoItem> findAll();
    ToDoItem findById(long id);
    long insert(ToDoItem toDoItem);
    void update(ToDoItem toDoItem);
    void delete(ToDoItem toDoItem);
}
