package mx.edu.utng.horarios;

/**
 * Created by Catherine on 2/13/2018.
 */

public class Horarios {
    private int imageId;
    private String dia;
    private String hora;

    public Horarios(int imageId, String dia, String hora){
        this.imageId = imageId;
        this.dia = dia;
        this.hora = hora;
    }

    public Horarios(){
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
