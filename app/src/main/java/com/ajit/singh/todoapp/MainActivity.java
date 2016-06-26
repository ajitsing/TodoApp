package com.ajit.singh.todoapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ajit.singh.todoapp.actions.MainActions;
import com.ajit.singh.todoapp.database.repository.TaskRepository;
import com.ajit.singh.todoapp.databinding.ActivityMainBinding;
import com.ajit.singh.todoapp.presenter.MainPresenter;
import com.ajit.singh.todoapp.viewmodel.TaskListViewModel;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements MainActions {

  private MainPresenter presenter;
  private TaskListViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = new TaskListViewModel();
    binding.setViewModel(viewModel);

    presenter = new MainPresenter(new TaskRepository(this), this);
    presenter.onCreate(viewModel);

    binding.setPresenter(presenter);
  }

  @Override
  public void navigateToAddTask() {
    startActivityForResult(new Intent(MainActivity.this, AddTaskActivity.class), AddTaskActivity.ADD_TASK_REQ);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == AddTaskActivity.ADD_TASK_REQ) {
      presenter.onCreate(viewModel);
    }
  }
}
