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
import com.example.flowerlyshoppingapp.databinding.FragmentLogInPageBinding
import com.example.flowerlyshoppingapp.feature.auth.presentation.viewmodel.AuthViewModel
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.ui.DashboardActivity

class LogInPageFragment : Fragment(R.layout.fragment_log_in_page) {

    private var _binding: FragmentLogInPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        observeViewModel()

        // Log in User
        binding.logIn.setOnClickListener {
            if (isInternetOn(requireContext())) {
                val email = binding.etLiEmail.text.toString()
                val password = binding.etLiPassword.text.toString()

                viewModel.login(email, password)
            } else {
                toast("Turn on Internet !")
            }

        }

        // Go to Sign-up Page
        binding.goToSignUp.setOnClickListener {
            loadFragment(R.id.auth_frame, SignupPageFragment())
        }

        // TODO Go to home page as guest

    }

    private fun observeViewModel() {
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            if (state == "SUCCESS") {
                // TODO add create log in state
                /* fun clearLoginState() {
                    _loginState.value = null
                } */
                startActivity(
                    Intent(requireContext(), DashboardActivity::class.java)
                )
            } else {
                toast(state)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogInPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}