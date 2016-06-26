package com.ajit.singh.todoapp.presenter;

import com.ajit.singh.todoapp.actions.AddTaskActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;

import java.util.Date;

public class AddTaskPresenter {
  private TaskRepository repository;
  private AddTaskActions actions;

  public AddTaskPresenter(TaskRepository repository, AddTaskActions actions) {
    this.repository = repository;
    this.actions = actions;
  }

  public void onAddTask(String title, String description) {
    repository.addTask(new Task(title, description, new Date()));
    actions.navigateBack();
  }
}
