package com.example.test.zip;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * zip 压缩
 */
public class ZipActivity extends AppCompatActivity {
    
    private TextView tvTest;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                Toast.makeText(ZipActivity.this, "压缩完成", Toast.LENGTH_SHORT).show();
            }
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);
        tvTest = findViewById(R.id.tv_test);
        
    }

    public void onTest1(View v) {
        String filePath = getExternalFilesDir(null).getAbsolutePath() + File.separator + "agorasdklog" + File.separator;
        File orgFile = new File(filePath);
        File destFile = new File(getExternalFilesDir(null).getAbsolutePath() + File.separator + "agorasdklog.zip");
        List<File> files = new ArrayList<>();
        files.add(orgFile);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ZipUtils.zipFiles(files, destFile);
                    mHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void onTest2(View v) {

    }
}
