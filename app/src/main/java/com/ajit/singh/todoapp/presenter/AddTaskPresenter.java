package com.ajit.singh.todoapp.presenter;

import com.ajit.singh.todoapp.actions.AddTaskActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.viewmodel.AddTaskViewModel;

import java.util.Date;

public class AddTaskPresenter {
  private TaskRepository repository;
  private AddTaskActions actions;

  public AddTaskPresenter(TaskRepository repository, AddTaskActions actions) {
    this.repository = repository;
    this.actions = actions;
  }

  public void onAddTask(AddTaskViewModel viewModel) {
    repository.addTask(new Task(viewModel.getTitle(), viewModel.getDescription(), new Date()));
    actions.navigateBack();
  }
}
