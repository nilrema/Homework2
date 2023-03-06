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


class fragment1 : Fragment() {

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

        val returnval = inflater.inflate(R.layout.fragment_p1, container, false)
       /* val nameText = view?.findViewById<EditText>(R.id.name_edit_text)
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
        }*/

        return returnval
    }
}