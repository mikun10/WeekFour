package com.example.fragmentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView



class MyListAdapter(private val listdata: MutableList<MyListData>) :
    RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.itemlayout, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val myListData = listdata!![position]
        holder.textView.text = listdata[position].description
        holder.imageView.setImageResource(listdata[position].imgId)
        holder.textView1.text = listdata[position].email
        holder.textView2.text = listdata[position].radioGroup
        holder.time.text = listdata[position].time



        holder.del.setOnClickListener {view ->
            val builder1 = AlertDialog.Builder(view.context)
            builder1.setMessage("Are you sure to logout?")
            builder1.setCancelable(true)
            builder1.setPositiveButton("Yes"){dialogInterface, which ->
                listdata.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,listdata.size)
            }
            //performing cancel action
            builder1.setNeutralButton("Cancel"){dialogInterface , which ->

            }
            //performing negative action

            val alert11 = builder1.create()
            alert11.show()
            true


        }



        holder.imageView.setOnClickListener { view ->
//                val intent = Intent(view.context, Profilefragment::class.java)
//            intent.putExtra("name",myListData.description);
//            intent.putExtra("img",myListData.imgId);
//            intent.putExtra("email",myListData.email);
//            intent.putExtra("gender",myListData.radioGroup);
//            intent.putExtra("time",myListData.time);
//
//            intent.putExtra("pos",position)
//             view.context.startActivity(intent)





            val activity = view.context as AppCompatActivity
            val fragmentManager: FragmentManager =
                activity.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val NAME = profilefragment()
            fragmentTransaction.replace(R.id.details_fragment, NAME)
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }

    interface FragmentCommunication {
        fun respond(position: Int, name: String?, job: String?)
    }


    override fun getItemCount(): Int {
        return listdata!!.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView1: TextView
        var textView2: TextView
        var textView: TextView
        var time:TextView
        var del:ImageButton
        var relativeLayout: RelativeLayout

        init {
            del = itemView.findViewById<View>(R.id.Delete) as ImageButton
            imageView = itemView.findViewById<View>(R.id.item_image) as ImageView
            textView = itemView.findViewById<View>(R.id.item_title) as TextView
            textView1 = itemView.findViewById<View>(R.id.item_detail) as TextView
            textView2 = itemView.findViewById<View>(R.id.item_detail2) as TextView
            time = itemView.findViewById<View>(R.id.time) as TextView
            relativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as RelativeLayout

        }
    }


}