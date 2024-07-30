package com.a11yfocus.views.view;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;

public class A11yFocusView extends ReactViewGroup {

  public A11yFocusView(Context context) {
    super(context);
  }


  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {
    // No-op since UIManagerModule handles actually laying out children.
  }
}
