package com.example.trendlog.ui.register

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
import com.example.trendlog.R
import com.example.trendlog.databinding.RegisterFragmentBinding
import kotlinx.android.synthetic.main.register_fragment.*

class Register : Fragment() {

    companion object {
        fun newInstance() = Register()
    }

    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding : RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory =
            RegisterViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)
        binding.registerViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.userData.observe(viewLifecycleOwner, Observer {
            if (it == null){
                userMessage("A user with that E-Mail was already registered.")
            }
            else{
                userMessage("Your user was created!")

                findNavController().navigate(R.id.action_register_to_login)
            }
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        regButton.setOnClickListener{
            var userName = binding.regNameInput.text.toString()
            var passWord = binding.regPasswordInput.text.toString()
            var eMail = binding.regEmailInput.text.toString()

            viewModel.register(userName, passWord, eMail)
        }
        haveAccountTV.setOnClickListener{
            findNavController().navigate(R.id.action_register_to_login)
        }
    }

    private fun userMessage(message: String){
        val toast = Toast.makeText(this.activity, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}
