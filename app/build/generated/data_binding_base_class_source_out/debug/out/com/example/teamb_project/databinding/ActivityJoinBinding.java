// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.teamb_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityJoinBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView birthTv;

  @NonNull
  public final Button cancelBtn;

  @NonNull
  public final Button confirmBtn;

  @NonNull
  public final EditText emailEt;

  @NonNull
  public final RadioButton femaleRd;

  @NonNull
  public final TextView idCkTv;

  @NonNull
  public final EditText idEt;

  @NonNull
  public final ImageView imgvBack;

  @NonNull
  public final RadioButton maleRd;

  @NonNull
  public final EditText nameEt;

  @NonNull
  public final LinearLayout personalinfo;

  @NonNull
  public final EditText phoneEt;

  @NonNull
  public final EditText pwCkEt;

  @NonNull
  public final EditText pwEt;

  @NonNull
  public final RadioGroup radioGroup2;

  @NonNull
  public final TextView studTv;

  @NonNull
  public final TextView teachTv;

  @NonNull
  public final LinearLayout topbar;

  private ActivityJoinBinding(@NonNull RelativeLayout rootView, @NonNull TextView birthTv,
      @NonNull Button cancelBtn, @NonNull Button confirmBtn, @NonNull EditText emailEt,
      @NonNull RadioButton femaleRd, @NonNull TextView idCkTv, @NonNull EditText idEt,
      @NonNull ImageView imgvBack, @NonNull RadioButton maleRd, @NonNull EditText nameEt,
      @NonNull LinearLayout personalinfo, @NonNull EditText phoneEt, @NonNull EditText pwCkEt,
      @NonNull EditText pwEt, @NonNull RadioGroup radioGroup2, @NonNull TextView studTv,
      @NonNull TextView teachTv, @NonNull LinearLayout topbar) {
    this.rootView = rootView;
    this.birthTv = birthTv;
    this.cancelBtn = cancelBtn;
    this.confirmBtn = confirmBtn;
    this.emailEt = emailEt;
    this.femaleRd = femaleRd;
    this.idCkTv = idCkTv;
    this.idEt = idEt;
    this.imgvBack = imgvBack;
    this.maleRd = maleRd;
    this.nameEt = nameEt;
    this.personalinfo = personalinfo;
    this.phoneEt = phoneEt;
    this.pwCkEt = pwCkEt;
    this.pwEt = pwEt;
    this.radioGroup2 = radioGroup2;
    this.studTv = studTv;
    this.teachTv = teachTv;
    this.topbar = topbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityJoinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityJoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_join, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityJoinBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.birth_tv;
      TextView birthTv = ViewBindings.findChildViewById(rootView, id);
      if (birthTv == null) {
        break missingId;
      }

      id = R.id.cancel_btn;
      Button cancelBtn = ViewBindings.findChildViewById(rootView, id);
      if (cancelBtn == null) {
        break missingId;
      }

      id = R.id.confirm_btn;
      Button confirmBtn = ViewBindings.findChildViewById(rootView, id);
      if (confirmBtn == null) {
        break missingId;
      }

      id = R.id.email_et;
      EditText emailEt = ViewBindings.findChildViewById(rootView, id);
      if (emailEt == null) {
        break missingId;
      }

      id = R.id.female_rd;
      RadioButton femaleRd = ViewBindings.findChildViewById(rootView, id);
      if (femaleRd == null) {
        break missingId;
      }

      id = R.id.id_ck_tv;
      TextView idCkTv = ViewBindings.findChildViewById(rootView, id);
      if (idCkTv == null) {
        break missingId;
      }

      id = R.id.id_et;
      EditText idEt = ViewBindings.findChildViewById(rootView, id);
      if (idEt == null) {
        break missingId;
      }

      id = R.id.imgv_back;
      ImageView imgvBack = ViewBindings.findChildViewById(rootView, id);
      if (imgvBack == null) {
        break missingId;
      }

      id = R.id.male_rd;
      RadioButton maleRd = ViewBindings.findChildViewById(rootView, id);
      if (maleRd == null) {
        break missingId;
      }

      id = R.id.name_et;
      EditText nameEt = ViewBindings.findChildViewById(rootView, id);
      if (nameEt == null) {
        break missingId;
      }

      id = R.id.personalinfo;
      LinearLayout personalinfo = ViewBindings.findChildViewById(rootView, id);
      if (personalinfo == null) {
        break missingId;
      }

      id = R.id.phone_et;
      EditText phoneEt = ViewBindings.findChildViewById(rootView, id);
      if (phoneEt == null) {
        break missingId;
      }

      id = R.id.pw_ck_et;
      EditText pwCkEt = ViewBindings.findChildViewById(rootView, id);
      if (pwCkEt == null) {
        break missingId;
      }

      id = R.id.pw_et;
      EditText pwEt = ViewBindings.findChildViewById(rootView, id);
      if (pwEt == null) {
        break missingId;
      }

      id = R.id.radioGroup2;
      RadioGroup radioGroup2 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup2 == null) {
        break missingId;
      }

      id = R.id.stud_tv;
      TextView studTv = ViewBindings.findChildViewById(rootView, id);
      if (studTv == null) {
        break missingId;
      }

      id = R.id.teach_tv;
      TextView teachTv = ViewBindings.findChildViewById(rootView, id);
      if (teachTv == null) {
        break missingId;
      }

      id = R.id.topbar;
      LinearLayout topbar = ViewBindings.findChildViewById(rootView, id);
      if (topbar == null) {
        break missingId;
      }

      return new ActivityJoinBinding((RelativeLayout) rootView, birthTv, cancelBtn, confirmBtn,
          emailEt, femaleRd, idCkTv, idEt, imgvBack, maleRd, nameEt, personalinfo, phoneEt, pwCkEt,
          pwEt, radioGroup2, studTv, teachTv, topbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}