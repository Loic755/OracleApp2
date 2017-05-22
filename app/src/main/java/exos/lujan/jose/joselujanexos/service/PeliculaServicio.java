package exos.lujan.jose.joselujanexos.service;

import java.util.List;

import exos.lujan.jose.joselujanexos.model.Pelicula;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Quezacoo on 5/22/2017.
 */

public interface PeliculaServicio {
    @GET("/rs/msr/sub/MSISDN/6668901223/data/")
    //Call<List<Student>> getPeopleDetails();
    void getPelicula(Callback<List<Pelicula>> callback);
}