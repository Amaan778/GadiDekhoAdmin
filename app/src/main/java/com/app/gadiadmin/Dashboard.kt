package com.app.gadiadmin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.gadiadmin.Categories.CreateCategories
import com.app.gadiadmin.bookings.BookingActivity
import com.app.gadiadmin.feed.FeedbackActivity
import com.app.gadiadmin.login.LoginDetaiks
import com.app.gadiadmin.manageservice.ManageService
import com.app.gadiadmin.notification.CreateNotification
import com.app.gadiadmin.sliderimage.SliderImage

class Dashboard : AppCompatActivity() {
    private lateinit var category:TextView
    private lateinit var manageservice:TextView
    private lateinit var slider:TextView
    private lateinit var notification:TextView
    private lateinit var loginDetail:TextView
    private lateinit var booking:TextView
    private lateinit var feed:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        category=findViewById(R.id.category)
        manageservice=findViewById(R.id.manageallservice)
        slider=findViewById(R.id.slider)
        notification=findViewById(R.id.notification)
        loginDetail=findViewById(R.id.login)
        booking=findViewById(R.id.bookings)
        feed=findViewById(R.id.feedback)

        category.setOnClickListener {
            startActivity(Intent(this,CreateCategories::class.java))
        }

        manageservice.setOnClickListener {
            startActivity(Intent(this,ManageService::class.java))
        }

        slider.setOnClickListener {
            startActivity(Intent(this,SliderImage::class.java))
        }

        notification.setOnClickListener {
            startActivity(Intent(this,CreateNotification::class.java))
        }

        feed.setOnClickListener {
            startActivity(Intent(this,FeedbackActivity::class.java))
        }

        loginDetail.setOnClickListener {
            startActivity(Intent(this,LoginDetaiks::class.java))
        }

        booking.setOnClickListener {
            startActivity(Intent(this,BookingActivity::class.java))
        }

    }
}