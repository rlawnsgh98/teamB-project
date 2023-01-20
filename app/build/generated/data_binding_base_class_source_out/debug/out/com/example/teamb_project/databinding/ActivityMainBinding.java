// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnBoard;

  @NonNull
  public final Button btnBoardDetail;

  @NonNull
  public final Button btnCounsel;

  @NonNull
  public final Button btnNotice;

  @NonNull
  public final Button btnVideo;

  @NonNull
  public final Button btnVideoBoard;

  @NonNull
  public final TextView tvTest;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Button btnBoard,
      @NonNull Button btnBoardDetail, @NonNull Button btnCounsel, @NonNull Button btnNotice,
      @NonNull Button btnVideo, @NonNull Button btnVideoBoard, @NonNull TextView tvTest) {
    this.rootView = rootView;
    this.btnBoard = btnBoard;
    this.btnBoardDetail = btnBoardDetail;
    this.btnCounsel = btnCounsel;
    this.btnNotice = btnNotice;
    this.btnVideo = btnVideo;
    this.btnVideoBoard = btnVideoBoard;
    this.tvTest = tvTest;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_board;
      Button btnBoard = ViewBindings.findChildViewById(rootView, id);
      if (btnBoard == null) {
        break missingId;
      }

      id = R.id.btn_board_detail;
      Button btnBoardDetail = ViewBindings.findChildViewById(rootView, id);
      if (btnBoardDetail == null) {
        break missingId;
      }

      id = R.id.btn_counsel;
      Button btnCounsel = ViewBindings.findChildViewById(rootView, id);
      if (btnCounsel == null) {
        break missingId;
      }

      id = R.id.btn_notice;
      Button btnNotice = ViewBindings.findChildViewById(rootView, id);
      if (btnNotice == null) {
        break missingId;
      }

      id = R.id.btn_video;
      Button btnVideo = ViewBindings.findChildViewById(rootView, id);
      if (btnVideo == null) {
        break missingId;
      }

      id = R.id.btn_video_board;
      Button btnVideoBoard = ViewBindings.findChildViewById(rootView, id);
      if (btnVideoBoard == null) {
        break missingId;
      }

      id = R.id.tv_test;
      TextView tvTest = ViewBindings.findChildViewById(rootView, id);
      if (tvTest == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btnBoard, btnBoardDetail, btnCounsel,
          btnNotice, btnVideo, btnVideoBoard, tvTest);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}