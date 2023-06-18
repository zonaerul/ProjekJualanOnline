package id.jualanonline;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class actioncustommain extends BaseAdapter {

    ArrayList<AcData> array;
    Context context;
    private ImageView acimg;
    private TextView acname;

    public actioncustommain(Context context, ArrayList<AcData> array){
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
        view = LinearLayout.inflate(context, R.layout.accustom, null);
        final AcData data = array.get(i);
        acimg = (ImageView)view.findViewById(R.id.acimage);
        acimg.setImageResource(data.getImg());
        acname = (TextView)view.findViewById(R.id.acname);
        acname.setText(data.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Pulsa { onClick }");
                if (data.getName().equals("Pulsa")){
                    Intent i = new Intent(context, Pulsa.class);
                    context.startActivity(i);
                }else if (data.getName().equals("Dompet")){
                    Intent i = new Intent(context, Dompet.class);
                    context.startActivity(i);
                }
            }
        });
        return view;
    }
}
