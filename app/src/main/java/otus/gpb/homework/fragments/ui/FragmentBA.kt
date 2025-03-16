package otus.gpb.homework.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.ui.FragmentA.Companion.SHOW_FRAGMENT_AB

private const val COLOR = "color"

class FragmentBA : Fragment() {
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
        val rootView = inflater.inflate(R.layout.fragment_ba, container, false)
        rootView.findViewById<Button>(R.id.buttonOpenBB)?.let { button ->
            button.setOnClickListener {
                createFragmentBB()
                button.visibility = View.GONE
            }
        }
        return rootView
    }

    private fun createFragmentBB(){
        val fragmentBB = FragmentBB.newInstance()
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentBB, "fragmentBB")
            .addToBackStack("fragmentBB")
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(FragmentBB.SEND_COLOR, this) { _, bundle ->
            val color = bundle.getInt(FragmentBB.COLOR)
            view.background = color.toDrawable()
        }
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