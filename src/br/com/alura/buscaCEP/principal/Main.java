package br.com.alura.buscaCEP.principal;

import br.com.alura.buscaCEP.service.BuscaCep;
import br.com.alura.buscaCEP.modelo.EnderecoCompleto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BuscaCep buscaCep = new BuscaCep();

        EnderecoCompleto enderecoCompleto = new EnderecoCompleto(buscaCep.buscaEndereco());

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
