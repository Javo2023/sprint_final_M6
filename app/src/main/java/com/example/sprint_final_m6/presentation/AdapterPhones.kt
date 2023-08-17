package com.example.sprint_final_m6.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
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

    fun setData(phones:List<PhoneEntity>){
        this.listItemPhones.clear()
        this.listItemPhones.addAll(phones)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemPhonesViewHolder, position: Int) {
        val telephone= listItemPhones[position]
        holder.bind(telephone)
    }

    class ItemPhonesViewHolder(val bindingPhone: ItemPhonesBinding):RecyclerView.ViewHolder(bindingPhone.root) {
        fun bind(phoneVista:PhoneEntity){
            bindingPhone.tvName.text = phoneVista.name
            bindingPhone.tvId.text=phoneVista.id.toString()
            bindingPhone.tvPrice.text = phoneVista.price.toString()
            bindingPhone.imageView.load(phoneVista.image)
            bindingPhone.cardViewItem.setOnClickListener(View.OnClickListener {

            })
        }

    }
}