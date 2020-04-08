package com.example.trendlog.ui.login

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.afollestad.vvalidator.form
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
        val viewModelFactory =
            LoginViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.setLifecycleOwner(this)

        viewModel.userData.observe(viewLifecycleOwner, Observer {
            if (it == null){
                userMessage("Wrong e-mail or password!")
            }
            else{
                findNavController().navigate(R.id.action_login_to_dashBoard)
            }
        })

        return binding.root
    }
    //Used for modifying UI elements
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        inputValidator()

        noAccountClickTV.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }

    private fun userMessage(message: String){
        val toast = Toast.makeText(this.activity, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun inputValidator(){
        form {
            useRealTimeValidation(disableSubmit = true)
            input(binding.eMailInput){
                isNotEmpty()
                isEmail()
                length().lessThan(64)
            }
            input(binding.passWordInput){
                isNotEmpty()
                length().lessThan(32)
            }
            submitWith(binding.loginButton){
                val eMail = binding.eMailInput.text.toString()
                val passWord = binding.passWordInput.text.toString()
                viewModel.login(eMail, passWord)
            }
        }
    }
}
