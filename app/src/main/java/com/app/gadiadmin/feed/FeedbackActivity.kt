package com.app.gadiadmin.feed

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.gadiadmin.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FeedbackActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private var mList = ArrayList<FeedData>()
    private lateinit var adapter: FeedRecycler
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        recycler=findViewById(R.id.recyler)

        recycler.layoutManager= LinearLayoutManager(this)
        adapter=FeedRecycler(this,mList)
        recycler.adapter=adapter

        mList.clear()

        db = FirebaseFirestore.getInstance()
        db.collection("message").addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null) {
                    Log.e("firestore", error.message.toString())
                }

                for (dc: DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        mList.add(dc.document.toObject(FeedData::class.java))
                    }
                }

                adapter?.notifyDataSetChanged()
            }
        })

    }
}