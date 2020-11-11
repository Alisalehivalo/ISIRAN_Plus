package ir.laitec.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler=findViewById<RecyclerView>(R.id.recycler)
        val recycler2=findViewById<RecyclerView>(R.id.recycler2)
        val list=generateList(100)
        val adapter=RecycleViewAdapter(list)
        recycler.adapter=adapter
        recycler.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,true)
        recycler.setHasFixedSize(true)
        recycler2.adapter=adapter
        recycler2.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,true)
        recycler2.setHasFixedSize(true)
    }

    fun generateList(size : Int) : List<ElementItems>{
        val myList=ArrayList<ElementItems>()
        for (i in 0 until size){
            val img=when(i % 4){
                0 -> R.drawable.alarm
                1 -> R.drawable.cut_24
               2 -> R.drawable.ic_baseline_account
                3 -> R.drawable.ic_baseline_assistant_24
                else -> R.drawable.ic_launcher_background

            }
            val title ="Item $i"
            val desc=when(i %3){
                0 -> "Mahdi Shirazi"
                1 -> "Seyed Sepehr Motevalian"
               2 -> "Younes Jamshidi"
                else -> "Unknown"
            }
            val items=ElementItems(img,title,desc)
            myList+=items
        }
        return myList
    }
}