// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ItemTtRecvBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView ttRecvContent;

  @NonNull
  public final TextView ttRecvDate;

  private ItemTtRecvBinding(@NonNull LinearLayout rootView, @NonNull TextView ttRecvContent,
      @NonNull TextView ttRecvDate) {
    this.rootView = rootView;
    this.ttRecvContent = ttRecvContent;
    this.ttRecvDate = ttRecvDate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTtRecvBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTtRecvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_tt_recv, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTtRecvBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tt_recv_content;
      TextView ttRecvContent = ViewBindings.findChildViewById(rootView, id);
      if (ttRecvContent == null) {
        break missingId;
      }

      id = R.id.tt_recv_date;
      TextView ttRecvDate = ViewBindings.findChildViewById(rootView, id);
      if (ttRecvDate == null) {
        break missingId;
      }

      return new ItemTtRecvBinding((LinearLayout) rootView, ttRecvContent, ttRecvDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}