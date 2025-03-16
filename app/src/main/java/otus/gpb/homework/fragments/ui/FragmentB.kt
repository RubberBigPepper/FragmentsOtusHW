package otus.gpb.homework.fragments.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_b, container, false)
        rootView.findViewById<View>(R.id.container)?.let {
            createFragmentBA(it.id)
        }
        rootView.findViewById<View>(R.id.containerLeft)?.let {
            createFragmentBA(it.id)
        }
        rootView.findViewById<View>(R.id.containerRight)?.let {
            createFragmentBB(it.id)
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 1) {
                    childFragmentManager.popBackStack()
                } else {
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    private fun createFragmentBA(containerId: Int){
        val fragmentBA = FragmentBA()
        childFragmentManager.beginTransaction()
            .replace(containerId, fragmentBA, "fragmentBA")
            .addToBackStack("fragmentBA")
            .commit()
    }

    private fun createFragmentBB(containerId: Int){
        val fragmentBB = FragmentBB()
        childFragmentManager.beginTransaction()
            .replace(containerId, fragmentBB, "fragmentBB")
            .commit()
    }
}