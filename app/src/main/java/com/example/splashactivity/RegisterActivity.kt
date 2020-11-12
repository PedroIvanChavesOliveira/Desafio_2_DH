package com.example.splashactivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private var isNameOk = false
    private var isEmailOk = false
    private var isPasswordOk = false
    private var isConfirmPasswordOk = false
    private var validationEmail = false
    private var validationPassword = false
    private var validationName = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        textChangeDefault(tietNameRegister, tilNameRegister, R.string.string_name)
        textChangeDefault(tietEmailRegister, tilEmailRegister, R.string.string_email)
        textChangeDefault(tietPasswordRegister, tilPasswordRegister, R.string.string_password)
        confirmPassword(tietConfirmPasswordRegister, tietPasswordRegister)

        setActionBar()

        btRegister.setOnClickListener {
            startMenuActivity(this@RegisterActivity)
        }
    }

    private fun textChangeDefault(editText: EditText, textInput: TextInputLayout, errorString: Int) {
        editText.doOnTextChanged { text, start, _, count ->
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

            if(editText.tag == getString(R.string.string_password)) {
                passwordLength(start+1)
            }

            if(editText.tag == getString(R.string.string_name)) {
                nameLength(count)
            }
            activatingButton()
        }
    }

    private fun confirmPassword(editText1: EditText, editText2: EditText) {
        editText1.doOnTextChanged { text, _, _, _ ->
            if(text.toString() == editText2.text.toString()) {
                setByTag(editText1.tag as String, true)
            }else {
                setByTag(editText1.tag as String, false)
            }
            activatingButton()
        }
    }

    private fun passwordLength(count: Int) {
        if(count >= 5) {
            validationPassword = true
            tilPasswordRegister.isErrorEnabled = false
        }else {
            validationPassword = false
            tilPasswordRegister.error = getString(R.string.validationPassword)
        }
    }

    private fun nameLength(count: Int) {
        if(count >= 2) {
            validationName = true
            tilNameRegister.isErrorEnabled = false
        }else {
            validationName = false
            tilNameRegister.error = getString(R.string.validationName)
        }
    }

    private fun validatingEmail(email: String) {
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            validationEmail = true
            tilEmailRegister.isErrorEnabled = false
        }else {
            validationEmail = false
            tilEmailRegister.error = getString(R.string.validationEmail)
        }
    }

    private fun setByTag(tag: String, isOk: Boolean) {
        when(tag) {
            getString(R.string.string_email) -> isEmailOk = isOk
            getString(R.string.string_password) -> isPasswordOk = isOk
            getString(R.string.string_name) -> isNameOk = isOk
            getString(R.string.string_confirm_password) -> isConfirmPasswordOk = isOk
        }
    }

    private fun activatingButton(): Boolean {
        val isOk: Boolean
        if(isEmailOk && isPasswordOk && validationEmail && isNameOk && isConfirmPasswordOk && validationPassword && validationName) {
            btRegister.isEnabled = true
            isOk = true
        }else {
            isOk = false
            btRegister.isEnabled = false
        }
        return isOk
    }

    private fun startMenuActivity(context: Context) {
        val intent = Intent(context, MenuActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setActionBar() {
        supportActionBar?.setIcon(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setTitle(R.string.string_register)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}