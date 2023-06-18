package id.jualanonline;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
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

public class Jsonprocessor extends AsyncTask<String, String, ArrayList<Data>> {
    Context context;
    GridView list;
    public Jsonprocessor(Context context, GridView list){
        this.context = context;
        this.list = list;
    }

    @Override
    protected ArrayList<Data> doInBackground(String... strings) {
        ArrayList<Data> data = new ArrayList<Data>();
        HttpHandler handler = new HttpHandler();
        String url = handler.makeString(strings[0]);
        try {
            JSONObject obj = new JSONObject(url);
            JSONArray jarray = obj.getJSONArray("produk");
            for (int i = 0; i < jarray.length(); i++){
                JSONObject target= jarray.getJSONObject(i);
                String id = target.getString("id");
                String produk = target.getString("nama_produk");
                String harga = target.getString("harga_produk");
                String byuser = target.getString("username");
                String images = target.getString("images");
                String tanggal = target.getString("tanggal");
                data.add(new Data(byuser,produk,images,harga));
                System.out.println("loading selesai");
            }
        } catch (JSONException e) {
            System.out.println("Json error "+e);
        }
        return data;
    }

    @Override
    protected void onPostExecute(ArrayList<Data> data) {
        acustom adapter = new acustom(context, data);
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);

    }
}
