package exos.lujan.jose.joselujanexos.service;

import org.simpleframework.xml.ElementList;
import org.w3c.dom.Comment;

import java.util.List;

import exos.lujan.jose.joselujanexos.model.Pelicula;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Quezacoo on 5/22/2017.
 */

public interface PeliculaServicio {
    @GET("/rs/msr/sub/MSISDN/6668901223/data/")
    void getPelicula(Callback<List<Pelicula>> callback);

}