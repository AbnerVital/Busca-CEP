package br.com.alura.buscaCEP.modelo;

public class EnderecoCompleto {
    private final String cep;
    private final String rua;
    private final String bairro;
    private final String cidade;
    private final String uf;
    private final String estado;

    public EnderecoCompleto (EnderecoJson enderecoJson){
        this.cep = enderecoJson.cep();
        this.rua = enderecoJson.logradouro();
        this.bairro = enderecoJson.bairro();
        this.cidade = enderecoJson.localidade();
        this.uf = enderecoJson.uf();
        this.estado = enderecoJson.estado();
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return  " Rua: " + rua +
                "\n Bairro: " + bairro +
                "\n Cidade: " + cidade +
                "\n UF: " + uf +
                "\n Estado: " + estado;
    }
}
