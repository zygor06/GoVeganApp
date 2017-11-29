package app.govegan.com.br.goveganapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import app.govegan.com.br.goveganapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @BindView(R.id.oque)
    ImageView oque;
    @BindView(R.id.receitas)
    ImageView receitas;
    @BindView(R.id.membros)
    ImageView membros;

    @Override
    protected void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.oque, R.id.receitas, R.id.membros})
    public void abrirActivity(View view){
        Intent i = null;
        switch (view.getId()){
            case R.id.oque:
                i = new Intent(MainActivity.this, DetalhesActivity.class);
                break;
            case R.id.receitas:
                i = new Intent(MainActivity.this, ReceitasActivity.class);
                break;
            case R.id.membros:
                i = new Intent(MainActivity.this, MembrosActivity.class);
                break;
        }

        startActivity(i);
    }

}
