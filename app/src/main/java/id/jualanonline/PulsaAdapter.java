package id.jualanonline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PulsaAdapter extends BaseAdapter {
    Context context;
    ArrayList<PulsaText> array;
    private TextView nominal, harga;

    public PulsaAdapter(Context context, ArrayList<PulsaText> array){
        this.context = context;
        this.array = array;
    }
    @Override
    public int getCount() {
        return array.size();
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
        PulsaText data = array.get(i);
        view = LinearLayout.inflate(context, R.layout.pulsa_custom, null);
        nominal = (TextView)view.findViewById(R.id.pulsa_custom_nominal);
        harga = (TextView) view.findViewById(R.id.pulsa_custom_bayar);
        nominal.setText("Pulsa "+data.getNominal());
        harga.setText("Bayar "+data.getBayar());
        return view;
    }
}
