// Generated by view binder compiler. Do not edit!
package com.example.teamb_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText etPw;

  @NonNull
  public final EditText idEt;

  @NonNull
  public final TextView joinTv;

  @NonNull
  public final TextView loginTv;

  private ActivityLoginBinding(@NonNull RelativeLayout rootView, @NonNull EditText etPw,
      @NonNull EditText idEt, @NonNull TextView joinTv, @NonNull TextView loginTv) {
    this.rootView = rootView;
    this.etPw = etPw;
    this.idEt = idEt;
    this.joinTv = joinTv;
    this.loginTv = loginTv;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.et_pw;
      EditText etPw = ViewBindings.findChildViewById(rootView, id);
      if (etPw == null) {
        break missingId;
      }

      id = R.id.id_et;
      EditText idEt = ViewBindings.findChildViewById(rootView, id);
      if (idEt == null) {
        break missingId;
      }

      id = R.id.join_tv;
      TextView joinTv = ViewBindings.findChildViewById(rootView, id);
      if (joinTv == null) {
        break missingId;
      }

      id = R.id.login_tv;
      TextView loginTv = ViewBindings.findChildViewById(rootView, id);
      if (loginTv == null) {
        break missingId;
      }

      return new ActivityLoginBinding((RelativeLayout) rootView, etPw, idEt, joinTv, loginTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
