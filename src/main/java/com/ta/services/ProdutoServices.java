package com.ta.services;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProdutoServices {

    @GET("comprar")
    Call<Boolean> comprar(@Query("produto") String produto, @Query("quantidade") int quantidade);
    
}
