package com.example.gmailapprecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import java.util.Locale


class MainActivity : ComponentActivity() {

    private val faker = Faker(Locale("en-GB"))
    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    @SuppressLint("InflateParams", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emails = mutableListOf<Email>()
        for (i in 1..20) {
            val email = Email(faker.name().fullName(), timeFormat.format(faker.date().birthday()), faker.lorem().sentence())
            emails.add(email)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emails)
    }
}