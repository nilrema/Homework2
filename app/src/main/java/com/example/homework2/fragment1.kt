package com.example.homework2

import ContactsView
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var viewModel : ContactsView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel = ViewModelProvider(requireActivity()).get(ContactsView::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val nameText = view?.findViewById<EditText>(R.id.name_edit_text)
        val lastnameText = view?.findViewById<EditText>(R.id.last_name_edit_text)
        val ageText = view?.findViewById<EditText>(R.id.age_edit_text)
        val oibText = view?.findViewById<EditText>(R.id.oib_edit_text)
        val addButton = view?.findViewById<Button>(R.id.add_contact_button)

        fun clear() {
            nameText?.text?.clear()
            lastnameText?.text?.clear()
            ageText?.text?.clear()
            oibText?.text?.clear()
        }

        if (addButton != null) {
            addButton.setOnClickListener {
                val name = nameText?.text.toString()
                val lastname = lastnameText?.text.toString()
                val age = ageText?.text.toString().toInt()
                val oib = oibText?.text.toString()

                viewModel.addContact(Person(name,lastname,age,oib))
                clear()
            }
        }

        return inflater.inflate(R.layout.fragment_p1, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment p1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}