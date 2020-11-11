package ir.laitec.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(val myList : List<ElementItems>) : RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtTitle=itemView.findViewById<TextView>(R.id.txtTitle)
        val imgRecycler=itemView.findViewById<ImageView>(R.id.imgRecyclerView)
        val txtDesc=itemView.findViewById<TextView>(R.id.txtDescription)
        val layout=itemView.findViewById<LinearLayout>(R.id.layout)
        init {
            layout.setOnClickListener {
                val position=adapterPosition
                Toast.makeText(itemView.context,"Item Number: "+position,Toast.LENGTH_LONG).show()
                val intent=Intent(itemView.context,MainActivity2::class.java)
                itemView.context.startActivity(intent)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler2_items,parent,false)
        val holder=RecycleViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
       val currentItem=myList[position]
        holder.imgRecycler.setImageResource(currentItem.img)
        holder.txtTitle.text=currentItem.title
        holder.txtDesc.text=currentItem.Desc
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}