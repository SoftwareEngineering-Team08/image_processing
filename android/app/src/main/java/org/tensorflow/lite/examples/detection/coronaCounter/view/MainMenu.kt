package com.example.coronacounter.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import org.tensorflow.lite.examples.detection.databinding.FragmentLoginPageBinding
import org.tensorflow.lite.examples.detection.databinding.FragmentMainMenuBinding
import com.example.coronacounter.model.User
import com.example.coronacounter.viewModel.AppViewModel
import org.tensorflow.lite.examples.detection.imageProcessor.IPActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MainMenu.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val TAG = "MainMenuFragment"
class MainMenu : Fragment() {
    private lateinit var user: User
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: AppViewModel by activityViewModels()

    private lateinit var toCheckPeopleButton: Button
    private lateinit var toMyPageButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toCheckPeopleButton = binding.checkPeopleButton
        toCheckPeopleButton.setOnClickListener {
            val intent = Intent(getActivity(), IPActivity::class.java)
            startActivity(intent)
            Log.d(TAG, "to checkPeople button clicked")
        }


        toMyPageButton = binding.myPageButton
        toMyPageButton.setOnClickListener {
            val action = MainMenuDirections.actionMainMenuToMyPage()
            view.findNavController().navigate(action)
            Log.d(TAG,"to myPage button clicked")
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainMenu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                MainMenu().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}