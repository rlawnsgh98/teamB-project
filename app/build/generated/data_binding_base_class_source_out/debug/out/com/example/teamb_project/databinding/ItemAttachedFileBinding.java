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

public final class ItemAttachedFileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout linFile;

  @NonNull
  public final TextView tvFileName;

  private ItemAttachedFileBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout linFile,
      @NonNull TextView tvFileName) {
    this.rootView = rootView;
    this.linFile = linFile;
    this.tvFileName = tvFileName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemAttachedFileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemAttachedFileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_attached_file, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemAttachedFileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lin_file;
      LinearLayout linFile = ViewBindings.findChildViewById(rootView, id);
      if (linFile == null) {
        break missingId;
      }

      id = R.id.tv_file_name;
      TextView tvFileName = ViewBindings.findChildViewById(rootView, id);
      if (tvFileName == null) {
        break missingId;
      }

      return new ItemAttachedFileBinding((LinearLayout) rootView, linFile, tvFileName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
