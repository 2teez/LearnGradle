package com.practice.todo.model;

import java.util.Objects;

/**
 */
public class ToDoItem implements Comparable<ToDoItem> {

    private long id;
    private String name;
    private boolean completed;

    //
    public ToDoItem(long id, String name, boolean completed) {
        setId(id);
        setName(name);
        setCompletedTask(completed);
    }

    //
    public long getId() {
        return this.id;
    }

    //
    public String getName() {
        return this.name;
    }

    //
    public boolean getCompletedTask() {
        return this.completed;
    }

    //
    @Override
    public int compareTo(ToDoItem other) {
        return this.id == other.id &&
            this.name.equals(other.name) &&
            this.completed == other.completed
            ? 0
            : 1;
    }

    //
    public void setId(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Can't use negative number.");
        }
        this.id = id;
    }

    //
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name can't be null");
    }

    //
    public void setCompletedTask(boolean completed) {
        this.completed = completed;
    }

    //
    @Override
    public String toString() {
        return String.format(
            "Task{%ld: %s, %s}",
            this.id,
            this.name,
            this.completed
        );
    }
}
