package ru.winelab.viewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.winelab.viewmodel.R
import ru.winelab.viewmodel.TAG
import ru.winelab.viewmodel.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private var countTeamA = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayForTeamA(viewModel.scoreTeamA)

        binding.fMainTeamAButton.setOnClickListener {
            viewModel.scoreTeamA = viewModel.scoreTeamA + 1
            displayForTeamA(viewModel.scoreTeamA)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun displayForTeamA(value: Int) {
        binding.fMainValueTeamATextView.text = value.toString()
    }


}