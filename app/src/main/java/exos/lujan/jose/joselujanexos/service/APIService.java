package exos.lujan.jose.joselujanexos.service;

import android.util.Log;

import java.util.List;

import exos.lujan.jose.joselujanexos.model.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Quezacoo on 5/21/2017.
 */

public interface APIService {
    @GET("rs/msr/sub/MSISDN/6668901223/data/")
    Call<List<Student>> getPeopleDetails();
}