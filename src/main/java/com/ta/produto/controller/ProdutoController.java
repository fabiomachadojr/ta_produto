package com.ta.produto.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.retrofit.RetrofitInicializador;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	Boolean resposta = false;
	
	Map<Float, Integer> mapaProdutos  = new HashMap<Float, Integer>() {{
	    put(1f, 13);
	    put(2f, 30);
	}};
	
	@GetMapping
	public ResponseEntity<Boolean> produtos() {
		
			return ResponseEntity.ok(true);
		
	}
	
	@GetMapping("/executalote")
	public ResponseEntity<Boolean> executaLoteComprasAcima10() {
		
			return ResponseEntity.ok(true);
		
	}
	
	@GetMapping("/comprar")
	public ResponseEntity<Boolean> comprar(@RequestParam("produto") String produto, @RequestParam("quantidade") int quantidade) throws InterruptedException {
		
		final Call<Boolean> p = new RetrofitInicializador().getProduto().comprar(produto, quantidade);
		p.enqueue(new Callback<Boolean>() {
			
			@Override
			public void onResponse(Call<Boolean> call, Response<Boolean> response) {
				resposta = response.body();
				
			}
			
			@Override
			public void onFailure(Call<Boolean> call, Throwable t) {
				System.out.println(t.getMessage());
				
			}
		});
		
		TimeUnit.SECONDS.sleep(3);
		
		if(resposta) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(false);
		}
		
			
		
	}

}
