package com.example.coronacounter.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.lite.R
import com.example.coronacounter.adapter.ShopItemAdapter
import org.tensorflow.lite.examples.detection.databinding.FragmentLoginPageBinding
import org.tensorflow.lite.examples.detection.databinding.FragmentMyPageBinding
import com.example.coronacounter.viewModel.AppViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [MyPage.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val TAG = "MyPageFragment"
class MyPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private var _context : Context? = null
    private val mycontext get() = _context!!

    private val sharedViewModel: AppViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val view = binding.root
        _context = container?.context
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView:RecyclerView = binding.userShopList
        recyclerView.adapter = ShopItemAdapter(mycontext, sharedViewModel.getShops(sharedViewModel.user))
        recyclerView.setHasFixedSize(true)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyPage().apply {
                arguments = Bundle().apply {

                }
            }
    }
}