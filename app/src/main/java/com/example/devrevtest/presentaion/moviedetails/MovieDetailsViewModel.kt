package com.example.devrevtest.presentaion.moviedetails

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MovieDetailsViewModel() : ViewModel() {

    fun getFormattedOverview(prefix: String, overview: String?): CharSequence {
        val formattedText = SpannableStringBuilder()

        // Append the prefix with bold style and larger text size
        formattedText.append(prefix)
        formattedText.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            prefix.length,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        formattedText.setSpan(
            AbsoluteSizeSpan(18, true),  // Replace 24 with your desired text size in pixels
            0,
            prefix.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Append a space between prefix and overview
        formattedText.append(" ")

        // Append the overview
        if (!overview.isNullOrBlank()) {
            formattedText.append(overview)
        }

        return formattedText
    }}
