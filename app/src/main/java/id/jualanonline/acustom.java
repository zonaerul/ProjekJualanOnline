package id.jualanonline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class acustom extends BaseAdapter {


    private TextView nama_produk, harga_produk;
    private ImageView image;
    private final ArrayList<Data> data;
    private Context context;
   public acustom(Context context, ArrayList<Data> data){
       this.context = context;
       this.data = data;
   }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       Data out = data.get(i);
       view = LinearLayout.inflate(context, R.layout.listac, null);
       nama_produk = view.findViewById(R.id.namaproduk);
       harga_produk = view.findViewById(R.id.hargaproduk);
       String namaproduk_cut = out.getNamaproduk().toString();
       String cut = null;
       if (namaproduk_cut.length() > 20){
           cut = namaproduk_cut.substring(0, 20) + "...";
       }else{
           cut = namaproduk_cut;
       }
       nama_produk.setText(cut);
       harga_produk.setText(out.getHarga());
       image = view.findViewById(R.id.imgproduk);
       new Imgprosessor(image).execute(out.getImages());
        return view;
    }
}
