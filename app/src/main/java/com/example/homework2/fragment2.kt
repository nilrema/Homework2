package com.example.homework2

import ContactsView
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class fragment2 : Fragment() {

    lateinit var viewModel : ContactsView
    lateinit var contactsLayout: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*viewModel = ViewModelProvider(requireActivity()).get(ContactsView::class.java)
        contactsLayout = view?.findViewById(R.id.contacts)!!

        for (contact in viewModel.getContacts()) {
            val contactTextView = TextView(requireContext())
            contactTextView.text = "Name: ${contact.name} ${contact.lastname} PIN: ${contact.oib} Age: ${contact.age}"
            contactsLayout.addView(contactTextView)
        }*/


        return inflater.inflate(R.layout.fragment_p2, container, false)
    }
}