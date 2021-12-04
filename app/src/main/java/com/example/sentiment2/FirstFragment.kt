package com.example.sentiment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.sentiment2.databinding.FragmentFirstBinding
import android.widget.Toast




/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.landingLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.landingEmail.setOnClickListener{
            // Check that it is valid email
            val email = binding.landingEmail.text
            // This is merely a mockup, showing how to get email text on button
            if(email.toString() != "email@gmail.com"){
                // A toast merely shows a message at the bottom to the user, in this case
                    // it shows Incorrect email unless you write email@gmail.com
                val toast: Toast = Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT)
                toast.show()
            }
            else {
                val toast: Toast = Toast.makeText(context, email, Toast.LENGTH_SHORT)
                toast.show()
                binding.landingPassword.requestFocus() // If you hit enter it refocuses to password
                // so you can type email, hit enter or enter on keyboard and it'll auto take you to
                // the password
            }
        }
        binding.landingPassword.setOnClickListener{
            // Check that password is valid for given email
            // Use similar code as for email, obviously not in UI code but rather calling backend
            val password = binding.landingPassword.text
            val email = binding.landingEmail.text
            if(password.toString() == "password" && email.toString() == "email@gmail.com"){
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
            else{
                val toast: Toast = Toast.makeText(context, "Incorrect email or password", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}