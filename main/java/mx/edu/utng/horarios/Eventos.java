package mx.edu.utng.horarios;

/**
 * Created by Catherine on 2/16/2018.
 */

public class Eventos {
    private int imageId;
    private String dia;
    private String hora;

    public Eventos(int imageId, String dia, String hora){
        this.imageId = imageId;
        this.dia = dia;
        this.hora = hora;
    }

    public Eventos(){
        this (R.mipmap.ic_launcher_round, "unnamed", "unstablished");
    }

    public int getImageId(){
        return imageId;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }
}
