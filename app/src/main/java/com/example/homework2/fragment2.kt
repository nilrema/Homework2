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


/**
 * A simple [Fragment] subclass.
 * Use the [fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment2 : Fragment() {

    lateinit var viewModel : ContactsView
    lateinit var contactsLayout: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(ContactsView::class.java)
        contactsLayout = view?.findViewById(R.id.contacts)!!


        return inflater.inflate(R.layout.fragment_p2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.contacts.observe(viewLifecycleOwner) { contacts ->

            updateContactsList(contacts)
        }
    }

    private fun updateContactsList(contacts: List<Person>) {
        contactsLayout.removeAllViews()

        for (contact in contacts) {
            val contactView = TextView(requireContext())
            contactView.text = "${contact.name} ${contact.lastname}, PIN: ${contact.oib}, Age: ${contact.age}"
            contactsLayout.addView(contactView)
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment p2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment2().apply {
                arguments = Bundle().apply {

                }
            }
    }
}