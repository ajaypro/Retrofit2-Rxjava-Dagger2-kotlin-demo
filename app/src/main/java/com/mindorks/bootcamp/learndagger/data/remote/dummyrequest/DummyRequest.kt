package com.mindorks.bootcamp.learndagger.data.remote.dummyrequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ajay Deepak on 17-06-2019.
 */
data class DummyRequest (

        @Expose
        @SerializedName("id")
        val id: Int

)
