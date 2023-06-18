package id.jualanonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DompetAdapterHistory1 extends BaseAdapter {
    Context context;
    ArrayList<DompetTextHistory1> array;
    TextView hiatory_nominal, date;
    ImageView image;
    public DompetAdapterHistory1(Context context, ArrayList<DompetTextHistory1> array){
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
        DompetTextHistory1 data = array.get(i);
        view = LayoutInflater.from(context).inflate(R.layout.dompet_custom, null);
        hiatory_nominal = view.findViewById(R.id.history_nominal);
        date = view.findViewById(R.id.history_date);
        hiatory_nominal.setText(data.getHistory());
        date.setText(data.getWaktu());
        image = view.findViewById(R.id.history_icon);
        image.setImageResource(data.getIcon());
        return view;
    }
}
