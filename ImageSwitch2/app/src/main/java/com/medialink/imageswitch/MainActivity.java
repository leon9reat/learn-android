package com.medialink.imageswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button nextButton;
    int imageSwitcherImages[] = {R.drawable.gb1, R.drawable.gb2, R.drawable.gb3,
            R.drawable.gb4, R.drawable.gb5, R.drawable.gb6, R.drawable.gb7};
    int switcherImageLength = imageSwitcherImages.length;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
