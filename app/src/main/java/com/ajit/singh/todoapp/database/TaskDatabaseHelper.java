package com.ajit.singh.todoapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ajit.singh.todoapp.table.TaskTable;

public class TaskDatabaseHelper extends SQLiteOpenHelper {
  public TaskDatabaseHelper(Context context) {
    super(context, "todo", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(TaskTable.CREATE_QUERY);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int prevVersion, int newVersion) {
    sqLiteDatabase.execSQL(TaskTable.DROP_QUERY);
    sqLiteDatabase.execSQL(TaskTable.CREATE_QUERY);
  }
}
