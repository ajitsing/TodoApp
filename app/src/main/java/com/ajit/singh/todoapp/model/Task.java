package com.ajit.singh.todoapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
  private final String title;
  private final String description;
  private final Date creationDate;

  public Task(String title, String description, Date creationDate) {
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
  }

  public String getCreationDate() {
    return new SimpleDateFormat("EEE, d MMM yyyy HH:mm").format(creationDate);
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
