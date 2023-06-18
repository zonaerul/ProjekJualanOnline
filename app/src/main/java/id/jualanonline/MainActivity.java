package id.jualanonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private GridView grid_action;
    private ArrayList<AcData> array_action;
    private actioncustommain adapter_action;
    private GridView produk;
    private ArrayList<Data> array_produk;
    private acustom adapter_produk;
    private FloatingActionButton floatingbutton;
    private ImageView imgsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbarmain);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        grid_action = (GridView)findViewById(R.id.grida_action);
        array_action = new ArrayList<AcData>();
        array_action.add(new AcData("Pulsa",R.drawable.ic_pulsa));
        array_action.add(new AcData("Vocher",R.drawable.ic_vocher));
        array_action.add(new AcData("Game",R.drawable.ic_game));
        array_action.add(new AcData("Dompet",R.drawable.ic_dompet));
        adapter_action = new actioncustommain(this, array_action);
        grid_action.setAdapter(adapter_action);

        produk = (GridView)findViewById(R.id.grid_main_produk);
        produk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == MotionEvent.ACTION_MOVE;
            }
        });
        new Jsonprocessor(this, produk).execute("https://data2022.000webhostapp.com/produk/produk.json");
        imgsw = (ImageView)findViewById(R.id.image_ads_main);
        new Imgprosessor(imgsw).execute("https://mrlaptop.pk/wp-content/uploads/2021/11/lenovo-thinkpad-banner-mr-laptop.jpg");

    }
}