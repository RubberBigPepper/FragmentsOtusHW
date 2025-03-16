package otus.gpb.homework.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_bb, container, false)
        rootView.findViewById<Button>(R.id.buttonSendColor).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                SEND_COLOR,
                bundleOf(COLOR to ColorGenerator.generateColor())
            )
        }
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentBB()

        const val SEND_COLOR = "sendColor"
        const val COLOR = "color"
    }
}