package com.mindorks.bootcamp.learndagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ajay Deepak on 17-06-2019.
 */

data class PostListResponse(

        @Expose
        @SerializedName("statusCode")
        val statusCode: String,

        @Expose
        @SerializedName("message")
        val message: String,

        @Expose
        @SerializedName("data")
        val data: List<Post>
)