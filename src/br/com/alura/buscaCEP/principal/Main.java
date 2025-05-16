package br.com.alura.buscaCEP.principal;

import br.com.alura.buscaCEP.modelo.EnderecoCompleto;
import br.com.alura.buscaCEP.modelo.EnderecoJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu CEP: ");
        int cep = scanner.nextInt();
        String endereco = "https://viacep.com.br/ws/"+ cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

         String json = response.body();
         EnderecoJson enderecoJson = gson.fromJson(json, EnderecoJson.class);
         EnderecoCompleto enderecoCompleto = new EnderecoCompleto(enderecoJson);

         System.out.println("-------------------------------------");
         System.out.println(" Abaixo está o seu endereço completo");
         System.out.println("-------------------------------------");
         System.out.println(enderecoCompleto);
         System.out.println("-------------------------------------\n");

        FileWriter escrita = new FileWriter("CEP.json");
        escrita.write(gson.toJson(enderecoCompleto));
        escrita.close();
        System.out.println("O seu arquivo CEP.json foi criado com sucesso!");
    }
}
