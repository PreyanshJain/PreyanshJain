package com.example.preyanshjain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {
    lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        login_button.setOnClickListener {
            login_button.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()

            LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult){
                    val graphRequest = GraphRequest.newMeRequest(result?.accessToken){ obj, response ->
                        try{

                            if (obj != null) {
                                if (obj.has("id")){
                                    Log.d("facebooklogin","completed")
                                }

                            }
                        }catch(e : Exception){
                        }
                    }
                    val param = Bundle()
                    param.putString("fields", "name,email,id,picture.type(large)")
                    graphRequest.parameters = param
                    graphRequest.executeAsync()
                }

                override fun onCancel() {
                    TODO("Not yet implemented")
                }

                override fun onError(error: FacebookException) {
                    TODO("Not yet implemented")
                }
            })
            val i = Intent(this@LoginScreen,HomeScreen::class.java)
            startActivity(i)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode,resultCode,data)
    }
}