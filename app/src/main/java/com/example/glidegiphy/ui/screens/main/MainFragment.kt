package com.example.glidegiphy.ui.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.glidegiphy.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _viewBinding: FragmentMainBinding? = null
    protected val binding get() = checkNotNull(_viewBinding)

    private val mainAdapter = MainAdapter()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMainBinding.inflate(inflater, container, false)


        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            if (savedInstanceState != null) {
                editCity.setText(viewModel.getTextToSearch())
                mainAdapter.submitList(viewModel.getPreloadedGifs())
            }

            recyclerView.adapter = mainAdapter

            btnSearch.setOnClickListener {

                val textToSearch = editCity.text.toString()

                if (textToSearch.isNotEmpty()) {
                    progressBar.visibility = View.VISIBLE
                    viewModel.setTextToSearch(textToSearch)
                    viewModel.gifs.observe(requireActivity()) { Object ->
                        mainAdapter.submitList(Object.data)
                        progressBar.visibility = View.GONE
                    }
                } else {
                    Toast.makeText(requireContext(), "Вы ничего не ввели", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}