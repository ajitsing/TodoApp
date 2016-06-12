package com.ajit.singh.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ajit.singh.todoapp.presenter.AddTaskPresenter;
import com.ajit.singh.todoapp.repository.TaskRepository;

public class AddTaskActivity extends AppCompatActivity {
  public static final int ADD_TASK_REQ = 100;
  private AddTaskPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_task);
    presenter = new AddTaskPresenter(new TaskRepository(this));
  }

  public void done(View view) {
    EditText title = (EditText) findViewById(R.id.task_title);
    EditText description = (EditText) findViewById(R.id.task_description);
    presenter.addTask(title.getText().toString(), description.getText().toString());
    finish();
  }
}
