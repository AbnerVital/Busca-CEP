package br.com.alura.buscaCEP.modelo;

public class EnderecoCompleto {
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String estado;

    public EnderecoCompleto (EnderecoJson enderecoJson){
        this.rua = enderecoJson.logradouro();
        this.bairro = enderecoJson.bairro();
        this.cidade = enderecoJson.localidade();
        this.uf = enderecoJson.uf();
        this.estado = enderecoJson.estado();
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
