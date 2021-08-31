package com.example.fragmentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_recyclerview.*


class RecyclerviewFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyListAdapter.ViewHolder>? = null
    var list: ArrayList<MyListData>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recyclerview, container, false)

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply {

            list = ArrayList<MyListData>()
            val sharedPreferences = requireActivity()!!.getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val  gson = Gson()
            editor.putString("courses", null)
            editor.apply()
            layoutManager = LinearLayoutManager(activity)
            (list as ArrayList<MyListData>).add(
                MyListData(
                    R.drawable.download,
                    "email",
                    "name",
                    "gender",
                    "time"
                )
            )
            adapter = MyListAdapter(list as ArrayList<MyListData>)












        }


    }

}