package com.ajit.singh.todoapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ajit.singh.todoapp.model.Task;
import com.ajit.singh.todoapp.table.TaskTable;

import java.util.List;

import static java.util.Arrays.asList;

public class TaskDatabaseHelper extends SQLiteOpenHelper {
  public TaskDatabaseHelper(Context context) {
    super(context, "todo", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(TaskTable.CREATE_QUERY);
    seedTasks(sqLiteDatabase);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int prevVersion, int newVersion) {
    sqLiteDatabase.execSQL(TaskTable.DROP_QUERY);
    sqLiteDatabase.execSQL(TaskTable.CREATE_QUERY);
  }

  private void seedTasks(SQLiteDatabase sqLiteDatabase) {
    List<Task> tasks = asList(
        new Task("New Task", "Add a new task!"),
        new Task("New Task", "Add a new task!")
    );

    for (Task task : tasks) {
      ContentValues values = new ContentValues();
      values.put(TaskTable.TITLE, task.getTitle());
      values.put(TaskTable.DESCRIPTION, task.getDescription());

      sqLiteDatabase.insert(TaskTable.TABLE_NAME, null, values);
    }
  }
}
