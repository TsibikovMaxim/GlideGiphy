package com.example.glidegiphy.ui.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.glidegiphy.R
import com.example.glidegiphy.databinding.FragmentDetailsBinding
import com.example.glidegiphy.databinding.FragmentMainBinding

class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    protected val binding get() = checkNotNull(_viewBinding)

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater, container, false)


        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            title.text = args.detailsData.title
            importDatetime.text = args.detailsData.import_datetime
            id.text = args.detailsData.id
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}