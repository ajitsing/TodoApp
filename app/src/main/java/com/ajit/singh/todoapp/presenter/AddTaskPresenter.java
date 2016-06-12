package com.ajit.singh.todoapp.presenter;

import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.repository.TaskRepository;

import java.util.Date;

public class AddTaskPresenter {
  private TaskRepository repository;

  public AddTaskPresenter(TaskRepository repository) {
    this.repository = repository;
  }

  public void addTask(String title, String description) {
    repository.addTask(new Task(title, description, new Date()));
  }
}
