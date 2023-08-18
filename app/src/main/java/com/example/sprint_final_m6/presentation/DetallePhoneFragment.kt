package com.example.sprint_final_m6.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.sprint_final_m6.R
import com.example.sprint_final_m6.databinding.FragmentDetallePhoneBinding


private var ARG_PARAM1 = "id"


class DetallePhoneFragment : Fragment() {

    lateinit var binding: FragmentDetallePhoneBinding

    private val phoneVM: PhoneVM by activityViewModels()


    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetallePhoneBinding.inflate(layoutInflater, container, false)
        phoneVM.getDetailPhoneVM(param1.toString())
        getDetailPhone()

        binding.btnMessage.setOnClickListener(View.OnClickListener {
            sendEmail("Nokia","id")
        })

        return binding.root


    }

    private fun sendEmail(name: String, id: String) {
        val emailSubject = "Consulta $name id $id"
        val emailMessage =
            "Hola,\n\nVi el teléfono $name de código $id y me gustaría que me contactaran a este correo o al siguiente número.\n\nQuedo atento."

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:info@novaera.cl")
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage)




        startActivity(intent)



    }

    private fun getDetailPhone() {
        phoneVM.detailLiveData(param1.toString()).observe(viewLifecycleOwner) {
            if (it != null) {

                binding.tvSku.text = "sku" + it.id.toString()
                binding.tvNameDetail.text =  it.name
                binding.tvPriceDetail.text = "Ahora " + it.price.toString()
                binding.tvLastPrice.text = "Antes " + it.lastPrice.toString()
                binding.tvDescription.text = it.description
                binding.imageDetail.load(it.image)


                if (it.credit) {
                    binding.tvCreditCard.text ="Acepta crédito"

                } else {
                    binding.tvCreditCard.text ="Solo efectivo"


                }


            }

        }



    }



}