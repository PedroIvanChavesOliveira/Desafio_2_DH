package com.example.splashactivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var isEmailOk = false
    var isPasswordOk = false
    var validationEmail = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textChangeDefault(tietEmailLogin, tilEmail, R.string.string_email)
        textChangeDefault(tietPasswordLogin, tilPassword, R.string.string_password)

        btRegisterLogin.setOnClickListener {
            startRegisterActivity(this@LoginActivity)
        }

        btLogIn.setOnClickListener {
            startMenuActivity(this@LoginActivity)
        }
    }

    private fun textChangeDefault(editText: EditText, textInput: TextInputLayout, errorString: Int) {
        editText.doOnTextChanged { text, _, _, _ ->
            if(text?.isBlank() == true) {
                textInput.error = getString(R.string.errorMessage, getString(errorString))
                setByTag(editText.tag as String, false)
            }else {
                textInput.isErrorEnabled = false
                setByTag(editText.tag as String, true)
            }

            if(editText.tag == getString(R.string.string_email)) {
                validatingEmail(text.toString())
            }

            activatingButton()
        }
    }

    private fun validatingEmail(email: String) {
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            validationEmail = true
            tilEmail.isErrorEnabled = false
        }else {
            validationEmail = false
            tilEmail.error = getString(R.string.validationEmail)
        }
    }

    private fun setByTag(tag: String, isOk: Boolean) {
        when(tag) {
            getString(R.string.string_email) -> isEmailOk = isOk
            getString(R.string.string_password) -> isPasswordOk = isOk
        }
    }

    private fun activatingButton(): Boolean {
        val isOk: Boolean
        if(isEmailOk && isPasswordOk && validationEmail) {
            btLogIn.isEnabled = true
            isOk = true
        }else {
            isOk = false
            btLogIn.isEnabled = false
        }

        return isOk
    }

    private fun startRegisterActivity(context: Context) {
        val intent = Intent(context, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun startMenuActivity(context: Context) {
        val intent = Intent(context, MenuActivity::class.java)
        startActivity(intent)
    }
}