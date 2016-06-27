package com.ajit.singh.todoapp.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ajit.singh.todoapp.R;
import com.ajit.singh.todoapp.databinding.TaskBinding;
import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public class TasksAdapter extends BaseAdapter {
  private List<Task> tasks;

  public static TasksAdapter newInstance(List<Task> tasks) {
    return new TasksAdapter(tasks);
  }

  private TasksAdapter(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public int getCount() {
    return tasks.size();
  }

  @Override
  public Object getItem(int position) {
    return tasks.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {
    TaskBinding binding;

    if (view == null) {
      LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
      binding = DataBindingUtil.inflate(inflater, R.layout.task, viewGroup, false);
    } else {
      binding = DataBindingUtil.getBinding(view);
    }

    binding.setTask(tasks.get(position));
    return binding.getRoot();
  }
}
