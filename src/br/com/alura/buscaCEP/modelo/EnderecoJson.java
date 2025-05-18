package br.com.alura.buscaCEP.modelo;

public record EnderecoJson(String cep, String logradouro, String bairro, String localidade, String uf, String estado) {
}
