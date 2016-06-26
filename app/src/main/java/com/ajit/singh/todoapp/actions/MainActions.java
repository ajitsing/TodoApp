package com.ajit.singh.todoapp.actions;

import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public interface MainActions {
  void renderTasks(List<Task> tasks);
  void navigateToAddTask();
}
