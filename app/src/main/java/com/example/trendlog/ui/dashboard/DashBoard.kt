package com.example.trendlog.ui.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.trendlog.R
import com.example.trendlog.databinding.DashBoardFragmentBinding

class DashBoard : Fragment() {

    companion object {
        fun newInstance() = DashBoard()
    }

    private lateinit var viewModel: DashBoardViewModel
    private lateinit var binding : DashBoardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dash_board_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = DashBoardViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DashBoardViewModel::class.java)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            logoutDialog()
        }
        callback.isEnabled = true

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboardmenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logoutFromMenu -> {
                logoutDialog()
            }
        }
        return super.onOptionsItemSelected(item)
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
