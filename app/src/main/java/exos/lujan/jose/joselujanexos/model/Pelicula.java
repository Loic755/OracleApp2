package exos.lujan.jose.joselujanexos.model;

/**
 * Created by Quezacoo on 5/22/2017.
 */

public class Pelicula {
    private int Id;
    private String titulo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

}
