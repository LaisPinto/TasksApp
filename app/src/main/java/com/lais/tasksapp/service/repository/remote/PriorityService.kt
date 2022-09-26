package com.lais.tasksapp.service.repository.remote

import com.lais.tasksapp.service.model.PriorityModel
import retrofit2.Call
import retrofit2.http.GET

interface PriorityService {

    @GET("Priority")
    fun list(): Call<List<PriorityModel>>

}