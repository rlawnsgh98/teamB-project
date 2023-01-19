// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class ItemReplyBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText edtContent;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final LinearLayout linItemReply;

  @NonNull
  public final LinearLayout linModifyDelete;

  @NonNull
  public final TextView tvContent;

  @NonNull
  public final TextView tvDelete;

  @NonNull
  public final TextView tvModify;

  @NonNull
  public final TextView tvWritedate;

  @NonNull
  public final TextView tvWriter;

  private ItemReplyBinding(@NonNull LinearLayout rootView, @NonNull EditText edtContent,
      @NonNull ImageView ivSend, @NonNull LinearLayout linItemReply,
      @NonNull LinearLayout linModifyDelete, @NonNull TextView tvContent,
      @NonNull TextView tvDelete, @NonNull TextView tvModify, @NonNull TextView tvWritedate,
      @NonNull TextView tvWriter) {
    this.rootView = rootView;
    this.edtContent = edtContent;
    this.ivSend = ivSend;
    this.linItemReply = linItemReply;
    this.linModifyDelete = linModifyDelete;
    this.tvContent = tvContent;
    this.tvDelete = tvDelete;
    this.tvModify = tvModify;
    this.tvWritedate = tvWritedate;
    this.tvWriter = tvWriter;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_reply, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemReplyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edt_content;
      EditText edtContent = ViewBindings.findChildViewById(rootView, id);
      if (edtContent == null) {
        break missingId;
      }

      id = R.id.iv_send;
      ImageView ivSend = ViewBindings.findChildViewById(rootView, id);
      if (ivSend == null) {
        break missingId;
      }

      id = R.id.lin_item_reply;
      LinearLayout linItemReply = ViewBindings.findChildViewById(rootView, id);
      if (linItemReply == null) {
        break missingId;
      }

      id = R.id.lin_modify_delete;
      LinearLayout linModifyDelete = ViewBindings.findChildViewById(rootView, id);
      if (linModifyDelete == null) {
        break missingId;
      }

      id = R.id.tv_content;
      TextView tvContent = ViewBindings.findChildViewById(rootView, id);
      if (tvContent == null) {
        break missingId;
      }

      id = R.id.tv_delete;
      TextView tvDelete = ViewBindings.findChildViewById(rootView, id);
      if (tvDelete == null) {
        break missingId;
      }

      id = R.id.tv_modify;
      TextView tvModify = ViewBindings.findChildViewById(rootView, id);
      if (tvModify == null) {
        break missingId;
      }

      id = R.id.tv_writedate;
      TextView tvWritedate = ViewBindings.findChildViewById(rootView, id);
      if (tvWritedate == null) {
        break missingId;
      }

      id = R.id.tv_writer;
      TextView tvWriter = ViewBindings.findChildViewById(rootView, id);
      if (tvWriter == null) {
        break missingId;
      }

      return new ItemReplyBinding((LinearLayout) rootView, edtContent, ivSend, linItemReply,
          linModifyDelete, tvContent, tvDelete, tvModify, tvWritedate, tvWriter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
