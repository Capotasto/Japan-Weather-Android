package com.funkyhacker.japanweather.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class BindingAdapters {

  @BindingAdapter("imageUri")
  public static void setImageUri(ImageView view, String imageUri) {
    Glide.with(view.getContext())
        .load(imageUri)
        .placeholder(android.R.drawable.ic_delete)
        .error(android.R.drawable.ic_secure)
        .into(view);
  }
}
