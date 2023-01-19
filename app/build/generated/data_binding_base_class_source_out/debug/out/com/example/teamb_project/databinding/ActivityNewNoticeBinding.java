// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityNewNoticeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialCardView cardBack;

  @NonNull
  public final MaterialCardView cardInsert;

  @NonNull
  public final ImageView ivBack;

  private ActivityNewNoticeBinding(@NonNull LinearLayout rootView,
      @NonNull MaterialCardView cardBack, @NonNull MaterialCardView cardInsert,
      @NonNull ImageView ivBack) {
    this.rootView = rootView;
    this.cardBack = cardBack;
    this.cardInsert = cardInsert;
    this.ivBack = ivBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewNoticeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewNoticeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_notice, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewNoticeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_back;
      MaterialCardView cardBack = ViewBindings.findChildViewById(rootView, id);
      if (cardBack == null) {
        break missingId;
      }

      id = R.id.card_insert;
      MaterialCardView cardInsert = ViewBindings.findChildViewById(rootView, id);
      if (cardInsert == null) {
        break missingId;
      }

      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      return new ActivityNewNoticeBinding((LinearLayout) rootView, cardBack, cardInsert, ivBack);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
