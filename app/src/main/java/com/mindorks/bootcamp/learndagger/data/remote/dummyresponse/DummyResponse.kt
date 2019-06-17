package com.mindorks.bootcamp.learndagger.data.remote.dummyresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mindorks.bootcamp.learndagger.data.model.Dummy

/**
 * Created by Ajay Deepak on 17-06-2019.
 */

data class DummyResponse(

        @Expose
        @SerializedName("statusCode")
        val statusCode: String,

        @Expose
        @SerializedName("message")
        val message: String,

        @Expose
        @SerializedName("data")
        val data: List<Dummy>

)
