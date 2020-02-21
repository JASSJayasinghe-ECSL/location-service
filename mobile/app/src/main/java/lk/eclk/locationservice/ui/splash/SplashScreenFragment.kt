package lk.eclk.locationservice.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import lk.eclk.locationservice.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class SplashScreenFragment : Fragment(),KodeinAware {
    override val kodein: Kodein by closestKodein()
    private lateinit var viewModel: SplashScreenViewModel
    private val viewModelFactory:SplashScreenViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SplashScreenViewModel::class.java)
        bindUI()
    }

    private fun bindUI() {
        viewModel.authState.observe(this, Observer {
            if(it == null) return@Observer

        })
    }
}
