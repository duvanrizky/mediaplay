package com.example.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button playBtn, pauseBtn;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.idBtnPlay);
        pauseBtn = findViewById(R.id.idBtnPause);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling method to play audio.
                playAudio();
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();

                    Toast.makeText(MainActivity.this, "Audio has been paused", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this, "Audio has not played", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void playAudio() {

        String audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

        mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
    }
}
