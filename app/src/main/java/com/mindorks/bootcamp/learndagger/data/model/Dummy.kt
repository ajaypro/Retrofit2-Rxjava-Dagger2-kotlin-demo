package com.mindorks.bootcamp.learndagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ajay Deepak on 17-06-2019.
 */

//Dummy api

data class Dummy(

        @Expose
        @SerializedName("name")
        val name: String,

        @Expose
        @SerializedName("imageUrl")
        val imageUrl: String

)