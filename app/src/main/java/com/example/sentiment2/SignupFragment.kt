package com.example.sentiment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sentiment2.databinding.FragmentSecondBinding
import com.example.sentiment2.databinding.FragmentSignupBinding

/**
 * A simple [Fragment] subclass.
 */
class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SignupEmail.setOnClickListener{
            // Parse email for validity
            //Then auto move to PasswordFirst
            binding.SignupPasswordFirst.requestFocus() // If successful
        }
        binding.SignupPasswordFirst.setOnClickListener{
            // Parse password for validity e.g not too short or too long or "password"
            //Then auto move to PasswordSecond
            binding.SignupPasswordSecond.requestFocus() // If successful

        }
        binding.SignupPasswordSecond.setOnClickListener{
            // Check that PasswordFirst and PasswordSecond are identical
            // Update database here with email and password, ensure passwords are hashed
            binding.SignupButton.requestFocus()
        }

        binding.SignupButton.setOnClickListener{
            findNavController().navigate(R.id.action_signupFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}