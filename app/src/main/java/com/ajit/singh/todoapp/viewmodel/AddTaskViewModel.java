package com.ajit.singh.todoapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ajit.singh.todoapp.BR;

public class AddTaskViewModel extends BaseObservable {
  private String title;
  private String description;

  @Bindable
  public String getTitle() {
    return title;
  }

  @Bindable
  public String getDescription() {
    return description;
  }

  public void setTitle(String title) {
    this.title = title;
    notifyPropertyChanged(BR.title);
  }

  public void setDescription(String description) {
    this.description = description;
    notifyPropertyChanged(BR.title);
  }
}
