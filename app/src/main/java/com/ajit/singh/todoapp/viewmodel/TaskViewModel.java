package com.ajit.singh.todoapp.viewmodel;

import com.ajit.singh.todoapp.model.Task;

import java.text.SimpleDateFormat;

public class TaskViewModel {

  private Task task;

  public TaskViewModel(Task task) {
    this.task = task;
  }

  public String getTitle() {
    return task.getTitle();
  }

  public String getDetail() {
    return task.getDescription();
  }

  public String getCreationDate() {
    return new SimpleDateFormat("EEE, d MMM yyyy HH:mm").format(task.getCreationDate());
  }
}
