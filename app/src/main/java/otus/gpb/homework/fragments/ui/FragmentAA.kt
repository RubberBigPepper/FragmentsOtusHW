package otus.gpb.homework.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import otus.gpb.homework.fragments.R
import androidx.core.graphics.drawable.toDrawable
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import otus.gpb.homework.fragments.ColorGenerator

private const val COLOR = "color"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAA : Fragment() {
    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_aa, container, false)
        rootView.background = color?.toDrawable()
        rootView.findViewById<Button>(R.id.buttonOpenAB).setOnClickListener{
            rootView.findViewById<Button>(R.id.buttonOpenAB).visibility = View.GONE
            setFragmentResult(FragmentA.SHOW_FRAGMENT_AB, bundleOf())
        }
        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(color: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }
    }
}