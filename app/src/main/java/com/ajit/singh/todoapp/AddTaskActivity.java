package com.ajit.singh.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ajit.singh.todoapp.actions.AddTaskActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.presenter.AddTaskPresenter;

@SuppressWarnings("ALL")
public class AddTaskActivity extends AppCompatActivity implements AddTaskActions {
  public static final int ADD_TASK_REQ = 100;
  private AddTaskPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_task);

    presenter = new AddTaskPresenter(new TaskRepository(this), this);

    Button doneButton = (Button) findViewById(R.id.add_task);

    doneButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        addNewTask();
      }
    });
  }

  @Override
  public void navigateBack() {
    finish();
  }

  private void addNewTask() {
    EditText titleEditText = (EditText) findViewById(R.id.task_title);
    EditText descriptionEditText = (EditText) findViewById(R.id.task_description);

    String title = titleEditText.getText().toString();
    String description = descriptionEditText.getText().toString();

    presenter.onAddTask(title, description);
  }
}
