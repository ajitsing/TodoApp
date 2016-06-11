package com.ajit.singh.todoapp.actions;

import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public interface TaskActions {
  void renderTasks(List<Task> tasks);
}
