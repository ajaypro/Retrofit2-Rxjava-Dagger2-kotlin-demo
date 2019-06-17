package com.mindorks.bootcamp.learndagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Ajay Deepak on 17-06-2019.
 */

data class Post(

        @Expose
        @SerializedName("id")
        val id: String,

        @Expose
        @SerializedName("imgUrl")
        val imgUrl: String,

        @Expose
        @SerializedName("imgWidth")
        val imgWidth: String,

        @Expose
        @SerializedName("imgHeight")
        val imgHeight: String,

        @Expose
        @SerializedName("user")
        val user: User,

        @Expose
        @SerializedName("likedBy")
        val likedBy: List<User>,

        @Expose
        @SerializedName("createdAt")
        val createdAt: Date

){
     // User data as the post contains user object
    data class User (

            @Expose
            @SerializedName("id")
            val id: String,

            @Expose
            @SerializedName("name")
            val name: String,

            @Expose
            @SerializedName("profilePicUrl")
            val profilePicUrl: String
    )
}


