package com.a11yfocus.views.view;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.Nullable;

import com.a11yfocus.A11yFocusViewManagerSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

@ReactModule(name = A11yFocusViewManager.NAME)
public class A11yFocusViewManager extends A11yFocusViewManagerSpec {

  public static final String NAME = "A11yFocusView";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public ReactViewGroup createViewInstance(ThemedReactContext context) {
    return super.createViewInstance(context);
  }

  @Override
  public void focus(ReactViewGroup view) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      if(view.isFocusable()) {
        view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
      } else {
        View child = view.getChildAt(0);
        if(child != null && child.isFocusable()) {
          child.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        }
      }
    } else {
      view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
    }
  }

  @Override
  public void receiveCommand(ReactViewGroup view, String commandId, @Nullable ReadableArray args) {
    switch(commandId) {
      case "focus": {
        this.focus(view);
      }
    }
  }
}
