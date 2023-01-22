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

public final class ZzBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button cancelBtn;

  @NonNull
  public final Button confirmBtn;

  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final EditText edtPhone;

  @NonNull
  public final RadioButton femaleRd;

  @NonNull
  public final ImageView imgvBack;

  @NonNull
  public final ImageView imgvProfile;

  @NonNull
  public final RadioButton maleRd;

  @NonNull
  public final LinearLayout personalinfo;

  @NonNull
  public final RadioGroup rdoGender;

  @NonNull
  public final LinearLayout topbar;

  @NonNull
  public final TextView tvBirth;

  @NonNull
  public final TextView tvId;

  @NonNull
  public final TextView tvType;

  private ZzBinding(@NonNull RelativeLayout rootView, @NonNull Button cancelBtn,
      @NonNull Button confirmBtn, @NonNull EditText edtEmail, @NonNull EditText edtName,
      @NonNull EditText edtPhone, @NonNull RadioButton femaleRd, @NonNull ImageView imgvBack,
      @NonNull ImageView imgvProfile, @NonNull RadioButton maleRd,
      @NonNull LinearLayout personalinfo, @NonNull RadioGroup rdoGender,
      @NonNull LinearLayout topbar, @NonNull TextView tvBirth, @NonNull TextView tvId,
      @NonNull TextView tvType) {
    this.rootView = rootView;
    this.cancelBtn = cancelBtn;
    this.confirmBtn = confirmBtn;
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.edtPhone = edtPhone;
    this.femaleRd = femaleRd;
    this.imgvBack = imgvBack;
    this.imgvProfile = imgvProfile;
    this.maleRd = maleRd;
    this.personalinfo = personalinfo;
    this.rdoGender = rdoGender;
    this.topbar = topbar;
    this.tvBirth = tvBirth;
    this.tvId = tvId;
    this.tvType = tvType;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ZzBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ZzBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.zz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ZzBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
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

      id = R.id.edt_email;
      EditText edtEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edt_name;
      EditText edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.edt_phone;
      EditText edtPhone = ViewBindings.findChildViewById(rootView, id);
      if (edtPhone == null) {
        break missingId;
      }

      id = R.id.female_rd;
      RadioButton femaleRd = ViewBindings.findChildViewById(rootView, id);
      if (femaleRd == null) {
        break missingId;
      }

      id = R.id.imgv_back;
      ImageView imgvBack = ViewBindings.findChildViewById(rootView, id);
      if (imgvBack == null) {
        break missingId;
      }

      id = R.id.imgv_profile;
      ImageView imgvProfile = ViewBindings.findChildViewById(rootView, id);
      if (imgvProfile == null) {
        break missingId;
      }

      id = R.id.male_rd;
      RadioButton maleRd = ViewBindings.findChildViewById(rootView, id);
      if (maleRd == null) {
        break missingId;
      }

      id = R.id.personalinfo;
      LinearLayout personalinfo = ViewBindings.findChildViewById(rootView, id);
      if (personalinfo == null) {
        break missingId;
      }

      id = R.id.rdo_gender;
      RadioGroup rdoGender = ViewBindings.findChildViewById(rootView, id);
      if (rdoGender == null) {
        break missingId;
      }

      id = R.id.topbar;
      LinearLayout topbar = ViewBindings.findChildViewById(rootView, id);
      if (topbar == null) {
        break missingId;
      }

      id = R.id.tv_birth;
      TextView tvBirth = ViewBindings.findChildViewById(rootView, id);
      if (tvBirth == null) {
        break missingId;
      }

      id = R.id.tv_id;
      TextView tvId = ViewBindings.findChildViewById(rootView, id);
      if (tvId == null) {
        break missingId;
      }

      id = R.id.tv_type;
      TextView tvType = ViewBindings.findChildViewById(rootView, id);
      if (tvType == null) {
        break missingId;
      }

      return new ZzBinding((RelativeLayout) rootView, cancelBtn, confirmBtn, edtEmail, edtName,
          edtPhone, femaleRd, imgvBack, imgvProfile, maleRd, personalinfo, rdoGender, topbar,
          tvBirth, tvId, tvType);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
