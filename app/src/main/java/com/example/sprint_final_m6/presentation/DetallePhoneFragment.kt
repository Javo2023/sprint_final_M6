package com.example.sprint_final_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.sprint_final_m6.R
import com.example.sprint_final_m6.databinding.FragmentDetallePhoneBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private  var ARG_PARAM1 = "id"
/*private const val ARG_PARAM2 = "name"
private const val ARG_PARAM3 = "price"
private const val ARG_PARAM4 = "image"

 */


class DetallePhoneFragment : Fragment() {

    lateinit var binding : FragmentDetallePhoneBinding

    private val phoneVM: PhoneVM by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    /*private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            /*param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)

             */
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallePhoneBinding.inflate(layoutInflater, container, false)
        phoneVM.getDetailPhoneVM(param1.toString())
        getDetailPhone()

       return binding.root
    }

    private fun getDetailPhone() {
        phoneVM.detailLiveData(param1.toString()).observe(viewLifecycleOwner) {
            if (it != null) {

                binding.tvSku.text = it.id.toString()
                binding.tvNameDetail.text = it.name
                binding.tvPriceDetail.text = it.price.toString()
                binding.tvLastPrice.text = it.lastPrice.toString()
                binding.tvDescription.text = it.description
                binding.imageDetail.load(it.image)


            }
        }

    }


}