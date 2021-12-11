package com.example.sentiment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sentiment2.databinding.FragmentResetPassword2Binding
import com.example.sentiment2.databinding.FragmentResetPasswordBinding
import com.example.sentiment2.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass.
 */
class ResetPassword2Fragment : Fragment() {
    private var _binding: FragmentResetPassword2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResetPassword2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resetPasswordContinue2.setOnClickListener{
            findNavController().navigate(R.id.action_resetPassword2Fragment2_to_resetPassword3Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}