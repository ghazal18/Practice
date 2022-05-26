package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    val viewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ButtonRegister.setOnClickListener {
            viewModel.register(
                binding.EditTextFullName.text.toString(),
                binding.EditTextPassword.text.toString().toInt()
            )
        }
        binding.TextViewLogin.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }
}