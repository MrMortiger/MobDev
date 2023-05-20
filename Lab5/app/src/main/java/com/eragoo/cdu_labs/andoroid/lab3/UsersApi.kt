package com.eragoo.cdu_labs.andoroid.lab3

import com.eragoo.cdu_labs.andoroid.lab3.model.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface UsersApi {
    @GET("MrMortiger/MobDev/main/users.json")
    suspend fun getAll() : Response<List<UserDto>>
}