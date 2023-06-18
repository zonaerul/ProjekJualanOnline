package id.jualanonline;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Imgprosessor extends AsyncTask<String, String, Bitmap> {
    ImageView img;
    public Imgprosessor(ImageView img){
        this.img = img;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap b = null;
        try {
            InputStream input = new URL(strings[0]).openStream();

            b = BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
    }
}
