package com.android.alpages.e_site.ApiRest;

import com.android.alpages.e_site.Model.Activite_chantier;
import com.android.alpages.e_site.Model.Chantier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("chantier_list.php")
        //Call<StudentsResponse> getStudentData();
    Call<List<Chantier>> getChantierJson();

    @GET("activite_chantier.php")
        //Call<StudentsResponse> getStudentData();
    Call<List<Activite_chantier>> getRapportJson();
/*
    @POST("students")
    @FormUrlEncoded
    Call<Student> saveStudent(@Field("name") String name);

    @PUT("students/{id}")
    @FormUrlEncoded
    Call<Student> updateStudent(@Path("id") int id,
                                @Field("name") String name);

    @DELETE("students/{id}")
    Call<Student> deleteStudent(@Path("id") int id);

    */

}
