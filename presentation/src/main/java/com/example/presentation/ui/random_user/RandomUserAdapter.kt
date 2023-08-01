package com.example.presentation.ui.random_user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.remote.RandomUserResponse
import com.example.presentation.databinding.ItemRandomUserBinding


class RandomUserAdapter :
    RecyclerView.Adapter<RandomUserAdapter.ViewHolder>() {

    private var listOfCategories: List<RandomUserResponse> = arrayListOf()

    fun setData(lista: List<RandomUserResponse>) {
        listOfCategories = lista
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemRandomUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: RandomUserResponse) =
            with(binding) {

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRandomUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfCategories[position])
    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }


}
