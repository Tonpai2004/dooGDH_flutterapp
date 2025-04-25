package com.cmm.gdh559

import android.view.Window
import android.view.WindowManager
import android.widget.VideoView
import android.widget.ImageButton
import android.widget.Button
import android.widget.MediaController
import android.widget.RelativeLayout
import android.view.View
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainWatchingBadGenius : AppCompatActivity() {

    private var isFullScreen = false // ใช้เพื่อเช็คสถานะของโหมดเต็มหน้าจอ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watching_badgenius)

        // ปุ่มย้อนกลับ
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        // วิดีโอ
        val videoView = findViewById<VideoView>(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // URI ของวิดีโอ
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.gdh_video}")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()

        // ปุ่ม "รับชมภาพยนตร์"
        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            // ซ่อน UI ส่วนที่ไม่ต้องการแสดงในโหมดเต็มหน้าจอ
            findViewById<TextView>(R.id.movieTitle).visibility = View.GONE
            findViewById<TextView>(R.id.movieDescription).visibility = View.GONE
            findViewById<TextView>(R.id.toggleReadMore).visibility = View.GONE
            findViewById<TextView>(R.id.messageText).visibility = View.GONE
            findViewById<TextView>(R.id.castAndDirectorTitle).visibility = View.GONE
            findViewById<HorizontalScrollView>(R.id.castAndDirectorScrollView).visibility = View.GONE

            // เล่นวิดีโอและเข้าสู่โหมดเต็มหน้าจอ
            videoView.start()
            findViewById<Button>(R.id.playButton).visibility = View.GONE  // ซ่อนปุ่ม "รับชมภาพยนตร์"
            findViewById<ImageButton>(R.id.backButton).visibility = View.GONE // ซ่อนปุ่ม "ย้อนกลับ"

            // กำหนดให้พื้นที่ส่วนอื่นๆเป็นพื้นหลังสีดำ
            findViewById<ConstraintLayout>(R.id.watchingRoot).setBackgroundColor(resources.getColor(android.R.color.black))

            // ปรับขนาดวิดีโอและตำแหน่งให้เป็นกึ่งกลาง
            val videoParams = videoView.layoutParams
            videoParams.width = RelativeLayout.LayoutParams.MATCH_PARENT
            videoParams.height = RelativeLayout.LayoutParams.MATCH_PARENT
            videoView.layoutParams = videoParams

            // เรียกใช้ฟังก์ชันการเข้าสู่โหมดเต็มหน้าจอ
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

            // แสดงปุ่มออกจากโหมดเต็มหน้าจอ
            findViewById<ImageButton>(R.id.exitFullScreenButton).visibility = View.VISIBLE
            isFullScreen = true
        }

        // ปุ่มออกจากโหมดเต็มจอ
        val exitFullScreenButton = findViewById<ImageButton>(R.id.exitFullScreenButton)
        exitFullScreenButton.setOnClickListener {
            // กลับสู่โหมดปกติ
            findViewById<ConstraintLayout>(R.id.watchingRoot).setBackgroundColor(resources.getColor(android.R.color.white))

            // ปรับขนาดและตำแหน่งของวิดีโอ
            val videoParams = videoView.layoutParams
            videoParams.width = RelativeLayout.LayoutParams.MATCH_PARENT
            videoParams.height = 650 // ความสูงตามเดิม
            videoView.layoutParams = videoParams

            // ซ่อนปุ่มออกจากโหมดเต็มจอ
            exitFullScreenButton.visibility = View.GONE
            isFullScreen = false

            // แสดงส่วน UI ที่ถูกซ่อนไว้
            findViewById<TextView>(R.id.movieTitle).visibility = View.VISIBLE
            findViewById<TextView>(R.id.movieDescription).visibility = View.VISIBLE
            findViewById<TextView>(R.id.toggleReadMore).visibility = View.VISIBLE
            findViewById<TextView>(R.id.messageText).visibility = View.VISIBLE
            findViewById<TextView>(R.id.castAndDirectorTitle).visibility = View.VISIBLE
            findViewById<HorizontalScrollView>(R.id.castAndDirectorScrollView).visibility = View.VISIBLE

            // แสดงปุ่ม "รับชมภาพยนตร์" และ "ย้อนกลับ"
            findViewById<Button>(R.id.playButton).visibility = View.VISIBLE
            findViewById<ImageButton>(R.id.backButton).visibility = View.VISIBLE

            // ปิดโหมดเต็มหน้าจอ
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        var isExpanded = false

        val movieDescription = findViewById<TextView>(R.id.movieDescription)
        val toggleReadMore = findViewById<TextView>(R.id.toggleReadMore)

        // ปุ่ม "อ่านเพิ่มเติม" สำหรับแสดง/ซ่อนข้อความ
        toggleReadMore.setOnClickListener {
            if (isExpanded) {
                // ย่อข้อความ
                movieDescription.maxLines = 3
                movieDescription.ellipsize = TextUtils.TruncateAt.END
                toggleReadMore.text = "อ่านเพิ่มเติม"
                isExpanded = false
            } else {
                // แสดงข้อความทั้งหมด
                movieDescription.maxLines = Integer.MAX_VALUE
                movieDescription.ellipsize = null
                toggleReadMore.text = "ซ่อน"
                isExpanded = true
            }

            // ตรวจสอบให้แน่ใจว่า VideoView ยังคงขนาดเดิม
            val videoView = findViewById<VideoView>(R.id.videoView)
            val videoParams = videoView.layoutParams
            videoParams.width = RelativeLayout.LayoutParams.MATCH_PARENT
            videoParams.height = 650 // กำหนดความสูงของ VideoView ตามที่ต้องการ
            videoView.layoutParams = videoParams


        }

    }
}
