package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.data.model.PostListResponse
import com.mindorks.bootcamp.learndagger.data.remote.dummyrequest.DummyRequest
import com.mindorks.bootcamp.learndagger.data.remote.dummyresponse.DummyResponse
import com.mindorks.bootcamp.learndagger.data.remote.dummyresponse.GeneralResponse

import com.mindorks.bootcamp.learndagger.di.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.NetworkInfo
import io.reactivex.Single
import retrofit2.http.*

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */
interface NetworkService {

    @POST(Endpoints.DUMMY)
    fun doDummycall(
            @Body request: DummyRequest,
            @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<DummyResponse>

    @GET(Endpoints.DUMMY)
    fun doDummycallGet(
            @Body request: DummyRequest,
            @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<DummyResponse>

     @GET(Endpoints.HOME_POST_LIST)
    fun doHomePostList(
             @Query("firstPostId") firstPostId: String?,
             @Query("lastPostId") lastPostId: String?,
             @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY,
             @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
             @Header(Networking.HEADER_USER_ID) userID: String
     ):Single<PostListResponse>

     @DELETE(Endpoints.POST_DELETE)
    fun doPostDelete(
             @Path("postId") postId: String,
             @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY,
             @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
             @Header(Networking.HEADER_USER_ID) userID: String
    ): Single<GeneralResponse>
}
