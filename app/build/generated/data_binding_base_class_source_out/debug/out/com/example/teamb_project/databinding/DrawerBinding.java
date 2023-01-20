// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DrawerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView acCalendarTv;

  @NonNull
  public final TextView acInfoTv;

  @NonNull
  public final LinearLayout drawerView;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final TextView logoutTv;

  @NonNull
  public final TextView myInfoTv;

  private DrawerBinding(@NonNull LinearLayout rootView, @NonNull TextView acCalendarTv,
      @NonNull TextView acInfoTv, @NonNull LinearLayout drawerView, @NonNull ImageView ivProfile,
      @NonNull TextView logoutTv, @NonNull TextView myInfoTv) {
    this.rootView = rootView;
    this.acCalendarTv = acCalendarTv;
    this.acInfoTv = acInfoTv;
    this.drawerView = drawerView;
    this.ivProfile = ivProfile;
    this.logoutTv = logoutTv;
    this.myInfoTv = myInfoTv;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DrawerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DrawerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.drawer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DrawerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.acCalendar_tv;
      TextView acCalendarTv = ViewBindings.findChildViewById(rootView, id);
      if (acCalendarTv == null) {
        break missingId;
      }

      id = R.id.acInfo_tv;
      TextView acInfoTv = ViewBindings.findChildViewById(rootView, id);
      if (acInfoTv == null) {
        break missingId;
      }

      LinearLayout drawerView = (LinearLayout) rootView;

      id = R.id.iv_profile;
      ImageView ivProfile = ViewBindings.findChildViewById(rootView, id);
      if (ivProfile == null) {
        break missingId;
      }

      id = R.id.logout_tv;
      TextView logoutTv = ViewBindings.findChildViewById(rootView, id);
      if (logoutTv == null) {
        break missingId;
      }

      id = R.id.myInfo_tv;
      TextView myInfoTv = ViewBindings.findChildViewById(rootView, id);
      if (myInfoTv == null) {
        break missingId;
      }

      return new DrawerBinding((LinearLayout) rootView, acCalendarTv, acInfoTv, drawerView,
          ivProfile, logoutTv, myInfoTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}