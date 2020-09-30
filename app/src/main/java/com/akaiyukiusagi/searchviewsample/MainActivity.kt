package com.akaiyukiusagi.searchviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var datasetArray: ArrayList<String> = arrayListOf() // 表示する内容

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        // 表示する内容を作成
        for (i in 1..1000) {
            datasetArray.add(i.toString())
        }
        val dataset = datasetArray.toList()

        showRecycler(dataset)

        search_view.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            // 文字編集時
            override fun onQueryTextSubmit(query: String?): Boolean {
                val filtered = dataset.filter { it.contains(query.toString()) }
                showRecycler(filtered)
                return true
            }
            // 検索ボタンクリック時
            override fun onQueryTextChange(newText: String?): Boolean {
                val filtered = dataset.filter { it.contains(newText.toString()) }
                showRecycler(filtered)
                return true
            }
        })
    }

    // RecyclerView を dataset の内容で表示する
    private fun showRecycler(dataset: List<String>) {
        viewAdapter = Adapter(dataset)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}
