// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCounselDetailBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final MaterialCardView cardAnswer;

  @NonNull
  public final MaterialCardView cardAnswerBtn;

  @NonNull
  public final EditText edtAnswer;

  @NonNull
  public final EditText edtContent;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivMore;

  @NonNull
  public final ImageView ivMoreAnswer;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final ImageView ivSendContent;

  @NonNull
  public final LinearLayout linAnswer;

  @NonNull
  public final LinearLayout linMore;

  @NonNull
  public final LinearLayout linMoreAnswer;

  @NonNull
  public final RelativeLayout relAnswer;

  @NonNull
  public final RelativeLayout relMore;

  @NonNull
  public final RelativeLayout relMoreAnswer;

  @NonNull
  public final LinearLayout topbar;

  @NonNull
  public final TextView tvAnswer;

  @NonNull
  public final TextView tvAnswerDate;

  @NonNull
  public final TextView tvContent;

  @NonNull
  public final TextView tvDelete;

  @NonNull
  public final TextView tvDeleteAnswer;

  @NonNull
  public final TextView tvModify;

  @NonNull
  public final TextView tvModifyAnswer;

  @NonNull
  public final TextView tvReceiver;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvWriteDate;

  @NonNull
  public final TextView tvWriter;

  private ActivityCounselDetailBinding(@NonNull RelativeLayout rootView,
      @NonNull MaterialCardView cardAnswer, @NonNull MaterialCardView cardAnswerBtn,
      @NonNull EditText edtAnswer, @NonNull EditText edtContent, @NonNull ImageView ivBack,
      @NonNull ImageView ivMore, @NonNull ImageView ivMoreAnswer, @NonNull ImageView ivSend,
      @NonNull ImageView ivSendContent, @NonNull LinearLayout linAnswer,
      @NonNull LinearLayout linMore, @NonNull LinearLayout linMoreAnswer,
      @NonNull RelativeLayout relAnswer, @NonNull RelativeLayout relMore,
      @NonNull RelativeLayout relMoreAnswer, @NonNull LinearLayout topbar,
      @NonNull TextView tvAnswer, @NonNull TextView tvAnswerDate, @NonNull TextView tvContent,
      @NonNull TextView tvDelete, @NonNull TextView tvDeleteAnswer, @NonNull TextView tvModify,
      @NonNull TextView tvModifyAnswer, @NonNull TextView tvReceiver, @NonNull TextView tvTitle,
      @NonNull TextView tvWriteDate, @NonNull TextView tvWriter) {
    this.rootView = rootView;
    this.cardAnswer = cardAnswer;
    this.cardAnswerBtn = cardAnswerBtn;
    this.edtAnswer = edtAnswer;
    this.edtContent = edtContent;
    this.ivBack = ivBack;
    this.ivMore = ivMore;
    this.ivMoreAnswer = ivMoreAnswer;
    this.ivSend = ivSend;
    this.ivSendContent = ivSendContent;
    this.linAnswer = linAnswer;
    this.linMore = linMore;
    this.linMoreAnswer = linMoreAnswer;
    this.relAnswer = relAnswer;
    this.relMore = relMore;
    this.relMoreAnswer = relMoreAnswer;
    this.topbar = topbar;
    this.tvAnswer = tvAnswer;
    this.tvAnswerDate = tvAnswerDate;
    this.tvContent = tvContent;
    this.tvDelete = tvDelete;
    this.tvDeleteAnswer = tvDeleteAnswer;
    this.tvModify = tvModify;
    this.tvModifyAnswer = tvModifyAnswer;
    this.tvReceiver = tvReceiver;
    this.tvTitle = tvTitle;
    this.tvWriteDate = tvWriteDate;
    this.tvWriter = tvWriter;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCounselDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCounselDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_counsel_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCounselDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_answer;
      MaterialCardView cardAnswer = ViewBindings.findChildViewById(rootView, id);
      if (cardAnswer == null) {
        break missingId;
      }

      id = R.id.card_answer_btn;
      MaterialCardView cardAnswerBtn = ViewBindings.findChildViewById(rootView, id);
      if (cardAnswerBtn == null) {
        break missingId;
      }

      id = R.id.edt_answer;
      EditText edtAnswer = ViewBindings.findChildViewById(rootView, id);
      if (edtAnswer == null) {
        break missingId;
      }

      id = R.id.edt_content;
      EditText edtContent = ViewBindings.findChildViewById(rootView, id);
      if (edtContent == null) {
        break missingId;
      }

      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.iv_more;
      ImageView ivMore = ViewBindings.findChildViewById(rootView, id);
      if (ivMore == null) {
        break missingId;
      }

      id = R.id.iv_more_answer;
      ImageView ivMoreAnswer = ViewBindings.findChildViewById(rootView, id);
      if (ivMoreAnswer == null) {
        break missingId;
      }

      id = R.id.iv_send;
      ImageView ivSend = ViewBindings.findChildViewById(rootView, id);
      if (ivSend == null) {
        break missingId;
      }

      id = R.id.iv_send_content;
      ImageView ivSendContent = ViewBindings.findChildViewById(rootView, id);
      if (ivSendContent == null) {
        break missingId;
      }

      id = R.id.lin_answer;
      LinearLayout linAnswer = ViewBindings.findChildViewById(rootView, id);
      if (linAnswer == null) {
        break missingId;
      }

      id = R.id.lin_more;
      LinearLayout linMore = ViewBindings.findChildViewById(rootView, id);
      if (linMore == null) {
        break missingId;
      }

      id = R.id.lin_more_answer;
      LinearLayout linMoreAnswer = ViewBindings.findChildViewById(rootView, id);
      if (linMoreAnswer == null) {
        break missingId;
      }

      id = R.id.rel_answer;
      RelativeLayout relAnswer = ViewBindings.findChildViewById(rootView, id);
      if (relAnswer == null) {
        break missingId;
      }

      id = R.id.rel_more;
      RelativeLayout relMore = ViewBindings.findChildViewById(rootView, id);
      if (relMore == null) {
        break missingId;
      }

      id = R.id.rel_more_answer;
      RelativeLayout relMoreAnswer = ViewBindings.findChildViewById(rootView, id);
      if (relMoreAnswer == null) {
        break missingId;
      }

      id = R.id.topbar;
      LinearLayout topbar = ViewBindings.findChildViewById(rootView, id);
      if (topbar == null) {
        break missingId;
      }

      id = R.id.tv_answer;
      TextView tvAnswer = ViewBindings.findChildViewById(rootView, id);
      if (tvAnswer == null) {
        break missingId;
      }

      id = R.id.tv_answer_date;
      TextView tvAnswerDate = ViewBindings.findChildViewById(rootView, id);
      if (tvAnswerDate == null) {
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

      id = R.id.tv_delete_answer;
      TextView tvDeleteAnswer = ViewBindings.findChildViewById(rootView, id);
      if (tvDeleteAnswer == null) {
        break missingId;
      }

      id = R.id.tv_modify;
      TextView tvModify = ViewBindings.findChildViewById(rootView, id);
      if (tvModify == null) {
        break missingId;
      }

      id = R.id.tv_modify_answer;
      TextView tvModifyAnswer = ViewBindings.findChildViewById(rootView, id);
      if (tvModifyAnswer == null) {
        break missingId;
      }

      id = R.id.tv_receiver;
      TextView tvReceiver = ViewBindings.findChildViewById(rootView, id);
      if (tvReceiver == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.tv_write_date;
      TextView tvWriteDate = ViewBindings.findChildViewById(rootView, id);
      if (tvWriteDate == null) {
        break missingId;
      }

      id = R.id.tv_writer;
      TextView tvWriter = ViewBindings.findChildViewById(rootView, id);
      if (tvWriter == null) {
        break missingId;
      }

      return new ActivityCounselDetailBinding((RelativeLayout) rootView, cardAnswer, cardAnswerBtn,
          edtAnswer, edtContent, ivBack, ivMore, ivMoreAnswer, ivSend, ivSendContent, linAnswer,
          linMore, linMoreAnswer, relAnswer, relMore, relMoreAnswer, topbar, tvAnswer, tvAnswerDate,
          tvContent, tvDelete, tvDeleteAnswer, tvModify, tvModifyAnswer, tvReceiver, tvTitle,
          tvWriteDate, tvWriter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
