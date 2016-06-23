package com.ajit.singh.todoapp.database.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ajit.singh.todoapp.database.TaskDatabaseHelper;
import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.database.table.TaskTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRepository {
  private Context context;

  public TaskRepository(Context context) {
    this.context = context;
  }

  public List<Task> getTasks() {
    ArrayList<Task> tasks = new ArrayList<>();
    TaskDatabaseHelper taskDatabaseHelper = new TaskDatabaseHelper(context);
    Cursor cursor = taskDatabaseHelper.getWritableDatabase().rawQuery(TaskTable.SElECT_QUERY, null);

    if (!cursor.moveToFirst()){
      cursor.close();
      return tasks;
    }

    do {
      String title = cursor.getString(cursor.getColumnIndex(TaskTable.TITLE));
      String description = cursor.getString(cursor.getColumnIndex(TaskTable.DESCRIPTION));
      String creationDate = cursor.getString(cursor.getColumnIndex(TaskTable.CREATION_DATE));
      tasks.add(new Task(title, description, new Date(creationDate)));
    } while (cursor.moveToNext());

    cursor.close();
    return tasks;
  }

  public void addTask(Task task) {
    TaskDatabaseHelper taskDatabaseHelper = new TaskDatabaseHelper(context);

    ContentValues contentValues = new ContentValues();
    contentValues.put(TaskTable.TITLE, task.getTitle());
    contentValues.put(TaskTable.DESCRIPTION, task.getDescription());
    contentValues.put(TaskTable.CREATION_DATE, task.getCreationDate());

    SQLiteDatabase database = taskDatabaseHelper.getWritableDatabase();
    database.insert(TaskTable.TABLE_NAME, null, contentValues);
  }
}