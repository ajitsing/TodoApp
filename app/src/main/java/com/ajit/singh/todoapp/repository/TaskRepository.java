package com.ajit.singh.todoapp.repository;

import android.content.Context;
import android.database.Cursor;

import com.ajit.singh.todoapp.database.TaskDatabaseHelper;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.table.TaskTable;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
  private Context context;

  public TaskRepository(Context context) {
    this.context = context;
  }

  public List<Task> getTasks() {
    ArrayList<Task> tasks = new ArrayList<>();
    TaskDatabaseHelper taskDatabaseHelper = new TaskDatabaseHelper(context);
    Cursor cursor = taskDatabaseHelper.getReadableDatabase().rawQuery(TaskTable.SElECT_QUERY, new String[]{});
    cursor.moveToFirst();
    do {
      String title = cursor.getString(cursor.getColumnIndex(TaskTable.TITLE));
      String description = cursor.getString(cursor.getColumnIndex(TaskTable.DESCRIPTION));
      tasks.add(new Task(title, description));
    } while (cursor.moveToNext());

    return tasks;
  }
}