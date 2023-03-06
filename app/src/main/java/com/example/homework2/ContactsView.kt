import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2.Person

class ContactsView : ViewModel() {

    private val contacts = mutableListOf<Person>()

    fun addContact(contact: Person) {
        contacts.add(contact)
    }

    fun getContacts(): List<Person> {
        return contacts.toList()
    }
}
