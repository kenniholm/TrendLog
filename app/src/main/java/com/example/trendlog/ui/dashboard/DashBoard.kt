package com.example.trendlog.ui.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.trendlog.R

class DashBoard : Fragment() {

    companion object {
        fun newInstance() = DashBoard()
    }

    private lateinit var viewModel: DashBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val viewModelFactory = DashBoardViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DashBoardViewModel::class.java)

        return inflater.inflate(R.layout.dash_board_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            logoutDialog()
        }
        callback.isEnabled = true

    }

    private fun logoutDialog(){
        val dialogBuilder = AlertDialog.Builder(this.activity)
        dialogBuilder.setTitle("Warning!")
        dialogBuilder.setMessage("Are you sure you wanna logout?")
        dialogBuilder.setPositiveButton("Yes") { _, _ ->
            logout()
        }
        dialogBuilder.setNegativeButton("No") { _, _ ->
            // No cancels the alertDialog.
        }
        dialogBuilder.show()
    }

    private fun logout(){
        findNavController().navigate(R.id.action_dashBoard_to_login)
    }

}
