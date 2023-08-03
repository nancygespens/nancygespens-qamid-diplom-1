// Generated by view binder compiler. Do not edit!
package ru.iteco.fmhandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.iteco.fmhandroid.R;

public final class FragmentAboutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView aboutCompanyInfoLabelTextView;

  @NonNull
  public final TextView aboutPrivacyPolicyLabelTextView;

  @NonNull
  public final TextView aboutPrivacyPolicyValueTextView;

  @NonNull
  public final TextView aboutTermsOfUseLabelTextView;

  @NonNull
  public final TextView aboutTermsOfUseValueTextView;

  @NonNull
  public final TextView aboutVersionTitleTextView;

  @NonNull
  public final TextView aboutVersionValueTextView;

  @NonNull
  public final TopCustomAppBarBinding containerCustomAppBarIncludeOnFragmentAbout;

  private FragmentAboutBinding(@NonNull LinearLayout rootView,
      @NonNull TextView aboutCompanyInfoLabelTextView,
      @NonNull TextView aboutPrivacyPolicyLabelTextView,
      @NonNull TextView aboutPrivacyPolicyValueTextView,
      @NonNull TextView aboutTermsOfUseLabelTextView,
      @NonNull TextView aboutTermsOfUseValueTextView, @NonNull TextView aboutVersionTitleTextView,
      @NonNull TextView aboutVersionValueTextView,
      @NonNull TopCustomAppBarBinding containerCustomAppBarIncludeOnFragmentAbout) {
    this.rootView = rootView;
    this.aboutCompanyInfoLabelTextView = aboutCompanyInfoLabelTextView;
    this.aboutPrivacyPolicyLabelTextView = aboutPrivacyPolicyLabelTextView;
    this.aboutPrivacyPolicyValueTextView = aboutPrivacyPolicyValueTextView;
    this.aboutTermsOfUseLabelTextView = aboutTermsOfUseLabelTextView;
    this.aboutTermsOfUseValueTextView = aboutTermsOfUseValueTextView;
    this.aboutVersionTitleTextView = aboutVersionTitleTextView;
    this.aboutVersionValueTextView = aboutVersionValueTextView;
    this.containerCustomAppBarIncludeOnFragmentAbout = containerCustomAppBarIncludeOnFragmentAbout;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.about_company_info_label_text_view;
      TextView aboutCompanyInfoLabelTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutCompanyInfoLabelTextView == null) {
        break missingId;
      }

      id = R.id.about_privacy_policy_label_text_view;
      TextView aboutPrivacyPolicyLabelTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutPrivacyPolicyLabelTextView == null) {
        break missingId;
      }

      id = R.id.about_privacy_policy_value_text_view;
      TextView aboutPrivacyPolicyValueTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutPrivacyPolicyValueTextView == null) {
        break missingId;
      }

      id = R.id.about_terms_of_use_label_text_view;
      TextView aboutTermsOfUseLabelTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutTermsOfUseLabelTextView == null) {
        break missingId;
      }

      id = R.id.about_terms_of_use_value_text_view;
      TextView aboutTermsOfUseValueTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutTermsOfUseValueTextView == null) {
        break missingId;
      }

      id = R.id.about_version_title_text_view;
      TextView aboutVersionTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutVersionTitleTextView == null) {
        break missingId;
      }

      id = R.id.about_version_value_text_view;
      TextView aboutVersionValueTextView = ViewBindings.findChildViewById(rootView, id);
      if (aboutVersionValueTextView == null) {
        break missingId;
      }

      id = R.id.container_custom_app_bar_include_on_fragment_about;
      View containerCustomAppBarIncludeOnFragmentAbout = ViewBindings.findChildViewById(rootView, id);
      if (containerCustomAppBarIncludeOnFragmentAbout == null) {
        break missingId;
      }
      TopCustomAppBarBinding binding_containerCustomAppBarIncludeOnFragmentAbout = TopCustomAppBarBinding.bind(containerCustomAppBarIncludeOnFragmentAbout);

      return new FragmentAboutBinding((LinearLayout) rootView, aboutCompanyInfoLabelTextView,
          aboutPrivacyPolicyLabelTextView, aboutPrivacyPolicyValueTextView,
          aboutTermsOfUseLabelTextView, aboutTermsOfUseValueTextView, aboutVersionTitleTextView,
          aboutVersionValueTextView, binding_containerCustomAppBarIncludeOnFragmentAbout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}