package mx.edu.utng.horarios;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Horarios[] horarios = {
            new Horarios(R.drawable.lunes, "Lunes", "Cerrado"),
            new Horarios(R.drawable.martes, "Martes", "9:00 pm - 5:00 am"),
            new Horarios(R.drawable.miercoles, "Miércoles", "Cerrado"),
            new Horarios(R.drawable.jueves, "Jueves", "9:00 pm - 3:00 am"),
            new Horarios(R.drawable.viernes, "Viernes", "9:00 pm - 5:00 am"),
            new Horarios(R.drawable.sabado, "Sábado", "9:00 pm - 5:00 am"),
            new Horarios(R.drawable.domingo, "Domingo", "9:00 pm - 3:00 am")
    };
    private ListView lsvHorarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvHorarios = findViewById(R.id.lsv_horarios);
        HorariosAdapter adapter = new HorariosAdapter(this, horarios);
        lsvHorarios.setAdapter(adapter);

        lsvHorarios.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        String selectedOption = ((Horarios) adapterView.getItemAtPosition(i)).getDia();
        Toast.makeText(this, "You selected: "+selectedOption, Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder{
        TextView txvDia;
        TextView txvHora;
        ImageView imvDia;
    }

    class HorariosAdapter extends ArrayAdapter<Horarios>{
        public HorariosAdapter(@NonNull Context context, Horarios[] data){
            super(context, R.layout.cell_layout, data);
        }
        @NonNull

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell_layout, null);

                holder = new ViewHolder();
                holder.imvDia = cell.findViewById(R.id.imv_dia);
                holder.txvDia = cell.findViewById(R.id.txv_dia_name);
                holder.txvHora = cell.findViewById(R.id.txv_hora);

                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvDia.setImageResource(horarios[position].getImageId());
            holder.txvDia.setText(horarios[position].getDia());
            holder.txvHora.setText(horarios[position].getHora());
            return cell;
        }
    }

    public void nextActivity(View view){
        startActivity(new Intent(this, AgrActivity.class ));
        finish();
    }
}
