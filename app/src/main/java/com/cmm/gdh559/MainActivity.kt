package com.cmm.gdh559

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val moviePoster: ImageView = findViewById(R.id.moviePoster)

        moviePoster.setOnClickListener {
            val intent = Intent(this, MainWatchingRunRun::class.java)
            startActivity(intent)
        }

        val moviePoster1: ImageView = findViewById(R.id.moviePoster1)

        moviePoster1.setOnClickListener {
            val intent = Intent(this, MainWatchingLahnma::class.java)
            startActivity(intent)
        }

        val moviePoster2: ImageView = findViewById(R.id.moviePoster2)

        moviePoster2.setOnClickListener {
            val intent = Intent(this, MainWatchingWimarnNarm::class.java)
            startActivity(intent)
        }

        val moviePoster3: ImageView = findViewById(R.id.moviePoster3)

        moviePoster3.setOnClickListener {
            val intent = Intent(this, MainWatchingNotFriends::class.java)
            startActivity(intent)
        }

        val moviePoster4: ImageView = findViewById(R.id.moviePoster4)

        moviePoster4.setOnClickListener {
            val intent = Intent(this, MainWatchingHomeForRent::class.java)
            startActivity(intent)
        }

        val moviePoster5: ImageView = findViewById(R.id.moviePoster5)

        moviePoster5.setOnClickListener {
            val intent = Intent(this, MainWatchingRaegYam::class.java)
            startActivity(intent)
        }

        val recommendedMoviePoster1: ImageView = findViewById(R.id.recommendedMoviePoster1)

        recommendedMoviePoster1.setOnClickListener {
            val intent = Intent(this, MainWatchingBadGenius::class.java)
            startActivity(intent)
        }

        val recommendedMoviePoster2: ImageView = findViewById(R.id.recommendedMoviePoster2)

        recommendedMoviePoster2.setOnClickListener {
            val intent = Intent(this, MainWatchingBro::class.java)
            startActivity(intent)
        }

        val recommendedMoviePoster3: ImageView = findViewById(R.id.recommendedMoviePoster3)

        recommendedMoviePoster3.setOnClickListener {
            val intent = Intent(this, MainWatchingFanday::class.java)
            startActivity(intent)
        }

        val recommendedMoviePoster4: ImageView = findViewById(R.id.recommendedMoviePoster4)

        recommendedMoviePoster4.setOnClickListener {
            val intent = Intent(this, MainWatchingConheartist::class.java)
            startActivity(intent)
        }

        val recommendedMoviePoster5: ImageView = findViewById(R.id.recommendedMoviePoster5)

        recommendedMoviePoster5.setOnClickListener {
            val intent = Intent(this, MainWatchingTheMedium::class.java)
            startActivity(intent)
        }

        val fantasyMoviePoster1: ImageView = findViewById(R.id.fantasyMoviePoster1)

        fantasyMoviePoster1.setOnClickListener {
            val intent = Intent(this, MainWatchingTheMedium::class.java)
            startActivity(intent)
        }

        val fantasyMoviePoster2: ImageView = findViewById(R.id.fantasyMoviePoster2)

        fantasyMoviePoster2.setOnClickListener {
            val intent = Intent(this, MainWatchingHomeForRent::class.java)
            startActivity(intent)
        }

        val fantasyMoviePoster3: ImageView = findViewById(R.id.fantasyMoviePoster3)

        fantasyMoviePoster3.setOnClickListener {
            val intent = Intent(this, MainWatchingRunRun::class.java)
            startActivity(intent)
        }

        val fantasyMoviePoster4: ImageView = findViewById(R.id.fantasyMoviePoster4)

        fantasyMoviePoster4.setOnClickListener {
            val intent = Intent(this, MainWatchingHomestay::class.java)
            startActivity(intent)
        }

        val fantasyMoviePoster5: ImageView = findViewById(R.id.fantasyMoviePoster5)

        fantasyMoviePoster5.setOnClickListener {
            val intent = Intent(this, MainWatchingDestiny::class.java)
            startActivity(intent)
        }

        val watchButton: Button = findViewById(R.id.watchButton)

        watchButton.setOnClickListener {
            val intent = Intent(this, MainWatchingRunRun::class.java)
            startActivity(intent)
        }

        val comingButton: ImageButton = findViewById(R.id.comingButton)

        comingButton.setOnClickListener {
            val intent = Intent(this, MainComingSoon::class.java)
            startActivity(intent)
        }

        val aboutButton: ImageButton = findViewById(R.id.aboutButton)

        aboutButton.setOnClickListener {
            val intent = Intent(this, MainAbout::class.java)
            startActivity(intent)
        }

    }
}