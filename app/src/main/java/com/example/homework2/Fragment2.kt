package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class Fragment2 : Fragment() {

    private lateinit var viewModel: ContactsView
    private lateinit var contactsList: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val returnValue = inflater.inflate(R.layout.fragment_p2, container, false)
        contactsList = returnValue.findViewById(R.id.contacts)
        return returnValue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ContactsView::class.java]
        viewModel.contacts.observe(viewLifecycleOwner) { contacts ->
            updateContactsList(contacts)
        }
    }

    private fun updateContactsList(contacts: List<Person>) {
        contactsList.removeAllViews()
        for (contact in contacts) {
            val textView = TextView(requireContext())
            textView.text = buildString {
        append(contact.name)
        append(" ")
        append(contact.lastname)
        append(",")
        append(contact.age)
        append(",")
        append(contact.oib)
    }
            contactsList.addView(textView)
        }
    }
}


