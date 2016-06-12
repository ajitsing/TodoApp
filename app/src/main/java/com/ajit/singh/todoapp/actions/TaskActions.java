package com.ajit.singh.todoapp.actions;

import com.ajit.singh.todoapp.viewmodel.TaskViewModel;

import java.util.ArrayList;

public interface TaskActions {
  void renderTasks(ArrayList<TaskViewModel> tasks);
}
