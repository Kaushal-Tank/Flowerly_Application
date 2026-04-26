package com.example.flowerlyshoppingapp.feature.dashboard.presentation.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flowerlyshoppingapp.databinding.FragmentHomePageBinding
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.ItemDecoration
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.adapter.ItemHomeAdapter
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.viewmodel.HomeViewModel

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: HomeViewModel
    lateinit var adapter: ItemHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        adapter = ItemHomeAdapter(emptyList())

        val spanCount = 2
        val spacing = dpToPx(12)
        binding.products.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.products.addItemDecoration(ItemDecoration(spanCount, spacing, true))
        binding.products.adapter = adapter

        observeData()

        viewModel.loadItems()
    }

    fun observeData() {
        viewModel.items.observe(viewLifecycleOwner) { list ->
            adapter.updateList(list)
        }
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}