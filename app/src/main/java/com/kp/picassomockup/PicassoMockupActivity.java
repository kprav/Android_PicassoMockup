package com.kp.picassomockup;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PicassoMockupActivity extends AppCompatActivity {

    private ImageView ivImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_mockup);
        ivImageView = (ImageView) findViewById(R.id.ivImageView);
        String url = "https://upload.wikimedia.org/wikipedia/commons/1/19/Eiffel_Tower_at_Night.jpg";
        PicassoMockup.load(url, new PicassoMockup.OnImageListener() {
            @Override
            public void onImageLoaded(Bitmap bitmap, int result) {
                if (result == PicassoMockup.RESULT_OK);
                    ivImageView.setImageBitmap(bitmap);
            }
        });
    }
}
