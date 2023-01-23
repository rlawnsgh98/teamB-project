// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTeacherhomeBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final MaterialCardView cvAttendance;

  @NonNull
  public final MaterialCardView cvBoard;

  @NonNull
  public final MaterialCardView cvConsult;

  @NonNull
  public final MaterialCardView cvMylecture;

  @NonNull
  public final MaterialCardView cvNotice;

  @NonNull
  public final MaterialCardView cvSchedule;

  @NonNull
  public final DrawerLayout drawerLayout;

  private ActivityTeacherhomeBinding(@NonNull DrawerLayout rootView,
      @NonNull MaterialCardView cvAttendance, @NonNull MaterialCardView cvBoard,
      @NonNull MaterialCardView cvConsult, @NonNull MaterialCardView cvMylecture,
      @NonNull MaterialCardView cvNotice, @NonNull MaterialCardView cvSchedule,
      @NonNull DrawerLayout drawerLayout) {
    this.rootView = rootView;
    this.cvAttendance = cvAttendance;
    this.cvBoard = cvBoard;
    this.cvConsult = cvConsult;
    this.cvMylecture = cvMylecture;
    this.cvNotice = cvNotice;
    this.cvSchedule = cvSchedule;
    this.drawerLayout = drawerLayout;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTeacherhomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTeacherhomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_teacherhome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTeacherhomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cv_attendance;
      MaterialCardView cvAttendance = ViewBindings.findChildViewById(rootView, id);
      if (cvAttendance == null) {
        break missingId;
      }

      id = R.id.cv_board;
      MaterialCardView cvBoard = ViewBindings.findChildViewById(rootView, id);
      if (cvBoard == null) {
        break missingId;
      }

      id = R.id.cv_consult;
      MaterialCardView cvConsult = ViewBindings.findChildViewById(rootView, id);
      if (cvConsult == null) {
        break missingId;
      }

      id = R.id.cv_mylecture;
      MaterialCardView cvMylecture = ViewBindings.findChildViewById(rootView, id);
      if (cvMylecture == null) {
        break missingId;
      }

      id = R.id.cv_notice;
      MaterialCardView cvNotice = ViewBindings.findChildViewById(rootView, id);
      if (cvNotice == null) {
        break missingId;
      }

      id = R.id.cv_schedule;
      MaterialCardView cvSchedule = ViewBindings.findChildViewById(rootView, id);
      if (cvSchedule == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      return new ActivityTeacherhomeBinding((DrawerLayout) rootView, cvAttendance, cvBoard,
          cvConsult, cvMylecture, cvNotice, cvSchedule, drawerLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}