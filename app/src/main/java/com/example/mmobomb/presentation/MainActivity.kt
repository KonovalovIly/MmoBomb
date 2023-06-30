package com.example.mmobomb.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.mmobomb.R
import com.example.mmobomb.base.model.ConnectionStatus.AVAILABLE
import com.example.mmobomb.base.model.ConnectionStatus.LOSING
import com.example.mmobomb.base.model.ConnectionStatus.LOST
import com.example.mmobomb.base.model.ConnectionStatus.UNAVAILABLE
import com.example.mmobomb.base.view.ActivityStateProcessor
import com.example.mmobomb.base.view.BaseGameFragment
import com.example.mmobomb.presentation.utils.NetworkConnectivityObserver
import com.saadahmedsoft.popupdialog.PopupDialog
import com.saadahmedsoft.popupdialog.Styles.ANDROID_DEFAULT
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.lang.ref.WeakReference
import kotlin.LazyThreadSafetyMode.NONE

class MainActivity : AppCompatActivity(), ActivityStateProcessor {

    private val connectivityObserver by lazy(NONE) { NetworkConnectivityObserver(WeakReference(this)) }
    private val progressBar by lazy(NONE) { findViewById<ProgressBar>(R.id.progressBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeConnection()
    }

    override fun processLoading(state: Boolean) {
        progressBar.isVisible = state
    }

    override fun processError(message: String, onReloadPage: () -> Unit) {
        showPopup(
            header = resources.getString(R.string.error_header),
            description = resources.getString(R.string.error_description).format(message)
        ) {
            onReloadPage()
        }
    }

    private fun observeConnection() {
        if (!connectivityObserver.isConnected()) showInternetLost()

        connectivityObserver.observe().onEach { state ->
            when (state) {
                AVAILABLE -> {
                    createToast(resources.getString(R.string.internet_connection_available))
                    reloadInfo()
                }
                UNAVAILABLE -> createToast(resources.getString(R.string.internet_connection_unavailable))
                LOSING -> showInternetLost()
                LOST -> showInternetLost()
            }
        }.launchIn(lifecycleScope)
    }

    private fun createToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun reloadInfo() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        navHostFragment?.childFragmentManager?.fragments?.forEach { fragment ->
            (fragment as? BaseGameFragment)?.reloadInfo()
        }
    }

    private fun showInternetLost() {
        showPopup(
            header = resources.getString(R.string.internet_connection_header),
            description = resources.getString(R.string.internet_connection_description)
        ) {
            val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
            startActivity(intent)
        }
    }

    private fun showPopup(
        header: String,
        description: String,
        onPositivePage: () -> Unit
    ) {
        PopupDialog.getInstance(this)
            .setStyle(ANDROID_DEFAULT)
            .setDescription(description)
            .setNegativeButtonText(resources.getString(R.string.negative_popup))
            .setPositiveButtonText(resources.getString(R.string.positive_popup))
            .setHeading(header)
            .setCancelable(false)
            .showDialog(
                object : OnDialogButtonClickListener() {
                    override fun onPositiveClicked(dialog: Dialog?) {
                        super.onPositiveClicked(dialog)
                        onPositivePage()
                    }

                    override fun onNegativeClicked(dialog: Dialog?) {
                        super.onNegativeClicked(dialog)
                        finish()
                    }
                }
            )
    }
}