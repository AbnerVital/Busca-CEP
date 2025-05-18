package br.com.alura.buscaCEP.service;

import br.com.alura.buscaCEP.modelo.EnderecoJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public EnderecoJson buscaEndereco(String cep){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String endereco = "https://viacep.com.br/ws/"+ cep + "/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, EnderecoJson.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP");
        }
    }
}
