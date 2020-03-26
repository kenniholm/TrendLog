package com.example.trendlog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.trendlog.R
import com.example.trendlog.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*

class Login : Fragment() {

    companion object {
        fun newInstance() = Login()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    //Do any graphical initialisations
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = LoginViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        return binding.root
    }
    //Used for modifying UI elements
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginButton.setOnClickListener {
            var eMail = binding.eMailInput.text.toString()
            var passWord = binding.passWordInput.text.toString()
            viewModel.login(eMail, passWord)
        }
        noAccountClickTV.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_login_to_register)
        }
    }

}
