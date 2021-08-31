package com.example.fragmentation



import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val activity = view.context as AppCompatActivity
            val fragmentManager: FragmentManager =
                activity.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val NAME =registration()
            fragmentTransaction.replace(R.id.details_fragment, NAME)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }








    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when (id) {
            R.id.item1 -> {

                val builder = AlertDialog.Builder(this)
                builder.setMessage("Are You sure to logout?")
                builder.setCancelable(true)
                builder.setPositiveButton("Yes"){dialogInterface, which ->
                    finish();
                }
                builder.setNegativeButton(
                    "No"
                ) { dialog, id -> dialog.cancel() }
                val alertss = builder.create()
                alertss.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

