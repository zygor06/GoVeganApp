package app.govegan.com.br.goveganapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.govegan.com.br.goveganapp.Adapter.CustomListViewAdapter;
import app.govegan.com.br.goveganapp.R;
import app.govegan.com.br.goveganapp.activity.receitas.BiscoitinhosAveiaBananaActivity;
import app.govegan.com.br.goveganapp.activity.receitas.BoloChocolateActivity;
import app.govegan.com.br.goveganapp.activity.receitas.ChipBatataDoceActivity;
import app.govegan.com.br.goveganapp.activity.receitas.HamburguerActivity;
import app.govegan.com.br.goveganapp.activity.receitas.LeiteCocoActivity;
import app.govegan.com.br.goveganapp.activity.receitas.PaoQueijoActivity;
import app.govegan.com.br.goveganapp.activity.receitas.PateGraoBicoActivity;
import app.govegan.com.br.goveganapp.activity.receitas.SalpicaoVeganoActivity;
import app.govegan.com.br.goveganapp.activity.receitas.SorvetePacoquinhaActivity;
import app.govegan.com.br.goveganapp.helper.RowItem;

public class ReceitasActivity extends AppCompatActivity {

    public static final String[] titles = new String[] {
            "Biscoitinhos de Aveia e Banana",
            "Bolo de Chocolate",
            "Chips de Batata Doce",
            "Hamburguer Vegano",
            "Leite de Coco caseiro",
            "Pão de Queijo Vegano",
            "Patê de Grão de Bico",
            "Salpicão Vegano",
            "Sorvete de Paçoquinha"
    };

    public static final Integer[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9
    };


    private Toolbar toolbar;
    ListView listView;
    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Receitas");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i]);
            rowItems.add(item);
        }

        listView = findViewById(R.id.list_receitas);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(ReceitasActivity.this, BiscoitinhosAveiaBananaActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ReceitasActivity.this, BoloChocolateActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ReceitasActivity.this, ChipBatataDoceActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(ReceitasActivity.this, HamburguerActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ReceitasActivity.this, LeiteCocoActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(ReceitasActivity.this, PaoQueijoActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(ReceitasActivity.this, PateGraoBicoActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(ReceitasActivity.this, SalpicaoVeganoActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(ReceitasActivity.this, SorvetePacoquinhaActivity.class));
                        break;

                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
