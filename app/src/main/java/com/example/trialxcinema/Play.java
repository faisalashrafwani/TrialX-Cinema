package com.example.trialxcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Play extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        MediaController mediaController = new MediaController(this);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("https://rr7---sn-ci5gup-qxay.googlevideo.com/videoplayback?expire=1643634629&ei=ZYv3YfH5EonMvwTwiKjIDg&ip=122.173.134.203&id=o-AEw61k2HPEK1h-RZbA4nwqbQfYhKgdjMoQbIPbq6GWbd&itag=18&source=youtube&requiressl=yes&mh=zx&mm=31%2C26&mn=sn-ci5gup-qxay%2Csn-cvh76ney&ms=au%2Conr&mv=m&mvi=7&pl=25&initcwndbps=1246250&vprv=1&mime=video%2Fmp4&ns=6tt20fIXL_yA_dEOr2iyh1AG&cnr=14&ratebypass=yes&dur=14.187&lmt=1636540702509530&mt=1643612682&fvip=2&fexp=24001373%2C24007246&c=WEB&n=Ler8TOugKB_CdX7b2jc&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgCJFqHrKMgsLHOv0LpFBYLzxys82c06t2NiSvVla-5xoCIFJJmevQwgbhIRDJmLgiASmqtxaA0ytcTMulTIYqHvLW&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAPzE5x9eCLWHuJZPQQ0xq1FA8xnkOaBNCokAYUBN8jKXAiBVoFEu3CV79Bv5-0KFosmXmgiaTnVTCqIuY5qLOyDlWQ%3D%3D");

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

    }
}