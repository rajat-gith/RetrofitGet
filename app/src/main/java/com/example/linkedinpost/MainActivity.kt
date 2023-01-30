package com.example.linkedinpost

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import retrofit2.HttpException
import java.io.IOException

const val TAG = "Tag"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            val response = try {
                APIClient.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have Internet Connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(ContentValues.TAG, "HttpException,unexpected response")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                Log.d(TAG, response.body().toString())
            }
        }
    }
}