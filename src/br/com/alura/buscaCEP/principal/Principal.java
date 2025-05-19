package br.com.alura.buscaCEP.principal;

import br.com.alura.buscaCEP.service.BuscaCep;
import br.com.alura.buscaCEP.modelo.EnderecoCompleto;
import br.com.alura.buscaCEP.service.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BuscaCep buscaCep = new BuscaCep();
        System.out.println("Digite um número de CEP para consulta: ");
        var cep = scanner.nextLine();
        EnderecoCompleto enderecoCompleto = new EnderecoCompleto(buscaCep.buscaEndereco(cep));

        try {
            System.out.println("-------------------------------------");
            System.out.println(" Abaixo está o seu endereço completo");
            System.out.println("-------------------------------------");
            System.out.println(enderecoCompleto);
            System.out.println("-------------------------------------\n");
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(enderecoCompleto);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }












    }
}
