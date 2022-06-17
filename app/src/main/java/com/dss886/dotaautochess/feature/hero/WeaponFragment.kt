package com.dss886.dotaautochess.feature.hero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dss886.dotaautochess.R

/**
 * Created by wrf on 2022/6/17.
 */
class WeaponFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weapon, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val heroAdapter = AllWeaponAdapter()
        recyclerView.adapter = heroAdapter

        return view
    }

}
