package uz.kattabozor.task.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.kattabozor.task.databinding.ItemMainBinding
import uz.kattabozor.task.presentation.model.offer.UIOfferChildModel

class MainAdapter(
    private val itemClick: (uiData: UIOfferChildModel) -> Unit
) : ListAdapter<UIOfferChildModel, MainAdapter.MainVH>(diffUtil) {

    inner class MainVH(
        private val binding: ItemMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uiData: UIOfferChildModel) {
            with(binding) {
                ivContent.load(uiData.uiImageModel.url)
                tvContent.text = uiData.name
                root.setOnClickListener {
                    itemClick.invoke(uiData)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainVH(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<UIOfferChildModel>() {
            override fun areItemsTheSame(
                oldItem: UIOfferChildModel, newItem: UIOfferChildModel
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UIOfferChildModel, newItem: UIOfferChildModel
            ) = oldItem == newItem
        }
    }
}