package com.ajit.singh.todoapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ajit.singh.todoapp.actions.AddTaskActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.databinding.ActivityAddTaskBinding;
import com.ajit.singh.todoapp.presenter.AddTaskPresenter;
import com.ajit.singh.todoapp.viewmodel.AddTaskViewModel;

@SuppressWarnings("ALL")
public class AddTaskActivity extends AppCompatActivity implements AddTaskActions {
  public static final int ADD_TASK_REQ = 100;
  private AddTaskPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityAddTaskBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task);
    final AddTaskViewModel viewModel = new AddTaskViewModel();
    binding.setViewModel(viewModel);

    AddTaskPresenter presenter = new AddTaskPresenter(new TaskRepository(this), this);
    binding.setPresenter(presenter);
  }

  @Override
  public void navigateBack() {
    finish();
  }
}
