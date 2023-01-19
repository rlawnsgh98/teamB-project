// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCounselBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivPlus;

  @NonNull
  public final RecyclerView recvCounsel;

  private ActivityCounselBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivBack,
      @NonNull ImageView ivPlus, @NonNull RecyclerView recvCounsel) {
    this.rootView = rootView;
    this.ivBack = ivBack;
    this.ivPlus = ivPlus;
    this.recvCounsel = recvCounsel;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCounselBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCounselBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_counsel, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCounselBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.iv_plus;
      ImageView ivPlus = ViewBindings.findChildViewById(rootView, id);
      if (ivPlus == null) {
        break missingId;
      }

      id = R.id.recv_counsel;
      RecyclerView recvCounsel = ViewBindings.findChildViewById(rootView, id);
      if (recvCounsel == null) {
        break missingId;
      }

      return new ActivityCounselBinding((LinearLayout) rootView, ivBack, ivPlus, recvCounsel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}