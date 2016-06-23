package com.ajit.singh.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.model.Task;

import java.util.Date;

@SuppressWarnings("ALL")
public class AddTaskActivity extends AppCompatActivity {
  public static final int ADD_TASK_REQ = 100;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_task);

    Button doneButton = (Button) findViewById(R.id.add_task);

    doneButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        addNewTask();
      }
    });
  }

  private void addNewTask() {
    EditText titleEditText = (EditText) findViewById(R.id.task_title);
    EditText descriptionEditText = (EditText) findViewById(R.id.task_description);

    String title = titleEditText.getText().toString();
    String description = descriptionEditText.getText().toString();

    TaskRepository repository = new TaskRepository(this);
    repository.addTask(new Task(title, description, new Date()));
    finish();
  }
}
