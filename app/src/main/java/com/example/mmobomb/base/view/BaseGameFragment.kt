package com.example.mmobomb.base.view

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.mmobomb.base.viewmodel.BaseGameViewModel

abstract class BaseGameFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract val viewModel: BaseGameViewModel

    abstract fun reloadInfo()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        isLoading.observe(viewLifecycleOwner) { isLoading ->
            (activity as? ActivityStateProcessor)?.processLoading(isLoading)
        }
        errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            (activity as? ActivityStateProcessor)?.processError(errorMessage) {
                reloadInfo()
            }
        }
    }
}