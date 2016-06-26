package com.ajit.singh.todoapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ajit.singh.todoapp.BR;
import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public class TaskListViewModel extends BaseObservable {

  private List<Task> tasks;

  public void populate(List<Task> tasks) {
    this.tasks = tasks;
    notifyPropertyChanged(BR.tasks);
  }

  @Bindable
  public List<Task> getTasks() {
    return tasks;
  }
}
