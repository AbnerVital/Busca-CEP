package br.com.alura.buscaCEP.service;

import br.com.alura.buscaCEP.modelo.EnderecoCompleto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void salvaJson(EnderecoCompleto enderecoCompleto) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(enderecoCompleto.getCep()+ ".json");
        escrita.write(gson.toJson(enderecoCompleto));
        escrita.close();
        System.out.println("O seu arquivo " + enderecoCompleto.getCep() +".json foi criado com sucesso!");
    }
}
