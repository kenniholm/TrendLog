package com.example.trendlog.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.trendlog.R
import com.example.trendlog.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*

class Login : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    companion object {
        fun newInstance() = Login()
    }

    private lateinit var viewModel: LoginViewModel
    //Do any graphical initialisations
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        viewModel = ViewModelProvider.NewInstanceFactory().create(LoginViewModel::class.java)
        return binding.root
    }
    //Used for modifying UI elements
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginButton.setOnClickListener(){
            viewModel.login()
        }
        alreadyMemberClick.setOnClickListener(){
            viewModel.login()
        }
    }

}
