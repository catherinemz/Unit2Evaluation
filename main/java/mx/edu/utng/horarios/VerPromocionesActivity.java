package mx.edu.utng.horarios;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;

public class VerPromocionesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Promociones promociones[]={
            new Promociones(R.drawable.promo1),
            new Promociones(R.drawable.promo2),
            new Promociones(R.drawable.promo3),
            new Promociones(R.drawable.promo4)
    };
    private GridView grvPromociones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_promociones);

        grvPromociones = findViewById(R.id.grv_promociones);
        PromocionesAdapter adapter = new PromocionesAdapter(this, promociones);
        grvPromociones.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    static class ViewHolder{
        ImageView imvPhoto;
    }

    class PromocionesAdapter extends ArrayAdapter<Promociones>{
        public PromocionesAdapter(@NonNull Context context, Promociones[] data){
            super(context, R.layout.cell2_layout, data);
        }
        @NonNull

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell2_layout, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_thumbnail);

                cell.setTag(holder);
            }else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(promociones[position].getImageId());
            return cell;
        }
    }
}
