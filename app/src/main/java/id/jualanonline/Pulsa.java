package id.jualanonline;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Pulsa extends AppCompatActivity {
    private GridView grid;
    private ArrayList<PulsaText> array;
    private PulsaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pulsa);

        grid = (GridView)findViewById(R.id.pulsa_gridview);
        array = new ArrayList<PulsaText>();
        array.add(new PulsaText("5rb","0","7rb"));
        array.add(new PulsaText("10rb","0","12rb"));
        array.add(new PulsaText("20rb","0","22rb"));
        array.add(new PulsaText("30rb","0","32rb"));

        adapter = new PulsaAdapter(this, array);
        grid.setAdapter(adapter);
    }
}
