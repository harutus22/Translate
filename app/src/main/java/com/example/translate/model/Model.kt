package com.example.translate.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Model (
    @Expose
    @SerializedName("definitions")val definitions: List<Definition>?,
    @Expose
    @SerializedName("word")val word: String?,
    @Expose
    @SerializedName("pronunciation")val pronunciation: String?
                  )

data class Definition(
    @Expose
    @SerializedName("type")val type: String?,
    @Expose
    @SerializedName("definition")val definition: String?,
    @Expose
    @SerializedName("example")val example: String?,
    @Expose
    @SerializedName("image_url")val image_url: String?,
    @Expose
    @SerializedName("emoji")val emoji: String?
    )