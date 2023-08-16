package com.example.sprint_final_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sprint_final_m6.R
import com.example.sprint_final_m6.databinding.FragmentListPhoneBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListPhoneFragment : Fragment() {

    lateinit var binding: FragmentListPhoneBinding
    private val phoneVM: PhoneVM by activityViewModels()

    /* TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            /*
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            */
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListPhoneBinding.inflate(layoutInflater,container,false)
        initAdapterPhones()
        phoneVM.getAllTelephones()
        return binding.root

    }
    private fun initAdapterPhones(){
        val adapter = AdapterPhones()
        binding.recyclerView.adapter = adapter
        phoneVM.phoneLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }


    }



}