package sg.edu.np.mad.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int stoppos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView = findViewById(R.id.videoMain);
        loadImg(R.mipmap.picturemain_foreground);
        loadVid(R.raw.ricky);
    }
    private void loadVid(int x){
        VideoView videoView = findViewById(R.id.videoMain);
        videoView.setVideoURI((Uri.parse("android.resource://"+getPackageName()+"/"+x)));
        videoView.start();
    }
    private void loadImg(int x){
        ImageView imageView = findViewById(R.id.profile);
        imageView.setImageResource(x);
    }
    @Override
    protected void onPause(){
        Log.v(TAG,"paused");
        VideoView videoView = findViewById(R.id.videoMain);
        stoppos = videoView.getCurrentPosition();
        videoView.pause();
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"resumed");
        VideoView videoView = findViewById(R.id.videoMain);
        videoView.seekTo(stoppos);
        videoView.start();
    }
}