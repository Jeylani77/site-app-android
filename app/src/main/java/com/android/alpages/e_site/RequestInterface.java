package com.android.alpages.e_site;

import com.android.alpages.e_site.Model.Value;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("chantier_list.php")
    Call<Value> view();


    /*
    @POST("learn2crack-login-register/")
    Call<ServerResponse> operation(@Body ServerRequest request);

    @GET("medical_input.php")
    Call<String> saveAchats(@Query("numCNI") String numCNI, @Query("fullname") String fullname,
                            @Query("birthday") String birthday, @Query("ville") String ville,
                            @Query("location") String location, @Query("tel") String tel,
                            @Query("telurgence") String telurgence, @Query("gender") String gender,
                            @Query("groupeSanguin") String groupeSanguin, @Query("idAdmin") String idAdmin);

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> daftar(@Field("npm") String npm,
                       @Field("nama") String nama,
                       @Field("kelas") String kelas,
                       @Field("sesi") String sesi);


    @FormUrlEncoded
    @POST("update_patient.php")
    Call<String> ubah(@Field("numCNI") String numCNI,
                     @Field("fullname") String fullname,
                     @Field("location") String location,
                     @Field("tel") String tel,
                     @Field("telurgence") String telurgence);



    @FormUrlEncoded
    @POST("delete_patient.php")
    Call<String> hapus(@Field("numCNI") String numCNI);

    @FormUrlEncoded
    @POST("search_patient.php")
    Call<String> search(@Field("search") String search);

    */

}
