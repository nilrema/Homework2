import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2.*
import com.example.homework2.databinding.FragmentP2Binding

class Fragment2 : Fragment(){

    private lateinit var viewModel: GarageView
    private lateinit var carsList: RecyclerView
    private lateinit var adapter: GarageRecyclerAdapter
    private lateinit var binding: FragmentP2Binding

    interface OnCarClickListener {
        fun onCarClick(position: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentP2Binding.inflate(inflater, container, false)
        carsList = binding.garage

        adapter = GarageRecyclerAdapter(requireContext(), ArrayList())
        carsList.adapter = adapter
        carsList.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireActivity())[GarageView::class.java]
        viewModel.garageLiveData.observe(viewLifecycleOwner) { cars ->
            updateCarsList(cars)
        }

        updateCarsList(viewModel.garageLiveData.value ?: listOf())


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onResume() {
        super.onResume()
        requireActivity().title = getString(R.string.garage)
        activity?.window?.insetsController?.apply {
            setSystemBarsAppearance(
                0,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        }
    }

    private fun updateCarsList(garage: List<Car>) {
        adapter.carsList.clear()
        adapter.carsList.addAll(garage)
        adapter.notifyDataSetChanged()
    }


}
