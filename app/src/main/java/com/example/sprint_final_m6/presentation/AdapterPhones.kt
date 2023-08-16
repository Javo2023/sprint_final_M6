package com.example.sprint_final_m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint_final_m6.data.local.PhoneEntity
import com.example.sprint_final_m6.databinding.FragmentListPhoneBinding
import com.example.sprint_final_m6.databinding.ItemPhonesBinding

class AdapterPhones: RecyclerView.Adapter<AdapterPhones.ItemPhonesViewHolder>(){
    lateinit var binding: ItemPhonesBinding
    private val listItemPhones = mutableListOf<PhoneEntity>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPhonesViewHolder {
        binding = ItemPhonesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemPhonesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemPhones.size
    }

    override fun onBindViewHolder(holder: ItemPhonesViewHolder, position: Int) {
        val telephone= listItemPhones[position]
        holder.bind(telephone)
    }



    class ItemPhonesViewHolder(val bindingPhone: ItemPhonesBinding):RecyclerView.ViewHolder(bindingPhone.root) {
        fun bind(phoneVista:PhoneEntity){
            bindingPhone.tvName.text = phoneVista.phone
        }

    }
}