package com.fredcodecrafts.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.creamcup),
            view.findViewById(R.id.matchaoverload)
        )

        coffeeList.forEach { coffee ->
            val fragmentBundle = Bundle()
            fragmentBundle.putInt(COFFEE_ID, coffee.id)
            coffee.setOnClickListener {
                coffee.findNavController().navigate(
                    R.id.action_listFragment_to_detailFragment, // ✅ FIXED
                    fragmentBundle
                )
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
