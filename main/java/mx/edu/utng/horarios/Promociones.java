package mx.edu.utng.horarios;

/**
 * Created by Catherine on 2/15/2018.
 */

public class Promociones {
    private int imageId;

    public Promociones(int imageId){
        this.imageId = imageId;
    }

    public Promociones(){
        this (R.mipmap.ic_launcher_round);
    }

    public int getImageId() {
        return imageId;
    }
}
