package com.ta.retrofit;

import com.ta.services.ProdutoServices;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInicializador {

    private final Retrofit retrofit;
    public static String apiBaseUrl = "http://localhost:8080/estoque/";
    public RetrofitInicializador() {

        retrofit = new Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ProdutoServices getProduto(){
        return retrofit.create(ProdutoServices.class);
    }

}