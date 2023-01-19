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

public final class ItemVideoBoardBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivThumbnail;

  @NonNull
  public final LinearLayout linVideo;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvTitle;

  private ItemVideoBoardBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivThumbnail,
      @NonNull LinearLayout linVideo, @NonNull TextView tvDate, @NonNull TextView tvName,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.ivThumbnail = ivThumbnail;
    this.linVideo = linVideo;
    this.tvDate = tvDate;
    this.tvName = tvName;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemVideoBoardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemVideoBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_video_board, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemVideoBoardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_thumbnail;
      ImageView ivThumbnail = ViewBindings.findChildViewById(rootView, id);
      if (ivThumbnail == null) {
        break missingId;
      }

      LinearLayout linVideo = (LinearLayout) rootView;

      id = R.id.tv_date;
      TextView tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      id = R.id.tv_name;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ItemVideoBoardBinding((LinearLayout) rootView, ivThumbnail, linVideo, tvDate,
          tvName, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}