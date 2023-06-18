package id.jualanonline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DompetAdapter extends BaseAdapter {
    Context context;
    ArrayList<DompetText> array;
    private ImageView img;
    private TextView text;

    public DompetAdapter(Context context, ArrayList<DompetText> array){
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
        DompetText data = array.get(i);
        view = LinearLayout.inflate(context, R.layout.accustom, null);
        img = (ImageView)view.findViewById(R.id.acimage);
        text = view.findViewById(R.id.acname);
        img.setImageResource(data.getImages());
        text.setText(data.getActionText());
        return view;
    }
}
