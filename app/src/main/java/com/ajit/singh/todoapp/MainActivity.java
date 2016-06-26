package com.ajit.singh.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.ajit.singh.todoapp.actions.MainActions;
import com.ajit.singh.todoapp.adapter.TasksAdapter;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.presenter.MainPresenter;

import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements MainActions {

  private MainPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    presenter = new MainPresenter(new TaskRepository(this), this);
    presenter.onCreate();

    FloatingActionButton addTaskButton = (FloatingActionButton) findViewById(R.id.add_task);

    addTaskButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onAddTask();
      }
    });
  }

  @Override
  public void renderTasks(List<Task> tasks) {
    ListView listView = (ListView) findViewById(R.id.tasks_list);
    listView.setAdapter(new TasksAdapter(tasks));
  }

  @Override
  public void navigateToAddTask() {
    startActivityForResult(new Intent(MainActivity.this, AddTaskActivity.class), AddTaskActivity.ADD_TASK_REQ);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == AddTaskActivity.ADD_TASK_REQ) {
      presenter.onCreate();
    }
  }
}
