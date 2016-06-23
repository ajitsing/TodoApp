package com.ajit.singh.todoapp.database.table;

import android.provider.BaseColumns;

public class TaskTable implements BaseColumns {
  public static final String TITLE = "title";
  public static final String DESCRIPTION = "description";
  public static final String CREATION_DATE = "creation_date";
  public static final String TABLE_NAME = "tasks";

  public static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
      _ID + " INTEGER, " +
      TITLE + " TEXT, " +
      DESCRIPTION + " TEXT, " +
      CREATION_DATE + " TEXT)";

  public static final String DROP_QUERY = "drop table " + TABLE_NAME;
  public static final String SElECT_QUERY = "select * from " + TABLE_NAME;
}
