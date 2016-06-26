package com.ajit.singh.todoapp.presenter;

import com.ajit.singh.todoapp.actions.MainActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.viewmodel.TaskListViewModel;

import java.util.List;

public class MainPresenter {
  private TaskRepository repository;
  private MainActions actions;

  public MainPresenter(TaskRepository repository, MainActions actions) {
    this.repository = repository;
    this.actions = actions;
  }

  public void onCreate(TaskListViewModel viewModel) {
    List<Task> tasks = repository.getTasks();
    viewModel.populate(tasks);
  }

  public void onAddTask() {
    actions.navigateToAddTask();
  }
}
