package br.com.alura.buscaCEP.service;

import br.com.alura.buscaCEP.modelo.EnderecoJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaCep {
    public EnderecoJson buscaEndereco(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu CEP: ");
        int cep = scanner.nextInt();
        String endereco = "https://viacep.com.br/ws/"+ cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP");
        }

        String json = response.body();
        EnderecoJson enderecoJson = gson.fromJson(json, EnderecoJson.class);
        return enderecoJson;
    }
}
