package com.ajit.singh.todoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ajit.singh.todoapp.R;
import com.ajit.singh.todoapp.viewmodel.TaskViewModel;

import java.util.ArrayList;

public class TasksAdapter extends BaseAdapter {
  private ArrayList<TaskViewModel> tasks;

  public TasksAdapter(ArrayList<TaskViewModel> tasks) {
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
    View taskView = view;
    if (view == null) {
      LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
      taskView = inflater.inflate(R.layout.task, viewGroup, false);
    }

    TextView taskTitle = (TextView) taskView.findViewById(R.id.task_title);
    TextView taskDescription = (TextView) taskView.findViewById(R.id.task_description);
    TextView creationDate = (TextView) taskView.findViewById(R.id.creation_date);

    TaskViewModel task = tasks.get(position);
    taskTitle.setText(task.getTitle());
    taskDescription.setText(task.getDetail());
    creationDate.setText(task.getCreationDate());
    return taskView;
  }
}
