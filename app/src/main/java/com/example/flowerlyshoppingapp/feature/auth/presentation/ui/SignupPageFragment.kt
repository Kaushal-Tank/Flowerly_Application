package com.example.flowerlyshoppingapp.feature.auth.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.flowerlyshoppingapp.R
import com.example.flowerlyshoppingapp.core.util.isInternetOn
import com.example.flowerlyshoppingapp.core.util.loadFragment
import com.example.flowerlyshoppingapp.core.util.toast
import com.example.flowerlyshoppingapp.databinding.FragmentSignupPageBinding
import com.example.flowerlyshoppingapp.feature.auth.presentation.viewmodel.AuthViewModel
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.ui.DashboardActivity

class SignupPageFragment : Fragment() {

    private var _binding: FragmentSignupPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        observeViewModel()

        // Sign up user
        binding.signIn.setOnClickListener {

            if (isInternetOn(requireContext())) {
                val firstName = binding.etSuFirstName.text.toString()
                val lastName = binding.etSuLastName.text.toString()
                val email = binding.etSuEmail.text.toString()
                val password = binding.etSuPassword.text.toString()
                val confirmPassword = binding.etSuConfirmPassword.text.toString()

                if (password == confirmPassword) {
                    viewModel.registerUser(firstName, lastName, email, password)
                } else {
                    toast("Password not match. Enter same password !")
                }
            } else {
                toast("Turn on Internet !")
            }

        }

        // Go to log in page
        binding.goToLogin.setOnClickListener {
            loadFragment(R.id.auth_frame, LogInPageFragment())
        }

        // TODO Go to home page as guest


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.signupState.observe(viewLifecycleOwner) { state ->
            if (state == "SUCCESS") {
                startActivity(
                    Intent(requireContext(), DashboardActivity::class.java)
                )
                requireActivity()
                    .finish()
            } else {
                toast(state)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}