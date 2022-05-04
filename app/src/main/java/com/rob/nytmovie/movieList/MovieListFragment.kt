package com.rob.nytmovie.movieList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rob.nytmovie.App
import kotlinx.coroutines.flow.collect
import com.rob.nytmovie.R
import com.rob.nytmovie.databinding.MovieListFragmentBinding
import com.rob.nytmovie.utils.BaseFragment
import javax.inject.Inject

class MovieListFragment : BaseFragment<MovieListFragmentBinding>(MovieListFragmentBinding::inflate) {

    @Inject
    lateinit var cityListViewModelFactory: MovieListViewModelFactory
    val viewModel: MovieListViewModel by viewModels { cityListViewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cityListViewModelFactory = (activity?.application as App).component.getDependencyMovieList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieList()

        lifecycleScope.launchWhenStarted {
            viewModel.movieList.collect {
                binding.text.text = it.results.first().headline.toString()
            }
        }

    }

}