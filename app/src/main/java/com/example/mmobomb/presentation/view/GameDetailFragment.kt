package com.example.mmobomb.presentation.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import coil.load
import com.example.mmobomb.R
import com.example.mmobomb.R.dimen
import com.example.mmobomb.base.view.BaseGameFragment
import com.example.mmobomb.base.view.viewBinding
import com.example.mmobomb.databinding.FragmentGameDetailBinding
import com.example.mmobomb.domain.model.GameDetailInfo
import com.example.mmobomb.presentation.adapter.ScreenshotImagesAdapter
import com.example.mmobomb.presentation.utils.GameItemDecorator
import com.example.mmobomb.presentation.viewmodel.GameDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : BaseGameFragment(R.layout.fragment_game_detail) {

    override val viewModel by viewModel<GameDetailViewModel>()

    private val binding by viewBinding(FragmentGameDetailBinding::bind)
    private val itemDecoration = GameItemDecorator(dimen.size_normal_medium)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        reloadInfo()
    }

    override fun reloadInfo() {
        arguments?.getInt(GAME_ID_KEY)?.let { viewModel.getGameInfo(it) }
    }

    private fun initObserver() = with(viewModel) {
        gameInfo.observe(viewLifecycleOwner) { initView(it) }
    }

    private fun initView(game: GameDetailInfo) = with(binding) {
        if (game.screenshots.isNotEmpty()) {
            screenshotText.isVisible = true
            screenshotRecycleView.addItemDecoration(itemDecoration)
            screenshotRecycleView.adapter = ScreenshotImagesAdapter(game.screenshots)
        }
        platform.text = resources.getString(R.string.platform_text).format(game.platform)
        developer.text = resources.getString(R.string.developer_text).format(game.developer)
        genre.text = resources.getString(R.string.genre_text).format(game.genre)
        releaseDate.text = resources.getString(R.string.release_date_text).format(game.releaseDate)
        description.text = resources.getString(R.string.description_text).format(game.shortDescription)
        gameName.text = game.title
        gameImage.load(game.thumbnail)
    }

    companion object {

        const val GAME_ID_KEY = "gameId"
    }
}