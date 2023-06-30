package com.example.mmobomb.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mmobomb.R
import com.example.mmobomb.base.view.BaseGameFragment
import com.example.mmobomb.base.view.viewBinding
import com.example.mmobomb.databinding.FragmentCategoriesBinding
import com.example.mmobomb.presentation.adapter.CategoryListAdapter
import com.example.mmobomb.presentation.adapter.CategoryLoadStateAdapter
import com.example.mmobomb.presentation.view.GameDetailFragment.Companion.GAME_ID_KEY
import com.example.mmobomb.presentation.viewmodel.GamesListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesListFragment : BaseGameFragment(R.layout.fragment_categories) {

    override val viewModel by viewModel<GamesListViewModel>()
    private val binding by viewBinding(FragmentCategoriesBinding::bind)

    private val adapter = CategoryListAdapter(
        onGameClick = { startGameDetailScreen(it) },
        onSeeAllClick = { Log.d(GamesListFragment::class.java.name, it) }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
    }

    override fun reloadInfo() {
        adapter.refresh()
    }

    private fun initView() = with(binding) {
        categoryRecyclerView.adapter = adapter.withLoadStateFooter(footer = CategoryLoadStateAdapter())
        banner.title.text = resources.getText(R.string.banner_title)
        banner.text.text = resources.getText(R.string.banner_text)
    }

    private fun initObserver() = with(viewModel) {
        lifecycleScope.launch {
            gamesList.collectLatest { adapter.submitData(it) }
        }
    }

    private fun startGameDetailScreen(gameId: Int) {
        findNavController().navigate(
            R.id.action_gamesListFragment_to_gameDetailFragment,
            bundleOf(GAME_ID_KEY to gameId)
        )
    }
}