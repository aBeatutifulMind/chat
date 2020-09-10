package com.junyyy.dev

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.junyyy.dev.databinding.ActivityMainBinding

import com.getstream.sdk.chat.Chat
import com.getstream.sdk.chat.viewmodel.ChannelListViewModel
import io.getstream.chat.android.client.errors.ChatError
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.Filters.`in`
import io.getstream.chat.android.client.models.Filters.and
import io.getstream.chat.android.client.models.Filters.eq
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.client.socket.InitConnectionListener

//import com.junyyy.dev


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chat = Chat.Builder("b67pax5b2wdq", this.applicationContext).logLevel(ChatLogLevel.ALL).build()
        val client = chat.client
        val user = User("summer-brook-2")
        user.extraData["name"] = "Paranoid Android"
        user.extraData["image"] = "https://bit.ly/2TIt8NR"
        val token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoic3VtbWVyLWJyb29rLTIifQ.CzyOx8kgrc61qVbzWvhV1WD3KPEo5ZFZH-326hIdKz0"

        client.setUser(user, token, object : InitConnectionListener() {
            override fun onSuccess(data: ConnectionData) {
                Log.i("MainActivity", "setUser completed")
            }

            override fun onError(error: ChatError) {
                Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_LONG).show()
                Log.e("MainActivity", "setUser onError")
            }
        })

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}