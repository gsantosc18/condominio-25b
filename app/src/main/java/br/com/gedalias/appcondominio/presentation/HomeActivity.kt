package br.com.gedalias.appcondominio.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import br.com.gedalias.appcondominio.R
import br.com.gedalias.appcondominio.adapter.HomeTabAdapter
import br.com.gedalias.appcondominio.presentation.fragment.InicioFragment
import br.com.gedalias.appcondominio.presentation.fragment.PagamentosFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    private var viewHomeTab: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tabLayout = findViewById(R.id.tabLayout)
        viewHomeTab = findViewById(R.id.view_home_tab)

        viewHomeTab!!.adapter = createHomeTabAbstract()
        tabLayout!!.addOnTabSelectedListener(actionOnSelectTab())
    }

    private fun actionOnSelectTab() = object:TabLayout.OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {
            viewHomeTab!!.currentItem = tab!!.position
        }
        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }

    private fun createHomeTabAbstract(): HomeTabAdapter {
        val homeTabAdapter = HomeTabAdapter(supportFragmentManager, lifecycle)
        homeTabAdapter.addFragment(InicioFragment())
        homeTabAdapter.addFragment(PagamentosFragment())
        return homeTabAdapter
    }
}