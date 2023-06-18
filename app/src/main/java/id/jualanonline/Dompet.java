package id.jualanonline;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Dompet extends AppCompatActivity {
    private GridView gridview_action, dompet_list_history;
    private ArrayList<DompetText> array_action;
    private DompetAdapter adapter_action;
    private ArrayList<DompetTextHistory1> array_list_history;
    private DompetAdapterHistory1 adapter_list_history;
    private ImageView dompet_ads;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dompet);

        gridview_action = (GridView)findViewById(R.id.gridview_dompet_action);
        array_action = new ArrayList<DompetText>();
        array_action.add(new DompetText("Isi Saldo",R.drawable.ic_dompet));
        array_action.add(new DompetText("Bayar",R.drawable.ic_launcher_background));
        array_action.add(new DompetText("Transfer",R.drawable.ic_launcher_background));
        array_action.add(new DompetText("Progress",R.drawable.ic_launcher_background));
        adapter_action = new DompetAdapter(this, array_action);
        gridview_action.setAdapter(adapter_action);

        //list cardview history
        dompet_list_history = findViewById(R.id.dompet_list_history);
        array_list_history = new ArrayList<DompetTextHistory1>();
        array_list_history.add(new DompetTextHistory1("+ Rp10.000",R.drawable.ic_history_24,"18/06/2023","",""));
        array_list_history.add(new DompetTextHistory1("+ Rp5.000",R.drawable.ic_history_24,"18/06/2023","",""));
        array_list_history.add(new DompetTextHistory1("+ Rp2.000",R.drawable.ic_history_24,"18/06/2023","",""));
        array_list_history.add(new DompetTextHistory1("+ Rp50.000",R.drawable.ic_history_24,"18/06/2023","",""));
        array_list_history.add(new DompetTextHistory1("- Rp60.000",R.drawable.ic_history_24,"18/06/2023","",""));
        adapter_list_history = new DompetAdapterHistory1(this, array_list_history);
        dompet_list_history.setAdapter(adapter_list_history);


        dompet_ads = (ImageView)findViewById(R.id.dompet_ads);
        new Imgjson(this, dompet_ads,"dompet_ads").execute("https://data2022.000webhostapp.com/dompet/ads.json");
    }
}
