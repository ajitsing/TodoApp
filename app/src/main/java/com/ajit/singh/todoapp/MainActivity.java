package com.ajit.singh.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.ajit.singh.todoapp.adapter.TasksAdapter;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fetchTasks();
  }

  public void addTask(View view) {
    startActivityForResult(new Intent(this, AddTaskActivity.class), AddTaskActivity.ADD_TASK_REQ);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == AddTaskActivity.ADD_TASK_REQ) {
      fetchTasks();
    }
  }

  private void fetchTasks() {
    List<Task> tasks = new TaskRepository(this).getTasks();

    ListView listView = (ListView) findViewById(R.id.tasks_list);
    listView.setAdapter(new TasksAdapter(tasks));
  }
}
