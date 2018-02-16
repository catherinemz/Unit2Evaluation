package mx.edu.utng.horarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AgrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agr);
    }

    public void nextActivity2(View view){
        startActivity(new Intent(this, Calendario.class ));
    }
}
