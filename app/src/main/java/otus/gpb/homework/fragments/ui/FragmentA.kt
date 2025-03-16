package otus.gpb.homework.fragments.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import androidx.fragment.app.setFragmentResultListener

class FragmentA : Fragment() {

    private lateinit var openButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_a, container, false)
        openButton = rootView.findViewById(R.id.buttonOpenAA)
        rootView.findViewById<Button>(R.id.buttonOpenAA).setOnClickListener {
            val color = ColorGenerator.generateColor()
            val fragmentAA = FragmentAA.newInstance(color)
            childFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentAA, "fragmentAA")
                .addToBackStack("fragmentAA")
                .commit()
            openButton.visibility = View.GONE
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    if (childFragmentManager.backStackEntryCount == 1)
                        openButton.visibility = View.VISIBLE
                } else {
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(SHOW_FRAGMENT_AB) { _, _ ->
            val color = ColorGenerator.generateColor()
            val fragmentAB = FragmentAB.newInstance(color)
            childFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentAB, "fragmentAB")
                .addToBackStack("fragmentAB")
                .commit()
            openButton.visibility = View.GONE
        }
    }


    companion object{
        const val SHOW_FRAGMENT_AB = "show fragmentAB"
    }
}