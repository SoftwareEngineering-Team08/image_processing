package org.tensorflow.lite.examples.detection.coronaCounter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.coronacounter.viewModel.AppViewModel
import org.tensorflow.lite.examples.detection.R
import org.tensorflow.lite.examples.detection.databinding.FragmentDistanceStageBinding
import org.tensorflow.lite.examples.detection.databinding.FragmentStatisticPageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "DistanceStage"
/**
 * A simple [Fragment] subclass.
 * Use the [DistanceStage.newInstance] factory method to
 * create an instance of this fragment.
 */
class DistanceStage : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentDistanceStageBinding? = null
    private val binding get() = _binding!!
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
        _binding = FragmentDistanceStageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}