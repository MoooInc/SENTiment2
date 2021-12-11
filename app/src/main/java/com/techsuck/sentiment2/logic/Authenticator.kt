package com.techsuck.sentiment2.logic

import android.content.Context
import android.widget.Toast
import com.techsuck.sentiment2.databinding.FragmentFirstBinding

private fun authenticateEmailInput(binding: FragmentFirstBinding, context: Context): Boolean {
    // Check that it is valid email
    var authenticated: Boolean = false;
    val email = binding.landingEmail.text
    // This is merely a mockup, showing how to get email text on button
    if(email.toString() != "email@gmail.com"){
        // A toast merely shows a message at the bottom to the user, in this case
        // it shows Incorrect email unless you write email@gmail.com
        val toast: Toast = Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT)
        toast.show()
    }
    else {
        authenticated = true;
        val toast: Toast = Toast.makeText(context, email, Toast.LENGTH_SHORT)
        toast.show()
        binding.landingPassword.requestFocus() // If you hit enter it refocuses to password
        // so you can type email, hit enter or enter on keyboard and it'll auto take you to
        // the password
    }
    return authenticated;
}

private fun authenticatePasswordInput(binding: FragmentFirstBinding, context: Context): Boolean {
    // Check that password is valid for given email
    // Use similar code as for email, obviously not in UI code but rather calling backend
    var authenticated: Boolean = false;
    val password = binding.landingPassword.text
    val email = binding.landingEmail.text
    if(password.toString() == "password" && email.toString() == "email@gmail.com"){
        authenticated = true;
    }
    else{
        val toast: Toast = Toast.makeText(context, "Incorrect email or password", Toast.LENGTH_SHORT)
        toast.show()
    }
    return authenticated;
}

fun authenticated(binding: FragmentFirstBinding, context: Context?): Boolean {
    return authenticateEmailInput(binding, context!!) && authenticatePasswordInput(binding, context);
}