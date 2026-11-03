package com.practice.todo.repository;

import com.practice.todo.model.ToDoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryToDoRepository implements ToDoRepository {

    private long currentId = 0;
    private HashMap<Long, ToDoItem> toDos = new HashMap<>();

    @Override
    public List<ToDoItem> findAll() {
        var toDoItems = new ArrayList<ToDoItem>(toDos.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(long id) {
        return toDos.get(id);
    }

    @Override
    public long insert(ToDoItem toDoItem) {
        var newId = currentId++;
        toDoItem.setId(newId);
        toDos.putIfAbsent(newId, toDoItem);
        return newId;
    }

    @Override
    public void update(ToDoItem toDoItem) {
        toDos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        toDos.remove(toDoItem.getId());
    }
}
