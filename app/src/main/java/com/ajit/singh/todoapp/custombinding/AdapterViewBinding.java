package com.ajit.singh.todoapp.custombinding;

import android.databinding.BindingAdapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

public class AdapterViewBinding {
  @BindingAdapter("setAdapter")
  public static void setAdapter(AdapterView view, BaseAdapter adapter) {
    view.setAdapter(adapter);
  }
}
