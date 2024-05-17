package br.org.serratec.streamer.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumoAPI {
	
	public static String buscaDados(String endereco) {
		HttpClient client = HttpClient.newHttpClient();
		//static pra n ficar instanciando
		HttpRequest request = HttpRequest.newBuilder()
			      .uri(URI.create(endereco))
			      .build();
			
		HttpResponse<String> response = null;
	
				try {
					response = client.send(request, BodyHandlers.ofString());
				} catch (IOException | InterruptedException e) {
					
					e.printStackTrace();
				}
			
				return response.body(); 
	}
	
	public static String obterDados(String titulo) {
		String endereco = "https://www.omdbapi.com/?t=" + titulo.replace(" ", "+")
		+ "&apikey=digitesuakey"; //+ System.getenv($Variaveldeambiente)
		
			
		return buscaDados(endereco); //devolver o JSON
	}

	public static String obterDados(String titulo, int temporada) {
		String endereco = "https://www.omdbapi.com/?t=" + titulo.replace(" ", "+")
		+ "&season=" + temporada + "&apikey=digitesuakey";
		
		return buscaDados(endereco);
	}
}
