package com.kp.picassomockup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PicassoMockup {

    public static final int RESULT_OK  = 200;

    public interface OnImageListener {
        public void onImageLoaded(Bitmap bitmap, int result);
    }

    public static void load(String url, OnImageListener listener) {
        new DownloadImageTask(url, listener).execute();
    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        String url;
        OnImageListener listener;

        public DownloadImageTask(String url, OnImageListener listener) {
            this.url = url;
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL urlStr = null;
            InputStream inputStream = null;
            try {
                urlStr = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlStr.openConnection();
                connection.connect();
                inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (listener != null)
                listener.onImageLoaded(bitmap, RESULT_OK);
        }
    }
}
