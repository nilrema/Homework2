package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider


class Fragment1 : Fragment() {

    private lateinit var viewModel : ContactsView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val returnValue = inflater.inflate(R.layout.fragment_p1, container, false)
        val nameText = returnValue?.findViewById<EditText>(R.id.name_edit_text)
        val lastnameText = returnValue?.findViewById<EditText>(R.id.last_name_edit_text)
        val ageText = returnValue?.findViewById<EditText>(R.id.age_edit_text)
        val oibText = returnValue?.findViewById<EditText>(R.id.oib_edit_text)

        viewModel = ViewModelProvider(requireActivity())[ContactsView::class.java]

        fun clear() {
            nameText?.text?.clear()
            lastnameText?.text?.clear()
            ageText?.text?.clear()
            oibText?.text?.clear()
        }

        returnValue?.findViewById<Button>(R.id.add_contact_button)?.setOnClickListener {
            val name = nameText?.text.toString()
            val lastname = lastnameText?.text.toString()
            val age = ageText?.text.toString().toInt()
            val oib = oibText?.text.toString()

            viewModel.addContact(Person(name, lastname, age, oib))
            clear()
        }

        return returnValue
    }
}