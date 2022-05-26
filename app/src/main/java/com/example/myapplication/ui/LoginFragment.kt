package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    val viewModel: LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ButtonLogin.setOnClickListener {
            viewModel.getUser(
                binding.EditTextId.text.toString(),
                binding.EditTextPassword.text.toString().toInt()
            )
        }
        viewModel.login.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(activity, "Login OK!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}