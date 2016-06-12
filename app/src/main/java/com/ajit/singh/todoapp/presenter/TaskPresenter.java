package com.ajit.singh.todoapp.presenter;

import com.ajit.singh.todoapp.actions.TaskActions;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.repository.TaskRepository;

import java.util.List;

public class TaskPresenter {
  private TaskRepository repository;
  private TaskActions actions;

  public TaskPresenter(TaskRepository repository, TaskActions actions) {
    this.repository = repository;
    this.actions = actions;
  }

  public void fetchTasks() {
    List<Task> tasks = this.repository.getTasks();
    actions.renderTasks(tasks);
  }
}
