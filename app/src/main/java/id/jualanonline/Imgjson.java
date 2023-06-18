package id.jualanonline;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Imgjson extends AsyncTask<String, String, String> {
    Context context;
    ImageView img;
    String nameObject,id;
    public Imgjson(Context context, ImageView img, String nameObject){
        this.context = context;
        this.nameObject = nameObject;
        this.img = img;
    }

    @Override
    protected String doInBackground(String... strings) {
        ArrayList<Data> data = new ArrayList<Data>();
        HttpHandler handler = new HttpHandler();
        String url = handler.makeString(strings[0]);
        String images = null;
        try {
            JSONObject obj = new JSONObject(url);
            JSONArray jarray = obj.getJSONArray(nameObject);
            for (int i = 0; i < jarray.length(); i++){
                JSONObject target= jarray.getJSONObject(i);
                id = target.getString("id");
                images = target.getString("images");
                System.out.println("images loading selesai");
            }
        } catch (JSONException e) {
            System.out.println("Json error "+e);
        }
        return images;
    }

    @Override
    protected void onPostExecute(String data) {
        new Imgprosessor(img).execute(data);
        System.out.println("images json => id{"+id+"}");
        System.out.println("images json => img{"+data+"}");
    }
}
