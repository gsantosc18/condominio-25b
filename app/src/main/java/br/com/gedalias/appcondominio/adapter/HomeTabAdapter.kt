package br.com.gedalias.appcondominio.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    private var listFragments: List<Fragment> = mutableListOf()

    override fun getItemCount(): Int = listFragments.size

    override fun createFragment(position: Int): Fragment = listFragments[position]

    fun addFragment(fragment: Fragment) {
        listFragments += fragment
    }
}