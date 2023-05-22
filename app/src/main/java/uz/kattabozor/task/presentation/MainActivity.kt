package uz.kattabozor.task.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.kattabozor.task.databinding.ActivityMainBinding
import uz.kattabozor.task.presentation.model.offer.UIOfferChildModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    private val mainAdapter by lazy { MainAdapter(::onItemClick) }
    private lateinit var binding: ActivityMainBinding

    private fun onItemClick(uiData: UIOfferChildModel) {
        Toast.makeText(this, "$uiData", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRV()

        vm.getOffers()

        vm.offers.onEach(::offerUIState).launchIn(lifecycleScope)
    }

    private fun initRV() {
        binding.rv.adapter = mainAdapter
    }

    private fun offerUIState(uiState: UIState) = with(binding) {
        when (uiState) {
            is UIState.Error -> {
                progressBar.isVisible = false
            }

            UIState.Loading -> {
                progressBar.isVisible = true
            }

            is UIState.Success -> {
                progressBar.isVisible = false
                mainAdapter.submitList(uiState.uiData.uiOfferChildModels)
            }
        }
    }
}