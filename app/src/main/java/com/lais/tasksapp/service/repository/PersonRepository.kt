package com.lais.tasksapp.service.repository

import android.content.Context
import com.lais.tasksapp.R
import com.lais.tasksapp.service.listener.APIListener
import com.lais.tasksapp.service.model.PersonModel
import com.lais.tasksapp.service.repository.remote.PersonService
import com.lais.tasksapp.service.repository.remote.RetrofitClient

class PersonRepository(context: Context) : BaseRepository(context) {

    private val remote = RetrofitClient.getService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIListener<PersonModel>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCall(remote.login(email, password), listener)
    }

    fun create(name: String, email: String, password: String, listener: APIListener<PersonModel>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCall(remote.create(name, email, password), listener)
    }

}