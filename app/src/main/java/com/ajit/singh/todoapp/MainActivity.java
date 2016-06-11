package com.ajit.singh.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.ajit.singh.todoapp.actions.TaskActions;
import com.ajit.singh.todoapp.adapter.TasksAdapter;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.presenter.TaskPresenter;
import com.ajit.singh.todoapp.repository.TaskRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskActions {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TaskPresenter presenter = new TaskPresenter(new TaskRepository(this), this);
    presenter.init();
  }

  public void addTask(View view) {
    startActivity(new Intent(this, AddTaskActivity.class));
  }

  @Override
  public void renderTasks(List<Task> tasks) {
    ListView listView = (ListView) findViewById(R.id.tasks_list);
    listView.setAdapter(new TasksAdapter(tasks));
  }
}
