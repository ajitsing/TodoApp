package com.ajit.singh.todoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ajit.singh.todoapp.R;
import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public class TasksAdapter extends BaseAdapter {
  private List<Task> tasks;

  public TasksAdapter(List<Task> tasks) {
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
    LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
    View taskView = inflater.inflate(R.layout.task, viewGroup, false);
    TextView taskTitle = (TextView) taskView.findViewById(R.id.task_title);
    TextView taskDescription = (TextView) taskView.findViewById(R.id.task_description);
    TextView creationDate = (TextView) taskView.findViewById(R.id.creation_date);

    Task task = tasks.get(position);
    taskTitle.setText(task.getTitle());
    taskDescription.setText(task.getDescription());
    creationDate.setText(task.getCreationDate().toString());
    return taskView;
  }
}
